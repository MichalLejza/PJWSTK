package PPJ.SecondSemester.Kolokwium;

class vampire
{
    public int x = 1;
}

class zombie extends vampire
{
    public int x = 5;
}

class mutant extends zombie
{
    public int x = 10;
    public int y = 90;
}

class Para
{
    int x,y;
    public Para()
    {
        this.x = 1;
        this.y = 1;
    }
}

public class One
{
    public static void main(String[] args)
    {
        int time = 9;
        switch (time)
        {
            case 7:
                System.out.println("A");
            case 9:
                System.out.println("B");
            case 010:
                System.out.println("C");
            default:
                System.out.println("None");
        }

        int []arr = { 0b0001, 0x3, '\u0006', 9, 0b0010, 05, 0x07};
        for(int a : arr)
            System.out.println(a);

        System.out.println();

        int val = arr[0];
        for(int k =0; k < arr.length; )
        {
            if(arr[k++] < val)
            {
                System.out.println(k);
                val = arr[k];
                System.out.println((val * 9));
                System.out.println();
            }
            else
            {
                System.out.println(k);
                System.out.println(arr[k - 1]);
                System.out.println();
            }
        }
    }
}

class A
{
    String s;
    A a;
    public A(String s)
    {
        this.s = s;
    }

    public static void main(String[] args) {
        A a1 = new A("first");
        A a2 = new A("second");
        a1.a = a2;
        a2.a = a1;
        System.out.println(a1.a.s);
        System.out.println(a2.a.s);
    }
}

class M
{
    int i = 51;
    public M(int j)
    {
        this.i = j * 10;
    }
}

class N extends M
{
    public N(int j)
    {
        super(j);
        System.out.println(i);
        super
                .i = j  *20;
    }
}

class MainClass
{
    public static void main(String[] args) {
        N n = new N(26);
        System.out.println(n.i);
    }
}