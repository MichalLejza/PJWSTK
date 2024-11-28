package PPJ.FirstSemester.Cwiczenia27;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie1
{
    static boolean letters(char c)
    {
        return (c >= 65 && c <= 90 || c >= 97 && c <= 122 );
    }
    static boolean specialChars(char c)
    {
        return (c == '.' || c == ' ' || c == '/' || c == '\n' || c == '(');
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Cwiczenia27/Zadanie1.java");
        Scanner scanFile = new Scanner(file);
        int count = 0;
        while (scanFile.hasNextLine())
        {
            String line = scanFile.nextLine();
            for(int i = 0; i < line.length() - 1; i++)
                if(letters(line.charAt(i)) && specialChars(line.charAt(i + 1)))
                    count++;
        }
        System.out.println(count);
    }
}
