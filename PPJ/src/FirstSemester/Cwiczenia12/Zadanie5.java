package PPJ.FirstSemester.Cwiczenia12;

public class Zadanie5 {

    static boolean czyArmstrong(int val)
    {
        int bufor = val;
        int suma = 0;
        while(bufor > 0)
        {
            suma += Math.pow((bufor % 10), 3);
            bufor /= 10;
        }
        return (suma == val);
    }

    public static void main(String[] args)
    {
        int []arr = {53 ,  333 ,  370 ,  515 ,  407 ,  80};
        for (int j : arr) {
            if (czyArmstrong(j))
                System.out.println("Liczba: " + j + " jest liczbą Armstronga");
        }
    }
}
