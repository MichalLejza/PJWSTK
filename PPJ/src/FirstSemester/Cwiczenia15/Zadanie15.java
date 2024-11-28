package PPJ.FirstSemester.Cwiczenia15;

public class Zadanie15
{
    static void printArray(int []tab)
    {
        for(int i = 0; i < tab.length; i++)
        {
            if(tab[i] != 0)
            {
                System.out.println((char)i + "  ile:  " + tab[i]);
            }
        }
    }
    static void iloscZnakow(char[] tab)
    {
        int []znaki = new int[128];
        for(int i = 0; i < tab.length; i++)
            znaki[tab[i]]++;
        printArray(znaki);
    }
    public static void main(String[] args)
    {
        char []tab = {'A', 'l', 'a', ' ', 'm', 'a', ' ', 'k', 'o', 't', 'a', '.'};
        iloscZnakow(tab);
    }
}
