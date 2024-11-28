package GUI.Cwiczenia1;


class Prostokat
{
    private int h;
    private int w;
    public Prostokat(int w, int h)
    {
        this.w = w;
        this.h = h;
    }

    public void rysuj() throws ProstokatException
    {
        if(w == h)
        {
            System.out.println("Zwykly kwadrat rozmiaru " + w + " x " + h);
        }
        else
        {
            System.out.println("Zwykly prostokat rozmiaru " + w + " x " + h);
        }
        if(w == 0 || h == 0)
            throw new ProstokatException();
        System.out.println();
    }

    public int getHeight()
    {
        return h;
    }

    public int getWidth()
    {
        return w;
    }
}


class ZProstokat extends Prostokat
{
    private char b;
    private char i;

    static int kwadratCount = 1;
    static int prostokatCount = 1;

    private int num;

    public ZProstokat(int w, int h, char i, char b)
    {
        super(w,h);
        this.i = i;
        this.b = b;
        if(w == h)
            this.num = kwadratCount++;
        else
            this.num = prostokatCount++;
    }

    public ZProstokat(int w, char i, char b)
    {
        this(w,w,i,b);
    }

    @Override
    public void rysuj() throws ProstokatException
    {
        if(super.getHeight() == super.getWidth())
        {
            System.out.print("Kwadrat" + "(" + num + ") rozmiaru " + super.getWidth() + " x " + super.getHeight());
        }
        else
        {
            System.out.print("Prostokat" + "(" + num + ") rozmiaru " + super.getWidth() + " x " + super.getHeight());
        }
        if(super.getHeight() == 0 || super.getWidth() == 0 || (super.getHeight() == 1 && this.b != this.i) || (super.getWidth() == 1 && this.b != this.i))
        {
            System.out.println();
            throw new ProstokatException();
        }
        else
            write();
        System.out.println();
    }

    private void write()
    {
        int borders = super.getWidth() * 2 + (super.getHeight() - 2) * 2;
        int interior = super.getWidth() * super.getHeight() - borders;

        if(interior > 0)
            System.out.print(", " + this.i + "=" + interior);
        if(borders > 0)
            System.out.println(", " + this.b + "=" + borders);

        for(int i = 0; i < super.getHeight(); i++)
        {
            for(int j = 0; j < super.getWidth(); j++)
            {
                if(i == 0 || i == super.getHeight() - 1)
                    System.out.print(this.b);
                else
                {
                    if(j == 0 || j == getWidth() - 1)
                        System.out.print(this.b);
                    else
                        System.out.print(this.i);
                }
            }
            System.out.println();
        }
    }
}

class ProstokatException extends Exception
{
    public String getMessage()
    {
        return "Bledny Prostokat!\n";
    }
}

public class Zadanie1
{
    public static void main(String[] args) {

        Prostokat[] pr = {
                new Prostokat(2, 3),
                new Prostokat(0, 3),
                new ZProstokat(4, 'a', 'e'),
                new ZProstokat(5, 3, '*', '+'),
                new ZProstokat(1, 2, 'a', 'a'),
                new ZProstokat(3, 3, '+', 'x'),
                new ZProstokat(1, 2, 'x', 'y'),
                new ZProstokat(3, 4, '^', '$')
        };
        for (Prostokat p : pr)
            try
            {
                p.rysuj();
            }
            catch(ProstokatException e)
            {
                System.out.println(e.getMessage());
            }
    }
}
