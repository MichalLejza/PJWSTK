package PPJ.FirstSemester.Cwiczenia13;

import java.util.Scanner;

public class Zadanie5
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
        if(index >= tab.length)
        {
            int []temp = new int[tab.length + 1];
            for(int i = 0; i < tab.length; i++)
                temp[i] = tab[i];
            tab = temp;

            boolean[] tempbool = new boolean[czyWpisane.length + 1];
            for(int i = 0; i < czyWpisane.length; i++)
                tempbool[i] = czyWpisane[i];
            czyWpisane = tempbool;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj liczbe");
            int liczba = scanner.nextInt();
            tab[index] = liczba;
            czyWpisane[index] = true;
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

    public static void komendaGet(int []tab, int index, boolean[] czyWpisane)
    {
        if(index >= tab.length)
        {
            index = 2;
            tab[index] = 0;
            czyWpisane[index] = false;
        }
        else if(index < 0)
        {
            System.out.println("Nie ma czego usuawac");
        }
        else
        {
            tab[index] = 0;
            czyWpisane[index] = false;
        }

    }

    public static void main(String[] args)
    {
        int[] tab = new int[3];
        boolean[] czyWpisane = new boolean[3];

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String komenda = komendaWpisana(line);
        int liczba = liczbaWpisana(line);

        int index = 0;

        while (liczbaWzakresie(liczba))
        {
            if(compareStrings(komenda, "quit"))
            {
                printArray(tab, czyWpisane);
                komendaQuit();
            }
            else if(compareStrings(komenda, "add"))
            {
                printArray(tab, czyWpisane);
                komendaAdd(index,tab,czyWpisane);
                printArray(tab,czyWpisane);
                index++;
            }
            else if(compareStrings(komenda, "get"))
            {
                index--;
                printArray(tab,czyWpisane);
                komendaGet(tab,index,czyWpisane);
                printArray(tab,czyWpisane);
            }
            line = scanner.nextLine();
            liczba = liczbaWpisana(line);
            komenda = komendaWpisana(line);
        }
        printArray(tab,czyWpisane);
    }
}
