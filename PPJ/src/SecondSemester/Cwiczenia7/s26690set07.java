package PPJ.SecondSemester.Cwiczenia7;

import java.util.Arrays;

public class s26690set07
{
    static void Zadanie1()
    {
        int []tab1 = new int[10];
        int []tab2 = new int[10];
        int []tab3 = new int[10];
        for(int i = 0; i < 10; i++)
        {
            tab1[i] = (int)(Math.random() * 100);
            tab2[i] = (int)(Math.random() * 100);
            tab3[i] = (int)(Math.random() * 100);
        }
        int [][]tab = {tab1, tab2, tab3};
        for (int[] ints : tab) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }
    }

    static void Zadanie2()
    {
        int [][]tab = new int[8][8];
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                tab[i][j] = (int)(Math.random() * 11);
        int []numbers = new int[11];

        for(int i = 0; i < 8; i++)
            numbers[tab[i][i]]++;

        for(int i = 0; i < 8; i++)
            numbers[tab[i][7 - i]]++;

        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] >= 3)
                System.out.println("Liczba " + i + " Wystepuje " + numbers[i] + " razy");
    }

    static void Zadanie3()
    {
        char[][]tab= {
                {'S','a','m','s','u','n','g'} ,
                {'N','o','k','i','a'} ,
                {'A','p','p','l','e'} ,
                {'B','l','a','c','k','B','e','r','r','y'} ,
                {'A','l','c','a','t','e','l'} ,
                {'S','o','n','y'} ,
                {'J','o','l','l','a'}};

        // podpunkt a
        for (char[] chars : tab)
        {
            String word = "";
            for (char aChar : chars) word += aChar;
            word = word.toLowerCase();

            int []letters = new int[255];
            for(int i = 0; i < word.length(); i++)
                letters[(int)word.charAt(i)]++;
            for(int i = 0; i < letters.length; i++)
                if(letters[i] > 1)
                    System.out.println("In word " + word + " letter " + (char)i + " repeats " + letters[i]);
        }

        System.out.println();

        //podpunkt b
        for(char []chars : tab)
        {
            int count = 0;
            for (char aChar : chars) count += aChar;

            if(count > 255)
                System.out.println(chars);
        }

        System.out.println();

        //podpunkt c
        for(char []chars : tab)
        {
            for(char znak : chars)
                if(znak == 'i' || znak == 'I')
                {
                    System.out.println(chars);
                    continue;
                }
        }

        System.out.println();

        // podpunkt d

        for (char[] chars : tab)
        {
            int []letter = new int[255];

            for(char znak : chars)
                letter[(int)znak]++;

            for(int i = 0; i < letter.length; i++)
                if(letter[i] > 1)
                    System.out.println("In word " + Arrays.toString(chars) + " letter " + (char)i + " repeats " + letter[i]);
        }
    }

    static void sort(int []tab)
    {
        for(int i = 0; i < tab.length; i++)
            for(int j = i + 1; j < tab.length; j++)
                if(tab[i] > tab[j])
                {
                    int temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
    }

    static void Zadanie4()
    {
        int [][] numbers = new int[10][10];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                numbers[i][j] = (int)(Math.random() * 100);
        for(int []line : numbers)
            sort(line);

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
                System.out.print(numbers[i][j] + " ");
            System.out.println();;
        }
    }

    public static void main(String[] args)
    {
        Zadanie1();
        Zadanie2();
        Zadanie3();
        Zadanie4();
    }
}
