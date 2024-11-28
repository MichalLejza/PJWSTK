package PPJ.FirstSemester.Cwiczenia27;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie2
{
    static void minMaxAvgSum(File file) throws FileNotFoundException
    {
        Scanner scanFile = new Scanner(file);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        while (scanFile.hasNextInt())
        {
            int number = scanFile.nextInt();
            min = Math.min(min, number);
            max = Math.max(max, number);
            sum += number;
            count++;
        }
        double avg = (double)(sum / count);
        System.out.println("Min: " + min + " Max: " + max + " Avg: " + avg + " Sum: " + sum);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Liczby.txt");
        minMaxAvgSum(file);
    }
}
