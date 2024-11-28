package PPJ.FirstSemester.Cwiczenia15;

public class Zadanie1
{
    static int howManyElements(int [][]tab)
    {
        int count = 0;
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0;j < tab[i].length; j++)
                count++;
        }
        return count;
    }

    static int[][] przepisz(int [][]tab, int rozmiar)
    {
        int index = 0;
        int [][]array = new int[1][rozmiar];

        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0;j < tab[i].length; j++)
            {
                array[0][index] = tab[i][j];
                index++;
            }
        }
        return array;
    }

    static void printArray(int [][]tab)
    {
        for(int i = 0; i < tab.length; i++)
            for(int j = 0; j < tab[i].length; j++)
                System.out.print(tab[i][j]);
        System.out.println();
    }

    public static void main(String[] args)
    {
        int [][]tab = {{1,0,0,0,0} , {0,1,0,0}, {0,0,1}};
        int count = howManyElements(tab);
        tab = przepisz(tab, count);
        printArray(tab);
    }
}
