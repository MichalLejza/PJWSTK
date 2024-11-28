package PPJ.SecondSemester.Cwiczenia9;

class MethodCurrier
{
    void setValue(int value)
    {
        System.out.println(value);
        value += 10;
        System.out.println(value);
    }

    void setValue(float value)
    {
        System.out.println(value);
        value += 1;
        System.out.println(value);
    }

    void setValue(Number number)
    {
        System.out.println(number.number);
        number.number += 10;
        System.out.println(number.number);
    }
}

class Number
{
    int number;

    void setValue(int number)
    {
        this.number = number;
    }

    void showValue()
    {
        System.out.println(number);
    }
}

class Osoba
{
    public String imie;
    public String nazwisko;
    public int rokUrodzenia;

    public Osoba(String imie, String nazwisko, int rokUrodzenia)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
    }

    void setValue(String imie, String nazwisko, int rokUrodzenia)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String toString()
    {
        return (imie + " " + nazwisko + " " + rokUrodzenia);
    }

    void show()
    {
        System.out.println(this);
    }
}

class Cplx
{
    private double real, imaginary;

    public Cplx(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    void add(Cplx number)
    {
        this.real += number.real;
        this.imaginary += number.imaginary;
    }

    void sub(Cplx number)
    {
        this.real -= number.real;
        this.imaginary -= number.imaginary;
    }

    void mul(Cplx number)
    {
        double r = this.real * number.real - this.imaginary * number.imaginary;
        double i = this.imaginary * number.real + this.real * number.imaginary;
        this.real = r;
        this.imaginary = i;
    }

    void inc()
    {
        this.real++;
    }

    void show()
    {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }
}

public class s26690set09
{
    static void Zadanie01()
    {
        MethodCurrier m = new MethodCurrier();
        int x = 10;
        float f = 5.6f;
        char c = 'c';
        byte b = 4;
        m.setValue(x);
        m.setValue(f);
        m.setValue(c);
        m.setValue(b);
    }

    static void Zadanie03()
    {
        Osoba osoba1 = new Osoba("Jan", "Kowalski", 1967);
        osoba1.show();
    }

    static void Zadanie04()
    {
        Cplx number1 = new Cplx(1,1);
        Cplx number2 = new Cplx(7.4, 10);
        Cplx number3 = new Cplx(6,100);
        number1.add(number3);
        number1.show();
        number2.inc();
        number2.show();
        number3.show();
        number1.show();
        number3.mul(number1);
        number3.show();
    }

    public static void main(String[] args)
    {
        Zadanie01();
        Zadanie03();
        Zadanie04();
    }
}
