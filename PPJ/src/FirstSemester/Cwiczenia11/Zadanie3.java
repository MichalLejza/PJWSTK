package PPJ.FirstSemester.Cwiczenia11;

public class Zadanie3
{
    static boolean palindrom(int []tab)
    {
        int poc = 0;
        int kon = tab.length - 1;
        while(poc < kon)
        {
            if(tab[poc] != tab[kon])
                return false;
            kon--;
            poc++;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] tab = {1,2,2,3,3,4,4,3,3,2,2,1};
        System.out.println(palindrom(tab));
    }
}
