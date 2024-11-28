package PPJ.FirstSemester.Cwiczenia14;


public class Zadanie4
{
    static void initialize(int [][]tab, int liczba)
    {
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab[i].length; j++)
            {
                tab[i][j] = liczba;
                liczba++;
            }
        }
    }

    static boolean przeszlismyCalaTablice(boolean[][] tab)
    {
        for(int i = 0; i < tab.length; i++)
            for(int j = 0; j < tab[i].length; j++)
                if(!tab[i][j])
                    return false;

        return true;
    }

    static void printRight(int [][]tab, boolean[][] odwiedzone, int bufor)
    {
        for(int i = bufor; i < tab.length - bufor; i++)
        {
            odwiedzone[bufor][i] = true;
            System.out.print(tab[bufor][i] + " ");
        }
        for(int i = bufor + 1; i < tab.length - bufor; i++)
        {
            odwiedzone[i][tab.length - 1 - bufor] = true;
            System.out.print(tab[i][tab.length - 1 - bufor] + " ");
        }
    }

    static void printLeft(int [][]tab, boolean[][] odwiedzone, int bufor)
    {
        for(int i = tab.length - 1 - bufor; i >= bufor - 1; i--)
        {
            odwiedzone[tab.length - bufor][i] = true;
            System.out.print(tab[tab.length - bufor][i] + " ");
        }
        for(int i = tab.length - 1 - bufor; i >= bufor; i--)
        {
            odwiedzone[i][bufor - 1] = true;
            System.out.print(tab[i][bufor - 1] + " ");
        }
    }

    static void printSpirallyArray(int[][] tab, boolean[][] odwiedzone)
    {
        int mode = 0;
        int bufor = 0;
        while(!przeszlismyCalaTablice(odwiedzone))
        {
            if(mode % 2 == 0)
            {
                printRight(tab,odwiedzone,bufor);
                bufor++;
            }
            else
            {
                printLeft(tab,odwiedzone,bufor);
            }
            mode++;
        }
    }

    public static void main(String[] args)
    {
        int size = 4;
        int liczba = 1;
        int [][]tab = new int[size][size];
        boolean[][]odwiedzone = new boolean[size][size];
        initialize(tab,liczba);
        printSpirallyArray(tab, odwiedzone);
    }
}
