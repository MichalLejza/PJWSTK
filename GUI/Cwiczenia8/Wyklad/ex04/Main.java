package GUI.Cwiczenia8.Wyklad.ex04;

class Counter
{
    private int count = 0;

    public synchronized void increase(){
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class Main
{
    public static void main(String[] args) {
        final Counter counter = new Counter();

        Thread t1 = new Thread(
                ()->{
                    for(int i=0; i<1000; i++)
                        counter.increase();
                }
        );
        Thread t2 = new Thread(
                ()->{
                    for(int i=0; i<1000; i++)
                        counter.increase();
                }
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());


    }
}
