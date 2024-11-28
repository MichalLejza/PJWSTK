package zad1;

/**
 *
 *  @author Lejza Michał S26690
 *
 */


public class Main {
    public static void main(String[] args)
    {
        Service s = new Service("Poland");
        String weatherJson = s.getWeather("Warsaw");
        Double rate1 = s.getRateFor("USD");
        Double rate2 = s.getNBPRate();
        javafx.application.Application.launch(App.class, weatherJson, rate1.toString(), rate2.toString(), s.getCountry());
    }
}
