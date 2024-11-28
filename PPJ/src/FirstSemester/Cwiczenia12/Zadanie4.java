package PPJ.FirstSemester.Cwiczenia12;

import java.util.Scanner;

public class Zadanie4
{
    static boolean czyPelnaPlansza(byte []tab)
    {
        for (byte b : tab) {
            if (b == 0)
                return true;
        }
        return false;
    }

    static void start()
    {
        System.out.println("Kolko i krzyzyk...");
        System.out.println("Zasady:");
        System.out.println("1. Jesli chcesz grac z KOMPUTEREM: wcisnij '1' i enter");
        System.out.println("2. Jesli chcesz grac z KIMS: wcisnij '2' i enter");
        System.out.println("3. Zapelniasz pole wpisujac wspolrzedne pola, od 0 do 2");
        System.out.println("4. Jesli zagrasz z komputerem, bedziesz krzyzykiem");
        System.out.println("5. Program sie zakonczy gdy plansza sie wypelni");
        System.out.println("Zaczynamy?");
    }

    static void clearScreen()
    {
        for(int i = 0; i < 20; i++)
            System.out.println();
    }

    static void pokazPlansze(byte [][] plansza)
    {
        System.out.println();
        for(byte i = 0; i < 3; i++)
        {
            for(byte j = 0; j < 3; j++)
            {
                if(plansza[i][j] == 0)
                    System.out.print("   ");

                else if(plansza[i][j] == 1)
                    System.out.print(" x ");

                else if(plansza[i][j] == 2)
                    System.out.print(" 0 ");

                if(j == 0 || j == 1)
                    System.out.print("|");
            }

            System.out.println();

            if(i == 0 || i == 1)
            {
                for(int k = 0; k < 10; k++)
                    System.out.print("-");
            }
            System.out.println();
        }
    }

    static void kolkoLosowe(byte [][]plansza, byte []gra)
    {
        if(czyPelnaPlansza(gra))
        {
            byte wiersz = (byte)(Math.random() * 3);
            byte kolumna = (byte)(Math.random() *3);
            while (plansza[wiersz][kolumna] != 0) {
                wiersz = (byte) (Math.random() * 3);
                kolumna = (byte) (Math.random() * 3);
            }
            plansza[wiersz][kolumna] = 2;
            gra[wiersz * 3 + kolumna] = 2;
        }
    }

    static void autoPilot(byte[][] plansza, byte[] gra, Scanner scanner)
    {
        while (czyPelnaPlansza(gra)) {
            System.out.println();
            System.out.println("Wpisz wiersz:");
            byte wiersz = scanner.nextByte();

            System.out.println("Wpisz kolumne: ");
            byte kolumna = scanner.nextByte();

            if (plansza[wiersz][kolumna] == 0) {
                gra[wiersz * 3 + kolumna] = 1;
                plansza[wiersz][kolumna] = 1;
            } else {
                System.out.println("Zle wspolrzedne, wpisz jeszcze raz");
                continue;
            }
            kolkoLosowe(plansza, gra);
            pokazPlansze(plansza);
        }
    }

    static void graZKims(byte[][]plansza, byte []gra, Scanner scanner)
    {
        System.out.println("Pierwszy zaczyna krzyzyk...");
        int tura = 0;
        while (czyPelnaPlansza(gra))
        {

            if(tura % 2 == 0)
                System.out.println("Krzyzyk:");
            else
                System.out.println("Kolko:");


            System.out.println();
            System.out.println("Wpisz wiersz:");

            byte wiersz = scanner.nextByte();

            System.out.println("Wpisz kolumne: ");

            byte kolumna = scanner.nextByte();


            if (plansza[wiersz][kolumna] == 0)
            {
                if(tura % 2 == 0)
                {
                    gra[wiersz * 3  +kolumna] = 1;
                    plansza[wiersz][kolumna] = 1;
                }
                else
                {
                    gra[wiersz * 3  +kolumna] = 2;
                    plansza[wiersz][kolumna] = 2;
                }
            }
            else
            {
                System.out.println("Zle wspolrzedne, wpisz jeszcze raz");
                continue;
            }
            pokazPlansze(plansza);
            tura++;
        }
    }

    public static void main(String[] args)
    {
        byte []gra = new byte[9];
        byte [][]plansza = new byte[3][3];

        start();

        Scanner scanner = new Scanner(System.in);
        int tryb_gry = scanner.nextInt();

        clearScreen();

        if(tryb_gry == 1)
            autoPilot(plansza,gra,scanner);
        else if(tryb_gry == 2)
            graZKims(plansza,gra, scanner);

        System.out.println("Koniec Gry!");
    }
}
