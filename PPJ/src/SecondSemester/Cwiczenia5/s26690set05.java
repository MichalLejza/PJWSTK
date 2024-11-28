package PPJ.SecondSemester.Cwiczenia5;

import java.util.Scanner;

public class s26690set05
{
    static void zadanie01()
    {
        int K = 987654321;
        String s = "";
        while (K != 0)
        {
            int cyfra = K % 10;
            s += cyfra;
            K /= 10;
        }
        System.out.println(s);
    }

    static void zadanie02()
    {
        int s = 0;
        for(int i = 0; i <= 10; i++)
            s = s + i;

        s = 0;
        int i = 0;
        while (i <= 10)
        {
            s = s + i;
            i++;
        }
        System.out.println(s);
    }

    static void zadanie03()
    {
        int i = 0;
        while ( i < 0 )
            System.out.println("Petla while");
        i = 0;
        do
        {
            System.out.println("Petla do while");
        }
        while (i < 0);
    }

    static void zadanie04()
    {
        double suma = 0;
        for(int n = 0; n <= 9; n++)
        {
            suma += 1 / Math.pow(2, n);
            System.out.println(suma);
        }
    }

    static void zadanie05()
    {
        int wrt = 2;
        double suma = 1;

        System.out.println(suma);
        for(int i = 1; i < 9; i++)
        {
            suma += 1 / wrt * i;
            System.out.println(suma);
        }
    }

    static void zadanie06()
    {
        boolean []tab = new boolean[1501];

        for(int i = 2; i * i <= 1500; i++)
        {
            if(!tab[i])
            {
                for(int j = i * i; j <= 1500; j += i)
                {
                    tab[j] = true;
                }
            }
        }

        for(int i = 2; i <= 1500; i++)
            if(!tab[i])
                System.out.println(i + " " + -i);
    }

    static void zadanie07()
    {
        for(int i = 1; i < 6; i++)
        {
            for(int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void zadanie08()
    {
        Scanner in = new Scanner(System.in);
        String []directions = {"North", "East", "South", "West"};
        int dir = 0;
        while (true)
        {
            char c = in.next().charAt(0);
            if(c == 'A')
            {
                dir--;
            }
            else if(c == 'D')
            {
                dir++;
            }
            else
            {
                System.out.println("Wpisz jeszcze raz");
            }
            if(dir < 0)
                dir = 3;
            if(dir > 3)
                dir = 0;
            System.out.println("->" + c);
            System.out.println(directions[dir]);
        }
    }

    public static void main(String[] args)
    {
        zadanie01();
        zadanie06();
        zadanie08();
    }
}
