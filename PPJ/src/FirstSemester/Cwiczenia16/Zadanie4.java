package PPJ.FirstSemester.Cwiczenia16;

public class Zadanie4
{
    public static int [][]calculateSquare(int width, int height, int side)
    {
        int dimX = height / side;
        int dimY = width / side;
        int [][]wynik = new int[2][dimX * dimY];
        int count = 0;
        for(int i = 0; i < dimX; i++)
        {
            for(int j = 0; j < dimY; j++)
            {
                wynik[0][count] = side * j;
                wynik[1][count] = side * i;
                count++;
            }
        }
        return wynik;
    }

    static void printArray(int [][]tab)
    {
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab[i].length; j++)
                System.out.print(tab[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int [][]wynik = calculateSquare(10,10,4);
        printArray(wynik);
    }
}
