package PPJ.SecondSemester.Projekt3;

import java.io.*;

public class S26690_p03
{
    public static void main(String[] args) throws IOException {
        Ssak []stadoOne = {
               new Wilk("Alfa", (short) 2009, false, "Dzikie", 1),
        new Wilk("Wilczur", (short) 2008, false, "Dzikie", 2),
        new Wilk("Wilczek", (short) 2020, true, "Dzikie", 3),
        new Wilk("Wilku", (short) 2020, true, "Dzikie", 4),
        new Wadera("Wilczyca", (short) 2008, false, 2),
        new Wadera("Gazela", (short) 2009, false, 2),
        new Wadera("Gryzelda", (short) 2018, true, 0),
        new Wadera("Frania", (short) 2019, true, 0)
        };

        Ssak []stadoTwo = {
                new Wilk("Alfa", (short) 2008, false, "Wesole", 1),
        new Wilk("Kajtek", (short) 2007, false, "Wesole", 2),
        new Wilk("Wilczurek", (short) 2020, true, "Wesole", 3),
        new Wilk("Mlody", (short) 2021, true, "Wesole", 4),
        new Wadera("Starsza", (short) 2010, false, 3),
        new Wadera("Wesola", (short) 2011, false, 1),
        new Wadera("Wilczka", (short) 2021, true, 0),
        new Wadera("Wilczunia", (short) 2022, true, 0)
        };

        FileOutputStream outputStream = new FileOutputStream("/Users/michallejza/IdeaProjects/PJWSTK/src/PPJ/Projekt3/wilk.txt");

        for(Ssak ssak : stadoOne)
            ssak.zapisz(outputStream);

        for(Ssak ssak : stadoTwo)
            ssak.zapisz(outputStream);

        Ssak [] ssaki = zaladuj("/Users/michallejza/IdeaProjects/PJWSTK/src/PPJ/Projekt3/wilk.txt");
    }

    public static Ssak[] addSsak(Ssak []ssaki, Ssak ssak)
    {
        Ssak []tab = new Ssak[ssaki.length + 1];
        for(int i = 0; i < ssaki.length; i++)
            tab[i] = ssaki[i];
        tab[ssaki.length] = ssak;
        return tab;
    }

    public static Ssak[] zaladuj(String sciezka) throws IOException
    {
        Ssak []ssaki = new Ssak[0];
        try( BufferedReader reader = new BufferedReader(new FileReader(sciezka)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                Ssak ssak;
                String[] words = line.split(",|;");
                if(words.length == 5)
                {
                    ssak = new Wilk(words[0].trim(), (short) Short.parseShort(words[1].trim()), Boolean.getBoolean(words[2].trim()), words[3].trim(), Integer.parseInt(words[4].trim()));
                }
                else
                {
                    ssak = new Wadera(words[0].trim(), (short) Short.parseShort(words[1].trim()), Boolean.getBoolean(words[2].trim()), Integer.parseInt(words[3].trim()));
                }
                ssaki = addSsak(ssaki, ssak);
            }
        }
        catch (IOException e)
        {
            Ssak []stadoOne = {
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wadera("Wilczyca", (short) 2018, true, 0),
                    new Wadera("Wilczyca", (short) 2018, true, 2),
                    new Wadera("Wilczyca", (short) 2018, true, 2),
                    new Wadera("Wilczyca", (short) 2018, true, 0)
            };

            Ssak []stadoTwo = {
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 1),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wilk("Wilczek", (short) 20, true, "Dzikie", 5),
                    new Wadera("Wilczyca", (short) 2018, true, 1),
                    new Wadera("Wilczyca", (short) 2018, true, 1),
                    new Wadera("Wilczyca", (short) 2018, true, 2),
                    new Wadera("Wilczyca", (short) 2018, true, 0)
            };

            FileOutputStream outputStream = new FileOutputStream("/Users/michallejza/IdeaProjects/PJWSTK/src/PPJ/Projekt3/wilk.txt");

            for(Ssak ssak : stadoOne)
                ssak.zapisz(outputStream);

            for(Ssak ssak : stadoTwo)
                ssak.zapisz(outputStream);
        }
        return ssaki;
    }
}

class Ssak
{
    private String imie;
    private short rokUrodzenia;
    private boolean mlody;

    Ssak(String imie, short rokUrodzenia, boolean mlody)
    {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
        this.mlody = mlody;
    }

    String przedstawSie()
    {
        return imie + ", " + rokUrodzenia + ", " + (mlody ? "mlody, " : "stary, ");
    }

    void zapisz(FileOutputStream outputStream) throws IOException
    {
        byte []bytes = przedstawSie().getBytes();
        outputStream.write(bytes);
        outputStream.write('\n');
    }
}

class Wadera extends Ssak
{
    private int iloscSzczeniat;
    private Ssak[] szczenieta;

    public Wadera(String imie, short rokUrodzenia, boolean mlody, int iloscSzczeniat)
    {
        super(imie, rokUrodzenia, mlody);
        this.iloscSzczeniat = iloscSzczeniat;
        this.szczenieta = new Ssak[iloscSzczeniat];
    }

    String przedstawSie()
    {
        String info = super.przedstawSie() + iloscSzczeniat;
        return info + ";";
    }

    void zapisz(FileOutputStream outputStream) throws IOException {
        byte []bytes = przedstawSie().getBytes();
        outputStream.write(bytes);
        outputStream.write('\n');
    }
}

class Wilk extends Ssak
{
    private String nazwaStada;
    private int pozcja;

    public Wilk(String imie, short rokUrodzenia, boolean mlody, String nazwaStada, int pozycja)
    {
        super(imie, rokUrodzenia, mlody);
        this.nazwaStada = nazwaStada;
        this.pozcja = pozycja;
    }

    String przedstawSie()
    {
        String info = super.przedstawSie() + nazwaStada + ", " + pozcja;
        return info + ";";
    }

    void zapisz(FileOutputStream outputStream) throws IOException
    {
        byte []bytes = przedstawSie().getBytes();
        outputStream.write(bytes);
        outputStream.write('\n');
    }
}