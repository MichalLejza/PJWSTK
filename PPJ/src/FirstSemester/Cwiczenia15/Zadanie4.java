package PPJ.FirstSemester.Cwiczenia15;

public class Zadanie4
{
    static int findMax(int a, int b, int c)
    {
        if(a > b && a > c)
            return a;
        if(b > a && b > c)
            return b;
        return c;
    }
    public static void main(String[] args)
    {
        System.out.println(findMax(10,20,20));
    }
}
