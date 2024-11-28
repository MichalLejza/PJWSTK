package zad1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Currency;
import java.util.Locale;

public class Service {
    private final Locale locale;

    private final String country;

    public Service(String country)
    {
        country = country.replaceAll("\\s", "");
        this.locale = getLocaleFromNameOfCountry(country);
        this.country = country;
    }

    public String getCountry()
    {
        return this.country;
    }

    private Locale getLocaleFromNameOfCountry(String country)
    {
        for (Locale locale : Locale.getAvailableLocales())
            if (country.equals(locale.getDisplayCountry()))
                return locale;
        return null;
    }

    private JsonElement getJsonFile(String urlPath) throws Exception
    {
        URL base = new URL(urlPath);
        URLConnection request = base.openConnection();
        request.connect();
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(new InputStreamReader(request.getInputStream()));
    }

    public String getWeather(String city)
    {
        String weather = null;
        city = city.replaceAll("\\s", "");
        try
        {
            JsonElement jsonElement = getJsonFile("https://api.openweathermap.org/data/2.5/weather?q=" +city+","+locale.getCountry()+"&appid=231b4233d47e8e0b834590b2703e3976&units=metric");
            weather = jsonElement.toString();
        }
        catch (Exception ignored) {}
        return weather;
    }

    public Double getRateFor(String currency)
    {
        Double rate = null;
        try
        {
            JsonElement jsonElement = getJsonFile("http://api.exchangerate.host/live?access_key=a36fdc602e5af689624ae00ddce52301&source=" + currency);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            rate = jsonObject.getAsJsonObject("quotes").get(currency + Currency.getInstance(locale)).getAsDouble();
        }
        catch (Exception ignored) {}
        return rate;
    }

    private Double getRateForCurrency(JsonElement jsonElement, String countryCode)
    {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        JsonObject firstObject = jsonArray.get(0).getAsJsonObject();
        JsonArray ratesArray =  firstObject.getAsJsonArray("rates");

        for (int i = 0; i < ratesArray.size(); i++)
        {
            JsonObject firstRate = ratesArray.get(i).getAsJsonObject();
            String code = firstRate.get("code").getAsString();
            double mid = firstRate.get("mid").getAsDouble();
            if (countryCode.equals(code))
                return mid;
        }
        return null;
    }

    public Double getNBPRate()
    {
        if (this.country.equals("Poland"))
            return 1.0;
        Double rate = null;
        try
        {
            JsonElement jsonElement = getJsonFile("https://api.nbp.pl/api/exchangerates/tables/a/");
            rate = getRateForCurrency(jsonElement, Currency.getInstance(locale).toString());
        }
        catch (Exception ignored) {}
        return rate;
    }
}