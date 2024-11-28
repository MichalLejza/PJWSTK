package GUI.Cwiczenia5;

import java.util.*;

import static java.lang.System.out;

class Osoba implements Comparable<Osoba>
{
    String imie;
    int rokUrodzenia;

    public Osoba(String imie, int rokUrodzenia)
    {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public static boolean wKolekcji(Collection<Osoba> kol, String imie, int rokUrodzenia)
    {
        return kol.contains(new Osoba(imie, rokUrodzenia));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Osoba))
            return false;
        Osoba o = (Osoba)obj;
        return (this.rokUrodzenia == o.rokUrodzenia && this.imie.equals(o.imie));
    }

    public int hashCode()
    {
        return 1;
    }

    @Override
    public int compareTo(Osoba o) {
        return this.imie.compareTo(o.imie) + this.rokUrodzenia - o.rokUrodzenia;
    }
}


public class Zadanie9
{
    public static void main(String[] args)
    {
        List<Osoba> lista = Arrays.asList(
                new Osoba("Anna", 2000),
                new Osoba("Bartek", 2001),
                new Osoba("Maria", 2002)
        );
        out.println(Osoba.wKolekcji(lista, "Bartek", 2001));
        out.println(Osoba.wKolekcji(lista, "Daria", 2002));
        Set<Osoba> tZbior = new TreeSet<>(lista);
        out.println(Osoba.wKolekcji(tZbior, "Bartek", 2001));
        out.println(Osoba.wKolekcji(tZbior, "Daria", 2002));
        Set<Osoba> hZbior = new HashSet<>(lista);
        out.println(Osoba.wKolekcji(hZbior, "Bartek", 2001));
        out.println(Osoba.wKolekcji(hZbior, "Daria", 2002));
    }
}
