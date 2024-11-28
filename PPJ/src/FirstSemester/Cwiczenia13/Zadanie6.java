package PPJ.FirstSemester.Cwiczenia13;

public class Zadanie6
{
    public static void main(String[] args)
    {
        int []a = new int[(int)(Math.random() * 20)];
        int []b = new int[(int)(Math.random() * 20)];
        int []c = new int[(int)(Math.random() * 20)];

        for(int i = 0; i < a.length; i++)
            a[i] = (int)(Math.random() * 20);

        for(int i = 0; i < b.length; i++)
            b[i] = (int)(Math.random() * 20);

        for(int i = 0; i < c.length; i++)
            c[i] = (int)(Math.random() * 20);

        int [][]tab = new int[3][];
        tab[0] = a;
        tab[1] = b;
        tab[2] = c;
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab[i].length; j++)
                System.out.print(tab[i][j] + " ");
            System.out.println();
        }
    }
}
