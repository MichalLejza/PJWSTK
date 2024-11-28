package GUI.Projekt2;

import java.util.Scanner;

class Gracz
{
    boolean []domek = new boolean[4];
    int []pozycjePionka;
    char nazwa;
    int start, indexPionka;
    public Gracz(char nazwa)
    {
        this.nazwa = nazwa;
        this.pozycjePionka = createPositions();
        this.start = (nazwa - 97) * 10;
        this.indexPionka = 0;
    }
    int []createPositions()
    {
        int []pionki = new int[4];
        for(int i = 0; i < 4; i++)
                pionki[i] = -1;
        return pionki;
    }

    boolean start()
    {
        for(int i = 0; i < 4; i++)
            if(pozycjePionka[i] >= 0)
                return true;
        return false;
    }

    void wystawPionka()
    {
        for(int i = 0; i < 4; i++)
            if(pozycjePionka[i] < 0)
                pozycjePionka[i] = start;
    }
}

class Plansza
{
    char [][]plansza;
    int [][]wspolrzedne;
    Gracz []gracze;

    public Plansza(Gracz []gracze)
    {
        this.plansza = makeBoard();
        this.wspolrzedne = makeCoordinates();
        this.gracze = gracze;
    }

    char[][] makeBoard()
    {
        char [][]board = new char[11][11];
        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 11; j++)
                board[i][j] = 0;

        for(int i = 0; i < 11; i++)
            if(i != 5) {
                board[i][4] = 'x';
                board[i][6] = 'x';
                board[4][i] = 'x';
                board[6][i] = 'x';
            }
        board[5][0] = 'x';
        board[5][10] = 'x';
        board[0][5] = 'x';
        board[10][5] = 'x';
        return board;
    }

    int [][]makeCoordinates()
    {
        int [][]board = new int[11][11];

        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 11; j++)
                board[i][j] = -2;

        int index = 0;
        for(int i = 0; i < 4; i++)
        {
            board[i][6] = index;
            board[4][i + 6] = index + 4;
            board[6][10 - i] = index + 10;
            board[i + 6][6] = index + 14;
            board[10 - i][4] = index + 20;
            board[6][4 - i] = index + 24;
            board[4][i] = index + 30;
            board[4 - i][4] = index + 34;
            index++;
        }

        board[4][10] = 8;
        board[5][10] = 9;
        board[10][6] = 18;
        board[10][5] = 19;
        board[6][0] = 28;
        board[5][0] = 29;
        board[0][4] = 38;
        board[0][5] = 39;

        return board;
    }

    void drawBoard()
    {
        char [][]extendedBoard = new char[14][16];

        for(int i = 2; i < 13; i++)
            for(int j = 3; j < 14; j++)
                extendedBoard[i][j] = plansza[i - 2][j - 3];

        extendedBoard[6][0] = '3';
        extendedBoard[6][1] = '0';
        extendedBoard[1][7] = '0';
        extendedBoard[8][14] = '1';
        extendedBoard[8][15] = '0';
        extendedBoard[13][5] = '2';
        extendedBoard[13][6] = '0';


        for(int i = 0; i < 14; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                if(i > 1  && i < 13 && j > 2 && j < 14)
                {
                    if(extendedBoard[i][j] != 0)
                    {
                        if(extendedBoard[i][j] == 'a')
                            System.out.print('a' + "  ");
                        else if(extendedBoard[i][j] == 'b')
                            System.out.print('b' + "  ");
                        else if(extendedBoard[i][j] == 'c')
                            System.out.print('c' + "  ");
                        else if(extendedBoard[i][j] == 'd')
                            System.out.print('d' + "  ");
                        else
                            System.out.print('x' + "  ");
                    }
                    else
                        System.out.print("   ");
                }
                else
                {
                    if(extendedBoard[i][j] == 0)
                    {
                        if(i > 1 && i < 13)
                            System.out.print(" ");
                        else
                            System.out.print("   ");
                    }
                    else
                        System.out.print(extendedBoard[i][j]);
                }
            }
            System.out.println();
        }

    }

    boolean endOfGame()
    {
        for(int i = 0; i < 4; i++)
            if(gracze[i].domek[0] && gracze[i].domek[1] && gracze[i].domek[2] && gracze[i].domek[3])
                return true;
        return false;
    }

    void cofnijPionkaDoDomku(int tura, int pole)
    {
        int index = 0;
        for(int i = 0; i < 4; i++)
            if(gracze[tura].pozycjePionka[i] == pole)
                index = i;
        gracze[tura].pozycjePionka[index] = -1;
    }

    void wykonajNormalnyruch(int tura, int ruch, int pole)
    {
        int index = 0;
        for(int i = 0; i < 4; i++)
            if(gracze[tura].pozycjePionka[i] == pole)
                index = i;
        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 11; j ++)
            {
                if (wspolrzedne[i][j] == gracze[tura].pozycjePionka[index])
                {
                    plansza[i][j] = 'x';
                    if(gracze[tura].pozycjePionka[index] - gracze[tura].start + ruch > 40)
                    {
                        czyPionekWszedlDoDomku(tura);
                        break;
                    }
                }
                if(wspolrzedne[i][j] == gracze[tura].pozycjePionka[index] + ruch)
                {
                    if(plansza[i][j] != 'x' && plansza[i][j] != 0)
                        cofnijPionkaDoDomku(97 - plansza[i][j], wspolrzedne[i][j]);
                    plansza[i][j] = gracze[tura].nazwa;
                }
            }
        gracze[tura].pozycjePionka[gracze[tura].indexPionka] += ruch % 40;
    }

    void wylosowanoSzostka(int tura)
    {
        gracze[tura].wystawPionka();
        for(int i = 0; i < 11; i++)
            for(int j = 0; j < 11; j++)
                if(wspolrzedne[i][j] == gracze[tura].start)
                    plansza[i][j] = gracze[tura].nazwa;
        System.out.println("Wylosowano 6, pionek został przestawiony na pole startowe");
        System.out.println("Rzucam kością jeszcze raz");
        gracze[tura].pozycjePionka[gracze[tura].indexPionka] = gracze[tura].start;
    }

    void czyPionekWszedlDoDomku(int tura)
    {
        gracze[tura].domek[gracze[tura].indexPionka] = true;
        gracze[tura].indexPionka++;
    }

}
public class s26690_p02
{
    public static void main(String[] args)
    {
        start();
    }

