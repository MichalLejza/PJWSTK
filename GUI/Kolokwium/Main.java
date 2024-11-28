package GUI.Kolokwium;

import java.util.Arrays;
import java.util.Comparator;

class Nieruchomosc implements Comparable<Nieruchomosc>
{
    String dane;
    double powierzchnia;
    static int idIndex = 0;
    int id;

    public Nieruchomosc(String dane, double powierzchnia)
    {
        this.dane = dane;
        this.powierzchnia = powierzchnia;
        this.id = idIndex++;
    }

    public String toString()
    {
        return "" + dane + " powierzchnia mieszkania: " + powierzchnia + " id domu: " + id;
    }

    @Override
    public int compareTo(Nieruchomosc o)
    {
        if(o.powierzchnia > this.powierzchnia)
            return 1;
        else if(o.powierzchnia < this.powierzchnia)
            return -1;
        else
        {
            if(o.dane.compareTo(this.dane) < 0)
                return 1;
            else if(o.dane.compareTo(this.dane) > 0)
                return -1;
            else
            {
                return this.id - o.id;
            }
        }
    }
}

class compareDom implements Comparator<Dom>
{
    public int compare(Dom o1, Dom o2)
    {
        if(o1.powierzchnia > o2.powierzchnia)
            return 1;
        else if(o1.powierzchnia < o2.powierzchnia)
            return -1;
        else
        {
            if(o2.dane.compareTo(o1.dane) > 0)
                return 1;
            else if(o2.dane.compareTo(o1.dane) < 0)
                return -1;
            else
            {
                if(o2.iloscPieter > o1.iloscPieter)
                    return 1;
                else if(o2.iloscPieter < o1.iloscPieter)
                    return -1;
                else
                    return o2.id - o1.id;
            }
        }
    }
}
class Dom extends Nieruchomosc
{
    int iloscPieter;

    public Dom(String dane, double powierzchnia, int iloscPieter)
    {
        super(dane, powierzchnia);
        this.iloscPieter = iloscPieter;
    }

    public String toString()
    {
        return "" + dane + " powierzchnia mieszkania: " + powierzchnia + " id domu: " + id + " ilosc pieter: " + iloscPieter;
    }
}

class compareMieszkania implements Comparator<Mieszkanie>
{
    public int compare(Mieszkanie o1, Mieszkanie o2)
    {
        if(o1.powierzchnia > o2.powierzchnia)
            return 1;
        else if(o1.powierzchnia < o2.powierzchnia)
            return -1;
        else
        {
            if(o2.dane.compareTo(o1.dane) > 0)
                return 1;
            else if(o2.dane.compareTo(o1.dane) < 0)
                return -1;
            else
            {
                if(o2.liczbaPokoi > o1.liczbaPokoi)
                    return 1;
                else if(o2.liczbaPokoi < o1.liczbaPokoi)
                    return -1;
                else
                    return o2.id - o1.id;
            }
        }
    }
}

class Mieszkanie extends Nieruchomosc
{
    int liczbaPokoi;

    public Mieszkanie(String dane, double powierzchnia, int liczbaPokoi)
    {
        super(dane, powierzchnia);
        this.liczbaPokoi = liczbaPokoi;
    }

    public String toString()
    {
        return dane + " powierzchnia mieszkania: " + powierzchnia + " id domu : " + id + " liczba pokoi: " + this.liczbaPokoi;
    }

}

public class Main
{
    public static void main(String[] args)
    {
        Nieruchomosc[] nieruchomosci= {new Nieruchomosc("Janusz Kowalski", 90), new Nieruchomosc("Janusz Kowalski", 90.4),};
        Arrays.sort(nieruchomosci);
        System.out.println(Arrays.asList(nieruchomosci));
        System.out.println();

        Dom[] domy = {new Dom("Anna lewandowska", 50.8, 6), new Dom("Anna lewandowska", 50.8, 7)};
        Arrays.sort(domy, new compareDom());
        System.out.println(Arrays.asList(domy));
        System.out.println();

        Mieszkanie[] mieszkania = {new Mieszkanie("Robert Lewandowski", 87.9, 3), new Mieszkanie("Franciszek Jajko", 123.8, 6)};
        Arrays.sort(mieszkania, new compareMieszkania());
        System.out.println(Arrays.asList(mieszkania));
        System.out.println();

        Object[] objekty = {new Nieruchomosc("Janusz Kowalski", 90.2),
                new Dom("Anna lewandowska", 56.8, 6),
                new Mieszkanie("Robert Lewandowski", 87.9, 3)};
        Arrays.sort(objekty);
        System.out.println(Arrays.asList(objekty));
    }
}
