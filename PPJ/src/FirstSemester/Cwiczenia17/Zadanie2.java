package PPJ.FirstSemester.Cwiczenia17;

public class Zadanie2
{
    static void swap(int []tab, int i, int j)
    {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    static void printArray(int []tab)
    {
        for(int i : tab)
            System.out.print(i + " ");
    }

    public static void main(String[] args)
    {
        int []tab = new int[10];
        for(int i = 0; i < tab.length; i++)
            tab[i] = i;
        swap(tab, 0 ,1);
        printArray(tab);
    }
}
