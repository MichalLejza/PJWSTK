package PPJ.FirstSemester.Cwiczenia27;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Zadanie3
{
    static void swap(int i, int j, int []tab)
    {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
    static void sort(int []tab)
    {
        for(int i = 0; i < tab.length - 1; i++)
            for(int j = i; j < tab.length; j++)
                if(tab[j] < tab[i])
                    swap(i,j,tab);
    }

    static void createNFiles(int numberOfFiles) throws IOException
    {
        for(int i = 0; i < numberOfFiles; i++)
        {
            String path = "/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Pliki/Plik"+i+".txt";

            File file = new File(path);

            if ( file.createNewFile() )
            {
                int []numbers = new int[10];
                for(int j = 0; j < 10; j++)
                    numbers[j] = (int)(Math.random() * 800);

                sort(numbers);

                PrintWriter write = new PrintWriter(path);

                for(int j = 0; j < 10; j++)
                    write.println(numbers[j]);
                write.close();
            }
            else
            {
                System.out.println("File nr. " + i + " was not formed correctly");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        int numberOfFiles = 1000;
        createNFiles(numberOfFiles);
    }
}
