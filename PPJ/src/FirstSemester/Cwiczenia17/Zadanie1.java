package PPJ.FirstSemester.Cwiczenia17;

public class Zadanie1
{
    // Funckja ktora zwraca od jakiego dnia tygodnia zaczyna sie dany miesiac
    // 0 to ponirdzialek, 1 to wtorek itp
    // jest to algorytm RFC 3339, link do opisu algorytmu:
    // https://swistak.codes/post/okreslanie-dnia-tygodnia-dla-dowolnej-daty/
    public static int kongruencjaZellera(int dzien, int miesiac, int rok, int wiek)
    {
       int d =  (dzien + rok + (rok / 4) + (wiek / 4) + (5 * wiek) + ((26 * miesiac - 2) / 10)) % 7;
       d--;
       if(d == -1)
           d = 6;
       return d;
    }

    // funkcja zwraca ilosc dni w danym miesiacu, uwzglednia lata przestepne
    public static int ileDni(int miesiac, int rok)
    {
        if(miesiac == 2)
        {
            if(rokPrzystepny(rok))
                return 29;
            else
                return 28;
        }
        else
        {
            if(miesiac < 8)
            {
                if(miesiac % 2 != 0)
                    return 31;
                else
                    return 30;
            }
            else
            {
                if(miesiac % 2 == 0)
                    return 31;
                else
                    return 30;
            }
        }
    }

    // funkcja boolowska zwraca true gdy rok jest przestepny a false gdy nie jest
    public static boolean rokPrzystepny(int rok)
    {
        return ( rok % 400 == 0 || (rok % 100 != 0 && rok % 4 == 0));
    }

    // procedura drukuje na stdout tablice(kaledarz) plus dni miesiaca i numer tygodnia
    public static void printAray(int [][]tab)
    {
        System.out.println("   P  W  Ś  C  P  S  S");
       for(int i = 0; i < tab.length; i++)
       {
           System.out.print(i + 1 + "  ");
           for(int j = 0; j < tab[i].length; j++)
           {
               if(tab[i][j] > 9)
               {
                   System.out.print(tab[i][j] + " ");
               }
               else
               {
                    if(tab[i][j] != 0)
                    {
                        System.out.print(tab[i][j] + "  ");
                    }
                    else
                    {
                        System.out.print("   ");
                    }
               }
           }
           System.out.println();
       }
    }

    // procedura z zadania
    public static void printMonth(int m, int y)
    {
        int month = m;
        int year = y;
        month -= 2;
        if(month < 1)
        {
            month += 12;
            year -=1;
        }

        int pierwszDzien = kongruencjaZellera(1,month,year % 100,year/100);
        int iloscDni = ileDni(m,y);
        int dni = 1;

        int [][]kalnedarz = new int[6][7];
        for(int i = 0; i < kalnedarz.length; i++)
        {
            for(int j = 0; j < kalnedarz[i].length; j++)
            {
                if(dni <= iloscDni)
                {
                    if(i == 0)
                    {
                        if(j >= pierwszDzien)
                        {
                            kalnedarz[i][j] = dni;
                            dni++;
                        }
                    }
                    else
                    {
                        kalnedarz[i][j] = dni;
                        dni++;
                    }
                }
            }
        }
        printAray(kalnedarz);
    }
    public static void main(String[] args)
    {
        printMonth(2,2022);
    }
}
