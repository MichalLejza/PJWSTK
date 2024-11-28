package PPJ.SecondSemester.Kolokwium;

class MojWyjateczek extends Exception
{
    public MojWyjateczek(String massage)
    {
        super(massage);
    }
}

public class Three
{
    static void idk() throws MojWyjateczek
    {
        if(Math.random() > 0.5)
            throw new MojWyjateczek("EEEE");
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int result = 1;
        for(int i = 31; i >= 0; i--)
        {
            if((a >>> i) >= b)
            {
                System.out.println(i);
                System.out.println((a >> i) + " " + b);
                System.out.println(b << 2);
            }
        }
        System.out.println(result);
    }
}
