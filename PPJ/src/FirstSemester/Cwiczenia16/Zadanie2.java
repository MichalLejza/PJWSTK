package PPJ.FirstSemester.Cwiczenia16;

public class Zadanie2
{
    static int[] splitToDigits(int x)
    {
        String number = String.valueOf(x);
        int size = number.length();
        int []wynik = new int[size];
        for(int i = 0; i < size; i++)
            wynik[i] = (int)number.charAt(i) - 48;
        return wynik;
    }

    static void printArray(int []tab)
    {
        for (int j : tab) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        int x = 75890;
        int []tab = splitToDigits(x);
        printArray(tab);
    }
}
