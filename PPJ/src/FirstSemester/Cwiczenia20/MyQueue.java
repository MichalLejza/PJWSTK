package PPJ.FirstSemester.Cwiczenia20;

public class MyQueue
{
    private int length;
    private Node front;
    private Node rear;

    public MyQueue()
    {
        length = 0;
        front = rear = null;
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public int size()
    {
        return length;
    }

    public void push(String data)
    {
        Node node = new Node(data);
        if(isEmpty())
        {
            front = node;
        }
        else
        {
            rear.setNextNode(node);
        }
        rear = node;
        length++;
    }

    public void pop()
    {
        if(isEmpty())
        {
            System.out.println("Kolejka jest pusta");
            return;
        }
        front = front.getNextNode();
        length--;
        if(isEmpty())
            rear = null;
    }

    public String frontElement()
    {
        if(isEmpty())
        {
            System.out.println("Kolejka jest pusta");
            return "";
        }
        return front.getData();
    }

    public void printQueue()
    {
        MyQueue run = new MyQueue();
        run.front = front;
        while (run.front != null)
        {
            System.out.print(run.front.getData() + " ");
            run.front = run.front.getNextNode();
        }
        System.out.println();
    }
}
