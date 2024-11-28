package PPJ.FirstSemester.Cwiczenia13;

public class Zadanie1
{
    static int ileLiczb(int []tab)
    {
        int count = 1;
        for(int i = 0; i < tab.length - 1; i++)
        {
            if(tab[i] != tab[i + 1])
                count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int tab[] = {1,1,1,1,1,2,3,4,5,6,6,6};
        System.out.println(ileLiczb(tab));
    }
}
