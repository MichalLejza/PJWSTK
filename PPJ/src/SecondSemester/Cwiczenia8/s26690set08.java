package PPJ.SecondSemester.Cwiczenia8;

public class s26690set08
{
    static void show(int value)
    {
        System.out.println(value);
    }

    static void modifyValue(int wrt)
    {
        System.out.println(wrt);
        wrt *= 5;
        System.out.println(wrt);
    }

    static void Zadanie3(char []napis)
    {
        int []litery = new int[255];
        for (char napi : napis) litery[napi]++;
        for(int i = 0; i < litery.length; i++)
            if(litery[i] > 0)
                System.out.println((char)i + " " + litery[i]);
    }

    static int []losowo()
    {
        int []tab = new int[10];
        for(int i = 0; i < 10; i++)
            tab[i] = (int)(Math.random() * 50) - 20;
        return tab;
    }

    static int []Zadanie4(int []tab1, int []tab2, int wrt)
    {
        int []tab = new int[10];
        for(int i = 0; i < 10; i++)
        {
            if(wrt < 0)
                tab[i] = tab1[i] + tab2[i];
            if(wrt > 0)
                if(tab1[i] != tab2[i])
                    tab[i] = tab1[i];
        }
        return tab;
    }

    static void Zadanie5(int bok, char beg)
    {
        for(int i = 0; i < bok; i++)
        {
            for(int j = 0; j < bok; j++)
            {
                System.out.print(beg + " ");
                if(beg == 'x')
                    beg = 'o';
                else if(beg == 'o')
                    beg = 'x';
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Zadanie5(5, 'x');
    }
}
