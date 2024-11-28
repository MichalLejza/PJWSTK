package GUI.Cwiczenia2;


public class Zadanie3
{
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Dietrich")
        {
            public String spiewaj()
            {
                return "oooooo6oooooo";
            }
        };

        Spiewak s2 = new Spiewak("Piaf")
        {
            public String spiewaj()
            {
                return "a4iBBiii";
            }
        };

        Spiewak s3 = new Spiewak("Adele")
        {
            public String spiewaj()
            {
                return "aAa";
            }
        };

        Spiewak []sp = {s2, s1, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}

abstract class Spiewak
{
    static int numerStartowy = 1;
    int numer;
    String imie;

    public Spiewak(String imie)
    {
        this.imie = imie;
        this.numer = numerStartowy++;
    }

    abstract String spiewaj();

    public String toString()
    {
        return "(" + numer + ") " + imie + ": " + spiewaj();
    }

    public static Spiewak najglosniej(Spiewak [] sp)
    {
        int []spiewacy = new int[sp.length];

        int numerChar = 0;
        int numberLiczba = 0;

        for(int i = 0; i < sp.length; i++)
        {
            for(int j = 0; j < sp[i].spiewaj().length(); j++)
            {
                if(sp[i].spiewaj().charAt(j) >= '0' && sp[i].spiewaj().charAt(j) <= '9')
                {
                    numberLiczba = Math.max((int)sp[i].spiewaj().charAt(j), numberLiczba);
                }
                else
                {
                    numerChar = Math.max((int)sp[i].spiewaj().charAt(j), numerChar);
                }
            }
            spiewacy[i] = numberLiczba + numerChar;
            numberLiczba = 0;
            numerChar = 0;
        }

        int index = 0;
        int max = spiewacy[0];
        for(int i = 0; i < spiewacy.length; i++)
            if(max < spiewacy[i])
                index = i;
        return sp[index];
    }
}
