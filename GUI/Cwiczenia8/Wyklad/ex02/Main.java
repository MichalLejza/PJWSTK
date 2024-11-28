package GUI.Cwiczenia8.Wyklad.ex02;

class Runner extends Thread
{

    private char ch;

    public Runner(char ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++)
            System.out.print(ch);
    }
}


public class Main
{
    public static void main(String[] args)
    {
        Runner r1 = new Runner('!');
        Runner r2 = new Runner('@');
        Runner r3 = new Runner('#');

        r1.start();
        r2.start();
        r3.start();
    }
}
