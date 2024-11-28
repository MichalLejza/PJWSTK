package PPJ.FirstSemester.Cwiczenia17;

public class Zadanie3
{
    static boolean isPalindrom(char[]tab, int i, int j)
    {
        if(i < j)
        {
            if(tab[i] != tab[j])
                return false;
            else
            {
                return isPalindrom(tab, i + 1, j - 1);
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char []tab = {'a', 'a', 'n', 'n', 'a','a'};

        if(isPalindrom(tab, 0, tab.length - 1))
            System.out.println("To palindrom");
        else
            System.out.println("To nie jest palidrom");
    }
}
