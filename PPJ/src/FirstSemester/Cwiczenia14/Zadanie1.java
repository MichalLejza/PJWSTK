package PPJ.FirstSemester.Cwiczenia14;

public class Zadanie1
{
    static void printArray(float [][]tab)
    {
        for (float[] floats : tab) {
            for (float aFloat : floats) System.out.print(aFloat + " ");
            System.out.println();
        }
    }

    static float lewaPrzekatna(float[][] tab)
    {
        float sumaPrzekatnej = 0;
        for(int i = 0; i < tab.length; i++)
        {
            sumaPrzekatnej += tab[i][i];
        }
        return sumaPrzekatnej;
    }

    static float prawaPrzekatna(float[][] tab)
    {
        float sumaPrzekatnej = 0;
        int j = 0;
        for(int i = tab.length - 1; i >= 0; i--)
        {
            sumaPrzekatnej += tab[j][i];
            j++;
        }
        return sumaPrzekatnej;
    }

    public static void main(String[] args)
    {
        float [][]tab = new float[8][8];
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab[i].length; j++)
                tab[i][j] = (float)(Math.random() * 20);
        }

        printArray(tab);
        System.out.println(lewaPrzekatna(tab));
        System.out.println(prawaPrzekatna(tab));
    }
}
