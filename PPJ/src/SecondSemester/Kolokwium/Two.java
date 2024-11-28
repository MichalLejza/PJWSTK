package PPJ.SecondSemester.Kolokwium;

public class Two
{
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x/3);
        System.out.println(x/3.0);
        System.out.println((x/3.0));

        int i = 1, j = 2;
        String s = "Liczba";
        s = s + i + j + 3;
        System.out.println(s);

        int y = '\u3470';
        System.out.println(y);
    }
}

class Person
{
    private int prywatny;
    protected int chroniony;
    public int publiczny;
    int zwykly;

    public Person(int prywatny, int chroniony, int publiczny, int zwykly)
    {
        this.prywatny = prywatny;
        this.chroniony = chroniony;
        this.publiczny = publiczny;
        this.zwykly = zwykly;
    }

    public void show()
    {
        System.out.println("Klasa Person: " + prywatny + " " + chroniony + " " + publiczny + " " + zwykly);
        System.out.println();
    }
}

class Medic extends Person
{

    private int prywatna;
    protected int chroniona;
    public int publiczna;
    int zwykla;
    public Medic(int prywatne, int chronione, int publiczne, int zwykle) {
        super(prywatne, chronione, publiczne, zwykle);
        this.chroniona = chronione + 1;
        this.prywatna = prywatne + 1;
        this.publiczna = publiczne + 1;
        this.zwykla = zwykle + 1;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Klasa Medic: " + prywatna + " " + chroniona + " " + publiczna + " " + zwykla);
        System.out.println();
    }
}