    static void start()
    {
        Gracz[] gracze = {new Gracz('a'), new Gracz('b'), new Gracz('c'), new Gracz('d')};
        Plansza plansza = new Plansza(gracze);

        Scanner scanner = new Scanner(System.in);

        int tura = (int)((Math.random() * 100) % 4);
        int rzutKostka;
        int ruch;

        while (!plansza.endOfGame())
        {
            plansza.drawBoard();
            System.out.println(">Ruch Gracza " + plansza.gracze[tura].nazwa);
            rzutKostka = move(tura);

            if(!plansza.gracze[tura].start())
            {
                if(rzutKostka == 6)
                {
                    plansza.wylosowanoSzostka(tura);
                    rzutKostka = move(tura);
                    plansza.wykonajNormalnyruch(tura,rzutKostka,gracze[tura].start);
                }
                else
                {
                    System.out.println(">Niestety nie wylowowano, 6 sprobuj nastepnym razem");
                    System.out.println(">Aby kontynuowac nacisnij dowolny prycisk 1-9");
                    ruch = scanner.nextInt();
                }
            }
            else
            {
                System.out.println("Podaj numer pola na ktorym stoi pionek ktorym chesz sie przesunac");
                ruch = scanner.nextInt();
                plansza.wykonajNormalnyruch(tura,rzutKostka,ruch);

            }
            plansza.czyPionekWszedlDoDomku(tura);
            tura++;
            tura %= 4;
        }
    }

    static void start(int number, int [][]players, int []moves, int []decisions)
    {

    }

    static int dice()
    {
        return (int)((Math.random() * 10000) % 6) + 1;
    }

    static int move(int turn)
    {
        int m = dice();
        System.out.println(">Gracz:  " + (char)(97 + turn));
        System.out.println(">wylosowano: " + m);
        return m;
    }
}
