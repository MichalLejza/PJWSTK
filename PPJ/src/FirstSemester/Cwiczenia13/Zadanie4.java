package PPJ.FirstSemester.Cwiczenia13;

import java.util.Scanner;

public class Zadanie4
{
    static void printArray(int []tab, boolean []czyWpisane)
    {
        for(int i = 0; i < tab.length; i++)
            if(czyWpisane[i])
                System.out.print(tab[i] + " ");
        System.out.println();
    }

    static int liczbaWpisana(String line)
    {
        String liczba = "";
        int i = 0;
        while (line.charAt(i) != ' ')
        {
            liczba += line.charAt(i);
            i++;
        }
        return Integer.parseInt(liczba);
    }

    static String komendaWpisana(String line)
    {
        String komenda = "";

        int i = 0;
        while (line.charAt(i) != ' ')
            i++;

        i++;

        while (i < line.length())
        {
            komenda += line.charAt(i);
            i++;
        }
        return komenda;
    }

    static boolean liczbaWzakresie(int liczba)
    {
        return (liczba >= -5 && liczba <= 5);
    }

    static boolean compareStrings(String jeden, String dwa)
    {
        if(jeden.length() == dwa.length())
        {
            for(int i = 0; i < jeden.length(); i++)
            {
                if(jeden.charAt(i) != dwa.charAt(i))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static void komendaQuit()
    {
        System.exit(1);
    }

    public static void komendaAdd(int index, int []tab, boolean[] czyWpisane)
    {
        if(index >= 3)
        {
            System.out.println("Nie ma miejsca");
        }
        else
        {
            if(index < 0)
            {
                index = 0;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj liczbe");
            int liczba = scanner.nextInt();
            tab[index] = liczba;
            czyWpisane[index] = true;
        }
    }
}
