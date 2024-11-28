package PPJ.FirstSemester.Cwiczenia18;

public class Zadanie1
{

    static void wypelnijTablice(int [][]tab, int index, int max)
    {
        if(index < max)
        {
            for (int i = index; i < tab.length - index; i++)
            {
                tab[index][i] = index + 1;
                tab[i][tab.length - 1 - index] = index + 1;
                tab[tab.length - 1 - i][index] = index + 1;
                tab[tab.length - 1 - index][tab.length - 1 - i] = index + 1;
            }
            wypelnijTablice(tab, index + 1, max);
        }
    }

    static void zadanie(int x)
    {
        int [][]tab = new int[2 * x][2 * x];
        wypelnijTablice(tab, 0, x);
        printArray(tab);
    }

    static void printArray(int [][]tab)
    {
        for (int[] ints : tab) {
            for (int anInt : ints)
                System.out.print(anInt + " ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        zadanie(6);
    }
}
