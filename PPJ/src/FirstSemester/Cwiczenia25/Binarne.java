package PPJ.FirstSemester.Cwiczenia25;

public class Binarne
{
    public static void printARGB(int pixel)
    {
        System.out.printf("Alpha: %d\n", pixel >> 24);
        System.out.printf("Red: %d\n", (pixel >> 16) & 0xFF);
        System.out.printf("Green: %d\n", (pixel >> 8) & 0xFF);
        System.out.printf("Blue: %d\n", (pixel << 24) >> 24 & 0xFF);
    }

    public static void chengeGreen(int pixel, int green)
    {
        if(green > 0 && green < 256)
        {
            green = green << 8;
            int dodaj = 0xFF_FF_00_FF;
            dodaj = dodaj & pixel;
            dodaj = dodaj | green;
            printARGB(dodaj);
        }
    }

    public static void main(String[] args)
    {
        int pixel = 0xFF_73_21_FF;
        //printARGB(pixel);
        int dodaj = 0x3;
        pixel = pixel + (dodaj << 8);
        printARGB(pixel);
        chengeGreen(pixel, 12);
    }
}
