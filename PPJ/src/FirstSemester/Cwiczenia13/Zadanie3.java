package PPJ.FirstSemester.Cwiczenia13;

public class Zadanie3
{
    static int max(int a, int b)
    {
        return (a > b ? a : b);
    }
    static boolean lider(int []tab)
    {
        int wynik = 0;
        int count = 0;
        int obecny = tab[0];

        for(int i = 0; i < tab.length; i++)
        {
            if(obecny == tab[i])
                count++;
            else
            {
                obecny = tab[i];
                count = 1;
            }
            wynik = max(wynik, count);
        }
        return (wynik >= tab.length / 2);
    }
    public static void main(String[] args)
    {
        int []tab = {1,1,1,3,3,3,3,3,3,3};
        System.out.println(lider(tab));
    }
}
