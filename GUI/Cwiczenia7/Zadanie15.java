package GUI.Cwiczenia7;

enum TaskState {CREATED, RUNNING, ABORTED, READY};

class StringTask implements Runnable
{
    String napis;
    TaskState state;
    String wynik;
    int liczba;

    int repeats;
    Thread thread;

    boolean aborted;
    public StringTask(String napis, int liczba)
    {
        this.liczba = liczba;
        this.napis = napis;
        this.state = TaskState.CREATED;
        this.wynik = "";
        this.repeats = 0;
        this.thread = new Thread(this);
        this.aborted = false;
    }

    @Override
    public void run()
    {
        if(this.state != TaskState.ABORTED)
            this.state = TaskState.RUNNING;
        
        while (this.state == TaskState.RUNNING)
        {
            for(int i = napis.length() - 1; i >= 0; i--)
                this.wynik  = this.wynik + this.napis.charAt(i);
            this.repeats++;

            if(repeats == liczba)
                this.state = TaskState.READY;
            if(aborted)
                this.state = TaskState.ABORTED;
        }
    }

    public String getResult()
    {
       return wynik;
    }

    public TaskState getState()
    {
        return state;
    }

    public void start()
    {
        thread.start();
    }

    public void abort()
    {
        this.thread.interrupt();
        this.state = TaskState.ABORTED;
    }

    public boolean isDone()
    {
        return state.equals(TaskState.READY) || state.equals(TaskState.ABORTED);
    }

    public String getTxt()
    {
        return napis;
    }
}

public class Zadanie15
{
    public static void main(String[] args) throws InterruptedException
    {
        StringTask task = new StringTask("ABC", 50000);
        System.out.println("Task " + task.getState());
        task.start();
        if (args.length > 0 && args[0].equals("abort"))
        {
            Thread.sleep(1000);
            task.abort();
            Thread t = new Thread(task);
            t.start();
        }
        while (!task.isDone())
        {
            Thread.sleep(500);
            switch(task.getState()) {
                case RUNNING: System.out.print("R."); break;
                case ABORTED: System.out.println(" ... aborted."); break;
                case READY: System.out.println(" ... ready."); break;
                default: System.out.println("uknown state");
            }

        }
        System.out.println("Task " + task.getState());
        System.out.println(task.getResult().length());
        System.out.println(task.getResult().substring(0,task.getTxt().length()));
    }

}
