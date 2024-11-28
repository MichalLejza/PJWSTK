package PPJ.FirstSemester.Cwiczenia28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Magic
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Cwiczenia28/Plik.txt");
            Scanner scanner = new Scanner(file);
            double kwota = 0;

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                Pattern cena = Pattern.compile("\\d,\\d\\d");
                Matcher cenaMatch = cena.matcher(line);

                Pattern ilosc = Pattern.compile("\\d ");
                Matcher iloscMatch = ilosc.matcher(line);

                while (cenaMatch.find() && iloscMatch.find())
                {
                    String buforCena = cenaMatch.group();
                    String price = buforCena.charAt(0) + "." + buforCena.charAt(2) + buforCena.charAt(3);

                    char count = iloscMatch.group().charAt(0);
                    kwota += (count - 48) * Double.parseDouble(price);
                }
            }
            System.out.println(kwota);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found");
        }
    }
}
