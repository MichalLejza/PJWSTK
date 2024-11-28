package GUI.Cwiczenia4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum Kryterium{wiek, imie};

class Osoba implements Comparable<Osoba>
{
    private String imie;
    private int wiek;

    public Osoba(String imie, int wiek)
    {
        this.imie = imie;
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

    @Override
    public String toString() {
        return "(" + getImie() + ", " + getWiek() +")";
    }

    @Override
    public int compareTo(Osoba o1)
    {
        for(int i = 0; i < Math.min(o1.getImie().length(), this.getImie().length()); i++)
        {
            if(o1.getImie().charAt(i) < this.getImie().charAt(i))
                return 1;
            else if(o1.getImie().charAt(i) > this.getImie().charAt(i))
                return -1;
        }
        if(o1.getWiek() < this.getWiek())
        {
            return 1;
        }
        else if (o1.getWiek() > this.getWiek())
        {
            return -1;
        }
        return 0;
    }
}

class KomparatorOsob implements java.util.Comparator<Osoba>
{
    Kryterium k;
    public KomparatorOsob(Kryterium k)
    {
        this.k = k;
    }

    @Override
    public int compare(Osoba o1, Osoba o2)
    {
        int wynik = 0;
        if(this.k == Kryterium.wiek)
        {
            if(o1.getWiek() > o2.getWiek())
            {
                wynik = 1;
            }
            else if (o1.getWiek() == o2.getWiek())
            {
                wynik = 0;
            }
            else
                wynik = -1;
        }
        else if(this.k == Kryterium.imie)
        {
            for(int i = 0; i < Math.min(o1.getImie().length(), o2.getImie().length()); i++)
            {
                if(o1.getImie().charAt(i) > o2.getImie().charAt(i))
                    return 1;
                else if(o1.getImie().charAt(i) < o2.getImie().charAt(i))
                    return -1;
            }
        }
        return wynik;
    }
}

public class Zadanie7
{
    public static void main(String[] args) {

        // tworzenie listy osób
        List<Osoba> lista = Arrays.asList(
                new Osoba("Anna", 23),
                new Osoba("Maria", 22),
                new Osoba("Anna", 20),
                new Osoba("Wojciech", 21)
        );
        // sortowanie według podanego komparatora (po imię)
        Collections.sort(lista, new KomparatorOsob(Kryterium.imie));
        System.out.println(lista);

        // sortowanie według podanego komparatora (po wieku)
        Collections.sort(lista, new KomparatorOsob(Kryterium.wiek));

        // lub zamiast komparatora "po wieku" napisać wyrażenie lambda w miejscu /* ... */
        Collections.sort(lista, (o1, o2) -> (o1.getWiek() - o2.getWiek()));
        System.out.println(lista);

        // sortowanie według porządku naturalnego określonego w klasie Osoba
        Collections.sort(lista);
        System.out.println(lista);
    }
}
