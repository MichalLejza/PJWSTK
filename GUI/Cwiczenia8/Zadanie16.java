package GUI.Cwiczenia8;

class Bufor
{
    int []tablica;
    int size;
    public static int pointerGet;
    public static int pointerSet;

    public Bufor(int size)
    {
        this.size = size;
        this.tablica = new int[size];
    }

    private boolean emptyTab()
    {
        for(int i = 0; i < size; i++)
            if(tablica[i] != 0)
                return false;
        return true;
    }

    public int get() throws InterruptedException
    {
        if(!emptyTab())
        {
            int number = tablica[pointerGet];
            if(number == 0)
                return 0;
            else
            {
                pointerGet++;
                if(pointerGet == size)
                    pointerGet = 0;
                return number;
            }
        }
        return 0;
    }

    public void put(int n)
    {
        if(pointerSet == size)
        {
            pointerSet = 0;
        }
        tablica[pointerSet++] = n;
    }

    public void printTab()
    {
        for(int i : tablica)
            System.out.print(i + " ");
        System.out.println();
    }
}

class Producer extends Thread implements Runnable
{
    Bufor b;
    Thread t;
    protected Consumer consumer;

    public Producer(Bufor b)
    {
        this.b = b;
        this.t = new Thread(this);
    }

    @Override
    public void run()
    {
        while (true)
        {
            int number = (int)(Math.random() * 100);
            b.put(number);
            b.printTab();

            synchronized (consumer)
            {
                consumer.notifyAll();
            }

            try
            {
                Thread.sleep((int)(Math.random() * 2000));
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread implements Runnable
{
    Bufor b;
    Thread t;
    Producer producer;
    public Consumer(Bufor b)
    {
        this.b = b;
        this.t = new Thread(this);
    }

    @Override
    public void run()
    {
        while (true)
        {
            int number = 0;
            try
            {
                number = b.get();
                if(number == 0)
                {
                    try
                    {
                        synchronized (this)
                        {
                            wait();
                        }
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e);
                    }
                }
                else
                    System.out.println("Consumer: " + number);

            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try
            {
                Thread.sleep((int)(Math.random() * 2000));
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Zadanie16
{
    public static void main(String[] args)
    {
        Bufor b = new Bufor(15);
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);
        p.consumer = c;
        c.producer = p;
        p.start();
        c.start();
       try {
           Thread.sleep(15000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       System.exit(0);
    }
}
