package PPJ.FirstSemester.Cwiczenia17;

public class Zadanie4
{
    static void palidromPrawy(char []tab, int i)
    {
        if(tab.length % 2 == 0)
        {
            if(i >= tab.length / 2)
            {
                System.out.print(tab[i]);
                palidromPrawy(tab, i - 1);
            }
        }
        else
        {
            if(i > tab.length / 2)
            {
                System.out.print(tab[i]);
                palidromPrawy(tab, i - 1);
            }
        }
    }
    static void palidromLewy(char []tab, int i, int j)
    {
        if(i < j)
        {
            palidromLewy(tab, i + 1, j - 1);
            System.out.print(tab[i]);
        }
    }
    public static void main(String[] args)
    {
        char [] tab = {'A', 'n','n','a'};
        palidromLewy(tab, 0, tab.length - 1);
        palidromPrawy(tab,tab.length - 1);
    }
}
