package GUI.Cwiczenia7;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class Letters extends Thread implements Runnable
{
    String tekst;

    public Letters(String tekst)
    {
        this.tekst = tekst;
    }

    public ArrayList<Thread> getThreads()
    {
        ArrayList<Thread> tab  = new ArrayList<>();

        for(int i = 0; i < tekst.length(); i++)
        {
            tab.add(new Thread(this));
            tab.get(i).setName("Thread " + tekst.charAt(i));
        }

        return tab;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < tekst.length(); i++)
        {
            System.out.print(tekst.charAt(i));
            try {
                TimeUnit.SECONDS.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Zadanie14
{
    public static void main(String[] args) throws InterruptedException
    {
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads())  System.out.println(t.getName());

        ArrayList<Thread> watki = letters.getThreads();
        for (Thread t : watki)
        {
            t.start();
        }
        Thread.sleep(5000);

        for (Thread t : watki)
        {
            t.interrupt();
            t.join();
        }

        System.out.println("\nProgram skończył działanie");
    }
}
