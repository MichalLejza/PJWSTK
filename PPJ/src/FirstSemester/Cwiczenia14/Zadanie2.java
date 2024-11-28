package PPJ.FirstSemester.Cwiczenia14;
import java.util.Scanner;

public class Zadanie2
{
    static int rzutKostka()
    {
        return ((int) ((Math.random() * 6) + 1));
    }

    static void printArray(int[][] tab)
    {
        for (int i = 0; i < tab.length; i++)
            for (int j = 0; j < tab[i].length; j++)
                System.out.print(tab[i][j] + " ");
        System.out.println();
    }

    static int[][] rollAgain(int[][] wartosciKosci)
    {
        int[][] temp = new int[wartosciKosci.length + 1][2];
        for (int i = 0; i < wartosciKosci.length; i++)
        {
            for (int j = 0; j < wartosciKosci[i].length; j++)
                temp[i][j] = wartosciKosci[i][j];
        }

        temp[wartosciKosci.length][0] = rzutKostka();
        temp[wartosciKosci.length][1] = rzutKostka();

        return temp;
    }

    static boolean compareStrings(String one, String two)
    {
        if (one.length() == two.length())
        {
            for (int i = 0; i < one.length(); i++)
                if (one.charAt(i) != two.charAt(i))
                    return false;
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] wartosciKosci = new int[1][2];
        wartosciKosci[0][0] = rzutKostka();
        wartosciKosci[0][1] = rzutKostka();

        Scanner scanner = new Scanner(System.in);
        while (1 == 1)
        {
            String command = scanner.nextLine();
            if (compareStrings(command, "show"))
            {
                printArray(wartosciKosci);
            }
            else if (compareStrings(command, "roll"))
            {
                wartosciKosci = rollAgain(wartosciKosci);
            }
        }
    }
}