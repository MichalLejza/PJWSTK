package GUI.Cwiczenia3;


//*********************************************************************//
// Zadanie 5
//********************************************************************//

abstract class Figura implements Obliczenie
{
    protected int x;
    protected int y;

    public Figura(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    abstract String nazwaFigury();
    abstract void pozycja(int x, int y);

    public String toString()
    {
        return "";
    }
}

class Kolo extends Figura implements Obliczenie
{
    int promien;

    public Kolo(int x, int y, int promien)
    {
        super(x,y);
        this.promien = promien;
    }

    public String toString()
    {
        return nazwaFigury() + "\nSrodek - (" + super.x + "," + super.y + ")\nPromien - " + promien + "\n";
    }

    @Override
    public String nazwaFigury() {
        return "Kolo";
    }

    @Override
    public void pozycja(int x, int y)
    {
        boolean jestOk = false;
        double distance = Math.sqrt(Math.pow(Math.abs(x - super.x), 2) + Math.pow(Math.abs(y - super.y), 2));
        if(distance <= promien)
            jestOk = true;

        if(jestOk)
            System.out.printf("\nPunkt (%d,%d) znajduje sie wewnatrz kola", x, y);
        else
            System.out.printf("\nPunkt (%d,%d) znajduje sie na zewnnatrz kola", x, y);
    }

    @Override
    public double pole() {
        return Math.PI * promien * promien;
    }

    @Override
    public double obwod() {
        return 2 * Math.PI * promien;
    }
}

class Prostokat extends Figura implements Obliczenie
{
    int szerokosc;
    int wysokosc;

    public Prostokat(int x, int y, int szerokosc, int wysokosc)
    {
        super(x,y);
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    @Override
    public String nazwaFigury() {
        return "Prostokat";
    }

    public String toString()
    {
        return nazwaFigury() + "\nLewy gorny - (" + super.x + "," + super.y + ")\nSzerokosc: " + szerokosc + ", Wysokosc: " + wysokosc;
    }

    @Override
    public void pozycja(int x, int y)
    {
        boolean jestOk = (x < super.x && x > super.x - wysokosc) && (y > super.y && y < super.y + szerokosc);

        if(jestOk)
            System.out.printf("\nPunkt (%d,%d) znajduje sie wewnatrz prostokata", x, y);
        else
            System.out.printf("\nPunkt (%d,%d) znajduje sie na zewnatrz prostokata", x, y);
    }

    @Override
    public double pole() {
        return szerokosc * wysokosc;
    }

    @Override
    public double obwod() {
        return 2 * szerokosc + 2 * wysokosc;
    }
}

//*********************************************************************//
// Zadanie 6
//********************************************************************//


interface Obliczenie
{
    double pole();
    double obwod();
}

interface Rysowanie
{
    void rysuj();
}

interface Transformacja
{
    void przesunDo(int x, int y);
    void powrot();
}

class Prostokat2 extends Prostokat implements Rysowanie
{
    char znak;

    public Prostokat2(int x, int y, int szerokosc, int wysokosc, char znak)
    {
        super(x, y, szerokosc, wysokosc);
        this.znak = znak;

        System.out.println();
        for(int i = 0; i < wysokosc; i++)
        {
            for(int j = 0; j < szerokosc; j++)
                System.out.print(znak);
            System.out.println();
        }
    }

    public void rysuj()
    {
        for(int i = 0; i < super.wysokosc; i++)
        {
            for(int j = 0; j < super.szerokosc; j++)
                System.out.print(znak);
            System.out.println();
        }
    }
}

class Kolo2 extends Kolo implements Transformacja
{
    int poprzednieX;
    int poprzednieY;

    public Kolo2(int x, int y, int promien)
    {
        super(x, y, promien);
    }

    @Override
    public void przesunDo(int x, int y)
    {
        this.poprzednieX = super.x;
        this.poprzednieY = super.y;
        super.x = x;
        super.y = y;
    }

    @Override
    public void powrot()
    {
        super.x = this.poprzednieX;
        super.y = this.poprzednieY;
    }
}


public class Zadanie5
{
    public static void main(String[] args)
    {
        Figura[] fig = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Prostokat(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figura f : fig)              // pętla for-each
            System.out.println(f);    // System.out.println(f.toString());

        fig[0].pozycja(12, 12);
        fig[1].pozycja(25, 30);

        Figura p2 = new Prostokat2(20,20,10,5, '*');
        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);
    }
}