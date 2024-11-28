package PPJ.FirstSemester.Cwiczenia17;

public class Zadanie5
{
    static void printArray(int []tab)
    {
        for(int i : tab)
            System.out.print(i + " ");
        System.out.println();
    }

    static void swap(int []tab, int i, int j)
    {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
    static void bubbleSort(int []tab)
    {
        for(int i = 0; i < tab.length -1 ; i++)
        {
            for(int j = 0; j < tab.length - 1 - i; j++)
            {
                if(tab[j] > tab[j + 1])
                    swap(tab, j, j + 1);
            }
        }
    }
    public static void main(String[] args)
    {
        int []tab = {3,4,5,6,7,1,2,10,13,3};
        printArray(tab);
        bubbleSort(tab);
        printArray(tab);
    }
}
