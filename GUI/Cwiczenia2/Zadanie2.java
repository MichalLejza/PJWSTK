package GUI.Cwiczenia2;


abstract class Muzyk
{
    private String imie;
    private double czas;

    public Muzyk(String imie, double czas)
    {
        this.imie = imie;
        this.czas = czas;
    }

    public String toString()
    {
        return imie + ", czas = " + czas + " godz., stawka = " + stawka();
    }

    abstract String instrument();
    abstract double stawka();

    public static Muzyk maxHonorarium(Muzyk[] muzycy)
    {
        Muzyk maxH = muzycy[0];
        for(int i = 1; i < muzycy.length; i++)
            maxH = (maxH.czas * maxH.stawka() > muzycy[i].czas * muzycy[i].stawka() ? maxH : muzycy[i]);
        return maxH;
    }

    public String imie()
    {
        return imie;
    }

    public double czas()
    {
        return czas;
    }
}

class Skrzypek extends Muzyk
{
    public Skrzypek(String name, double czas)
    {
        super(name,czas);
    }

    public String instrument()
    {
        return "skrzypce";
    }

    public double stawka()
    {
        return 200.0;
    }
}

class Wiolonczelista extends Muzyk
{
    public Wiolonczelista(String name, double czas)
    {
        super(name,czas);
    }

    public String instrument()
    {
        return "wiolonczela";
    }

    public double stawka()
    {
        return 250.0;
    }
}

class Flecista extends Muzyk
{
    public Flecista(String name, double czas)
    {
        super(name,czas);
    }

    public String instrument()
    {
        return "flet";
    }

    public double stawka()
    {
        return 300.0;
    }
}

public class Zadanie2
{
    public static void main(String[] args)
    {

        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),	// Imie, czas wystapienia (w godz.)
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.imie() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));	// muzyk otrzymujący najwyższe honorarium za występ

    }
}
