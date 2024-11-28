package PPJ.FirstSemester.Cwiczenia11;

public class Zadanie5
{
    static void swap(long []tab, int i, int j)
    {
        long temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    static boolean poKolei(long []tab)
    {
        for(int i = 1; i < tab.length; i++)
        {
            if(tab[i] < tab[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        long []tab = new long[7];
        tab[0] = 4;

        for(int i = 1; i < tab.length; i++)
            tab[i] = tab[i - 1] + 1;

        // musimy na poczatku zamienic bo jest na stracie ulozone po kolei
        swap(tab,0,1);

        while (!poKolei(tab))
        {
            int jeden = (int)(Math.random() * tab.length);
            int dwa = (int)(Math.random() * tab.length);
            swap(tab,jeden,dwa);
        }

        for (long l : tab) System.out.print(l + " ");

        System.out.println();

    }
}
