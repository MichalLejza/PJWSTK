package PPJ.FirstSemester.Cwiczenia14;

public class Zadanie3
{

    static boolean xSieMiesci(int x, int size)
    {
        return ( x >= 0 && x < size);
    }

    static boolean ySieMiesci(int y, int size)
    {
        return ( y >= 0 && y < size);
    }

    public static void main(String[] args)
    {
        int size = 50;
        int count = 0;

        while(count <= 20)
        {
            int x = (int)(Math.random() * (1.4 * size) - (0.2 * size));
            int y = (int)(Math.random() * (1.4 * size) - (0.2 * size));
            if( !(xSieMiesci(x,size) && ySieMiesci(y,size)) )
            {
                count++;
                System.out.println("Coordinates outside of range (" + x + "," + y + ")");
            }
        }
    }
}
