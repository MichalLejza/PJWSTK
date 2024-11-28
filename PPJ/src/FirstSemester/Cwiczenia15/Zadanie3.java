package PPJ.FirstSemester.Cwiczenia15;

public class Zadanie3
{
    static void modifyValue(int x)
    {
        System.out.println(x);
        x *= 5;
        System.out.println(x);
    }
    public static void main(String[] args)
    {
        int wrt = 5;
        System.out.println(wrt);
        modifyValue(wrt);
        System.out.println(wrt);
        // tworzona jest kopia zmiennej i zmiana jej wartosci w procedurze
        // nie zmienia jej oryginalnej wartosci nadanej w funkcji main
    }
}
