package PPJ.FirstSemester.Cwiczenia16;

public class Zadanie3
{
    static boolean isItArmstrong(int x)
    {
        String number = String.valueOf(x);
        int potega = number.length();
        int suma = 0;
        for(int i = 0; i < number.length(); i++)
        {
            int liczba = (int)number.charAt(i) - 48;
            suma += Math.pow(liczba, potega);
        }
        return suma == x;
    }

    public static void main(String[] args)
    {
        int x = 9926315;
        if(isItArmstrong(x))
            System.out.println("Liczba armstronga");
        else
            System.out.println("Nope");
    }
}
