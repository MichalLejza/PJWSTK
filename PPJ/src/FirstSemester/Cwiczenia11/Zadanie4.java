package PPJ.FirstSemester.Cwiczenia11;

public class Zadanie4
{
    public static void main(String[] args)
    {
        boolean []tab = {true, false, true, true, false};
        int ile_prawd = 0;
        int ile_falsz = 0;

        for (boolean b : tab)
        {
            if (b)
                ile_prawd++;
            else
                ile_falsz++;
        }

        boolean []prawdy = new boolean[ile_prawd];
        boolean []falsze = new boolean[ile_falsz];

        for(int i = 0; i < prawdy.length; i++)
            prawdy[i] = true;

        for(int i = 0; i < falsze.length; i++)
            falsze[i] = false;

        for(boolean i : prawdy)
            System.out.print(i + " ");
        System.out.println();

        for(boolean i : falsze)
            System.out.print(i + " ");
    }
}
