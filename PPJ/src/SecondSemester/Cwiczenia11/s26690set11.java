package PPJ.SecondSemester.Cwiczenia11;

import java.util.Scanner;

class Telefon
{
    String interfejsKomunikacyjny, color;

    void zadzwon(String numer)
    {
        System.out.println("Dzwonimy pod numer: " + numer);
    }

    void wyswietlHistoriePolaczen()
    {
        System.out.println("Brak historii");
    }
}

class Komorka extends Telefon
{
    String[] ostatniePolaczenia;

    void wyswietlHistoriePolaczen()
    {
        for(String t : ostatniePolaczenia)
            System.out.println(t);
    }
}

class Osoba
{
    String imie, nazwisko, numer;
}

class Smartfon extends Komorka
{
    Osoba[] znajomi;

    void wyswietlHistoriePolaczen()
    {
        for(Osoba o : znajomi)
            System.out.println(o.imie + " " + o.nazwisko + " " + o.numer);
    }
}

class DetektorDymu
{
    void sprawdz()
    {
        
    }
}

class Alarm extends Exception
{

}

class DzielPrzezLiczbe
{
    static double podziel(int x, int y)
    {
        if(x == y)
        {
            throw new ArithmeticException();
        }
        return (double) x / y;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe, przez którą chcesz podzielić: ");
        int x = scanner.nextInt();
        System.out.println("Podaj liczbę którą chcesz podzielić");
        int y = scanner.nextInt();
        try
        {
            double wynik = podziel(x,y);
            System.out.print("Wynik dzielenia: ");
            System.out.println(wynik);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Dzielenie przez zero jest niedozwolone");
        }
    }
}

class Rakieta
{
    String nazwa;
    int wagaPaliwa;

}

public class s26690set11
{

    public static void main(String[] args)
    {

    }
}
