package GUI.Cwiczenia8.Wyklad.ex01;

class Counter
{

    private int count = 0;

    public synchronized void increase()
    {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main
{
    public static void main(String[] args) {
        final Object res1 = new Object();
        final Object res2 = new Object();

        Thread t1 = new Thread(
                ()->{
                    System.out.println("Thread1 started");
                    synchronized (res1){
                        System.out.println("Thread1: pobrano res1");

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        synchronized (res2){
                            System.out.println("Thread1: pobrano res2");
                        }
                    }
                }
        );
        Thread t2 = new Thread(
                ()->{
                    System.out.println("Thread2 started");
                    synchronized (res1){
                        System.out.println("Thread2: pobrano res1");

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        synchronized (res2){
                            System.out.println("Thread2: pobrano res2");
                        }
                    }
                }
        );

        t1.start();
        t2.start();
    }
}
