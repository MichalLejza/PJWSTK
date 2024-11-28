package PPJ.SecondSemester.Cwiczenia10;

class Kwadrat
{
    private int bok;
    public Kwadrat(int bok)
    {
        this.bok = bok;
    }
    public void show()
    {
        System.out.println("Pole Kwadratu: " + bok*bok);
        System.out.println("Objetosc Szescianu: " + bok*bok*bok);
    }
}

class Walec
{
    private double promien, wysokosc;
    public Walec(double promien, double wysokosc)
    {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }
    public void show()
    {
        System.out.println("Pole powierzchni podstawy: " + Math.PI * promien * promien);
        System.out.println("Objetosc walca: " + Math.PI * promien * promien * wysokosc);
    }
}

class Prostokat
{
    private int bok;
    private int drugiBok;
    public Prostokat(int bok, int drugiBok)
    {
        this.drugiBok = drugiBok;
        this.bok = bok;
    }
    public Prostokat(Prostokat prostokat)
    {
        this.drugiBok = prostokat.drugiBok;
        this.bok = prostokat.bok;
    }
    public void show()
    {
        System.out.println("Pole prostokatu: " + bok * drugiBok);
    }
    public int getBok()
    {
        return bok;
    }
    public int getDrugiBok()
    {
        return drugiBok;
    }
}

class Prostopadloscian extends Prostokat
{
    private int wysokosc;
    public Prostopadloscian(int bok, int drugiBok, int wysokosc)
    {
        super(bok, drugiBok);
        this.wysokosc = wysokosc;
    }
    public Prostopadloscian(Prostopadloscian prostopadloscian)
    {
        super(prostopadloscian.getBok(), prostopadloscian.getDrugiBok());
        this.wysokosc = prostopadloscian.wysokosc;
    }
    public void show()
    {
        System.out.println("Pole powierzchni prostopadloscianu: " + getBok()*getDrugiBok()*2 + getBok()*wysokosc*2 + getDrugiBok()*wysokosc*2);
        System.out.println("Objetosc prostopadloscianu: " + getDrugiBok() * getBok() * wysokosc);
    }
}

class Trojkat
{
    int bok;
    public Trojkat(int bok)
    {
        this.bok = bok;
    }
    public Trojkat(Trojkat trojkat)
    {
        this.bok = trojkat.bok;
    }
    public int getBok()
    {
        return bok;
    }
    public void show()
    {
        System.out.println("Pole trojkata: " + bok *bok * Math.sqrt(3) / 4);
    }
}

class Ostroslop extends Trojkat
{
    int wysokosc;
    public Ostroslop(int bok, int wysokosc)
    {
        super(bok);
        this.wysokosc = wysokosc;
    }
    public Ostroslop(Ostroslop ostroslop)
    {
        super(ostroslop.getBok());
        this.wysokosc = ostroslop.wysokosc;
    }
    public void show()
    {
        System.out.println("Pole powierzchni Ostroslupu: " + getBok() * getBok() * Math.sqrt(3) / 4 + 3 * wysokosc * getBok());
        System.out.println("Objetosc Ostroslupu" + 1/3 * getBok() * getBok() * Math.sqrt(3) / 4 * wysokosc);
    }
}

class Graniastoslup extends Trojkat
{
    int wysokosc;
    public Graniastoslup(int bok, int wysokosc)
    {
        super(bok);
        this.wysokosc = wysokosc;
    }
    public Graniastoslup(Graniastoslup graniastoslup)
    {
        super(graniastoslup.getBok());
        this.wysokosc = graniastoslup.wysokosc;
    }
    public void show()
    {
        System.out.println("Pole powierzhcni Graniastoslupu: " + getBok() * wysokosc * 3 + getBok() * getBok() * Math.sqrt(3) / 4 * wysokosc * 2);
        System.out.println("Objetosc Graniastoslupu: " + getBok() * getBok() * Math.sqrt(3) / 4 * wysokosc);
    }
}

class Drzewo
{
    boolean wiecznieZielone;
    int wysokosc;
    String przekrojDrzewa;
    public Drzewo(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa)
    {
        this.wysokosc = wysokosc;
        this.wiecznieZielone = wiecznieZielone;
        this.przekrojDrzewa = przekrojDrzewa;
    }

    public String toString()
    {
        return "Drzewo " + (wiecznieZielone ? "wiecznie zielone" : "NIE wiecznie zielone") + " o wysokosci " + wysokosc + " o przekroju " + przekrojDrzewa;
    }
}

class DrzewoIglaste extends Drzewo
{
    int iloscIgiel;
    double dlugoscSzyszki;
    public DrzewoIglaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int iloscIgiel, double dlugoscSzyszki)
    {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.iloscIgiel = iloscIgiel;
        this.dlugoscSzyszki = dlugoscSzyszki;
    }

    @Override
    public String toString()
    {
        return super.toString() + " iglaste o ilosci igiel rownej " + iloscIgiel + " i szyszkach o dlugosci "+ dlugoscSzyszki;
    }
}

class DrzewoLisciaste extends Drzewo
{
    int krztaltLiscia;
    public DrzewoLisciaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int krztaltLiscia)
    {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.krztaltLiscia = krztaltLiscia;
    }

    @Override
    public String toString() {
        return super.toString() + " lisciaste z lisciami o kztalcie " + krztaltLiscia;
    }
}

class DrzewoOwocowe extends Drzewo
{
    String nazwaOwoca;
    public DrzewoOwocowe(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, String nazwaOwoca)
    {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.nazwaOwoca = nazwaOwoca;
    }

    @Override
    public String toString()
    {
        return super.toString() + " owocowe " + nazwaOwoca;
    }
}

public class s26690set10
{
    public static void main(String[] args)
    {
        Kwadrat kwadrat = new Kwadrat(10);
        kwadrat.show();

        Walec walec = new Walec(4,5);
        walec.show();
    }
}
