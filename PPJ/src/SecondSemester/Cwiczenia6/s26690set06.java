package PPJ.SecondSemester.Cwiczenia6;

public class s26690set06
{
    static void Zadanie1()
    {
        int []tab = new int[10];
    }

    static int[] Zadanie2()
    {
        int []tab = new int[10];
        for(int i = 0; i < tab.length; i++)
            tab[i] = (((int)(Math.random() * 100)) % 2);
        return tab;
    }

    static void Zadanie3()
    {
        int jeden = 0;
        int zero = 0;
        int []tab = Zadanie2();
        for(int i = 0; i < tab.length; i++)
            if(tab[i] == 0)
                zero++;
        jeden = tab.length - zero;
    }

    static void Zadanie4()
    {
        double []tab = new double[10];
        for(int i = 0; i < tab.length; i++)
            tab[i] = (Math.random() * 100);
        for(int i = 0 ; i < tab.length; i++)
            System.out.println(tab[i]);
        for(int i = 0 ; i < tab.length; i++)
            System.out.println(i % 2 == 0 ? tab[i] : "");
        for(int i = 0 ; i < tab.length; i++)
            System.out.println((int)(tab[i] % 2) != 0 ? tab[i] : "");
    }

    static void Zadanie5()
    {
        //int tab[];
        //System.out.println(tab);
    }

    static void Zadanie6()
    {
        int tab[ ] = {  789 ,  678 ,  567};
        for(int i= 0;i<tab.length;i++)
            for(int j=i;j<tab.length;j++)
                System.out.println(tab[i] - tab[j]);
    }

    static void Zadanie7()
    {
        String[ ]slowa= {"Ala","kota","ma","ma","a","kot","Ale"};
        System.out.println(slowa[0] + " " + slowa[2] + " " + slowa[1] + " " + slowa[4] + " " + slowa[5] + " " + slowa[6] + " " + slowa[3] + " " + slowa[7]);
    }

    static void Zadanie8()
    {
        char []litery = new char[20];
        for(int i = 0; i < 20; i++)
            litery[i] = (char)(Math.random() * 26 + 65);
        char []odbicie = new char[20];
        int j = 0;
        for(int i = 19; i >= 0; i--)
        {
            odbicie[i] = litery[j];
            j++;
        }
    }

    public static void main(String[] args)
    {

    }
}
