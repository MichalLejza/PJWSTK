package zad1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class App extends javafx.application.Application
{
    Service service;

    private String getWeatherInfo(String json)
    {
        String info = "";
        JsonParser jsonParser= new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("weather");
        info += ("Sky condition : " + jsonArray.get(0).getAsJsonObject().get("main").getAsString() + "\n");
        info += ("Temperature   : " + jsonObject.get("main").getAsJsonObject().get("temp").getAsString() + "\n");
        info += ("Feels like    : " + jsonObject.get("main").getAsJsonObject().get("feels_like").getAsString() + "\n");
        info += ("Pressure      : " + jsonObject.get("main").getAsJsonObject().get("pressure").getAsString() + "\n");
        info += ("Humidity %    : " + jsonObject.get("main").getAsJsonObject().get("humidity").getAsString() + "\n");
        return info;
    }

    void loadPage(WebView browser, String city)
    {
        browser.getEngine().load("https://en.wikipedia.org/wiki/" + city);
    }

    @Override
    public void start(Stage stage)
    {
        service = new Service(getParameters().getRaw().get(3));

        WebView browser = new WebView();
        browser.getEngine().load("https://en.wikipedia.org/wiki/Main_Page");

        TextField countryTextField = new TextField("Poland");
        countryTextField.setPrefWidth(150);

        TextField cityTextField = new TextField("Warsaw");
        cityTextField.setPrefWidth(150);

        TextField currencyTextField = new TextField("USD");
        currencyTextField.setPrefWidth(50);

        Button getInfoButton = new Button("Upload");

        Label weatherLabel = new Label(getWeatherInfo(getParameters().getRaw().get(0)));
        weatherLabel.setFont(new Font(20));

        Label nbpInfoLabel = new Label("Current NBP value: ");
        nbpInfoLabel.setFont(new Font(20));

        Label currencyValueNBPLabel = new Label(getParameters().getRaw().get(2));
        currencyValueNBPLabel.setFont(new Font(20));

        Label currencyValueLabel = new Label(getParameters().getRaw().get(1));
        currencyValueLabel.setFont(new Font(20));

        getInfoButton.setOnAction(event ->
        {
            service = new Service(countryTextField.getText());
            loadPage(browser, cityTextField.getText());
            weatherLabel.setText(getWeatherInfo(service.getWeather(cityTextField.getText())));
            currencyValueNBPLabel.setText(service.getNBPRate().toString());
            currencyValueLabel.setText(service.getRateFor(currencyTextField.getText()).toString());
        });

        currencyTextField.setOnAction(event -> currencyValueLabel.setText(service.getRateFor(currencyTextField.getText()).toString()));

        HBox leftBoxWeather = new HBox(30);
        leftBoxWeather.setPadding(new Insets(0,10,0,10));
        leftBoxWeather.setPrefSize(400, 70);

        VBox inputCountryCity = new VBox(10);
        leftBoxWeather.setPadding(new Insets(0,10,0,10));

        VBox middleBoxNBP = new VBox(10);
        middleBoxNBP.setPadding(new Insets(0,10,0,10));
        middleBoxNBP.setPrefSize(200,70);

        VBox rightBoxCurrency = new VBox(10);
        rightBoxCurrency.setPrefSize(200, 70);
        rightBoxCurrency.setPadding(new Insets(0,10,0,10));

        inputCountryCity.getChildren().addAll(countryTextField, cityTextField, getInfoButton);
        leftBoxWeather.getChildren().addAll(inputCountryCity, weatherLabel);
        middleBoxNBP.getChildren().addAll(nbpInfoLabel, currencyValueNBPLabel);
        rightBoxCurrency.getChildren().addAll(currencyTextField, currencyValueLabel);

        BorderPane toolBar = new BorderPane();
        toolBar.setPrefHeight(140);
        toolBar.setStyle("-fx-border-color: black; -fx-border-width: 5px; -fx-background-color: yellow");
        toolBar.setLeft(leftBoxWeather);
        toolBar.setCenter(middleBoxNBP);
        toolBar.setRight(rightBoxCurrency);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setCenter(browser);

        Scene scene = new Scene(borderPane,800,700);
        stage.setTitle("TPO Application");
        stage.setWidth(800); stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
    }
}
