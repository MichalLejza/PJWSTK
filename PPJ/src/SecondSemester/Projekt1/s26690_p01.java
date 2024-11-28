package PPJ.SecondSemester.Projekt1;

import java.util.Scanner;

public
    class s26690_p01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pierwszą liczbę: ");
        int first = scanner.nextInt();
        System.out.print("Podaj drugą liczbę: ");
        int second = scanner.nextInt();
        System.out.print("Podaj operację: ");
        String znak = scanner.next();

        while (first != 0 && second != 0)
        {
            System.out.print(first + " - ");
            printBinary(first);
            System.out.print(second + " - ");
            printBinary(second);
            if(znak.equals("+"))
            {
                System.out.print(add(first,second) + " - ");
                printBinary(add(first,second));
            }
            else if (znak.equals("-"))
            {
                System.out.print(subtract(first,second) + " - ");
                printBinary(subtract(first,second));
            }
            else if (znak.equals("*"))
            {
                System.out.print(multiply(first,second) + " - ");
                printBinary(multiply(first,second));
            }
            else if (znak.equals("/"))
            {
                System.out.print(division(first,second) + " - ");
                printBinary(division(first,second));
            }
            else
            {
                System.out.println("Zly znak operacji");
            }

            System.out.println("============================");

            System.out.print("Podaj pierwszą liczbę: ");
            first = scanner.nextInt();
            System.out.print("Podaj drugą liczbę: ");
            second = scanner.nextInt();
            System.out.print("Podaj operację: ");
            znak = scanner.next();
        }
    }

    static void printBinary(int a) {
        if(a < 0)
            System.out.print(1);
        for(int i = 1 << 30; i > 0; i /= 2)
            System.out.print((a & i) != 0 ? 1 : 0);
        System.out.println();
    }

    static int add(int a, int b) {
        int bufor = 0;
        while (b != 0)
        {
            bufor = (a & b) << 1;
            a = a ^ b;
            b = bufor;
        }
        return a;
    }

    static int subtract(int a, int b) {
        int bufor = 0;
        b = add(~b, 1);
        while (b != 0)
        {
            bufor = (a & b) << 1;
            a = a ^ b;
            b = bufor;
        }
        return a;
    }

    static int multiply(int a, int b) {
        int product = 0;
        int sum = 0;

        int positionA = 1;
        int positionB = 1;

        for(int i = 0; i < 32; i++)
        {
           if(((positionB << i) & b) != 0)
               product = add(product, a << i);
        }
        return product;
    }


    static int division(int a, int b) {
       int bufor = 1;
       int product = 0;
       int sign = 1;

       if(a < 0)
       {
           a = add(~a, 1);
           sign = add(~sign, 1);
       }
       if(b < 0)
       {
           b = add(~b, 1);
           sign = add(~sign, 1);
       }

       while (b <= a)
       {
           b <<= 1;
           bufor <<= 1;
       }

       while (bufor > 1)
       {
           b >>= 1;
           bufor >>= 1;
           if(a >= b)
           {
               a = subtract(a, b);
               product = add(product, bufor);
           }
       }
       return multiply(sign, product);
    }
}