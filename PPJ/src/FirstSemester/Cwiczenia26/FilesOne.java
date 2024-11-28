package PPJ.FirstSemester.Cwiczenia26;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesOne
{
    static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static class Lista
    {
        Node head;
        private int size = 0;

        public void push(int new_data)
        {
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
            size++;
        }

        public void insertAfter(int val)
        {
            if(val < head.data)
            {
                push(val);
                return;
            }
            else
            {
                Node newNode = new Node(val);
                Node previous = null;
                Node temp = head;

                while (temp != null && temp.data < val)
                {
                    previous = temp;
                    temp = temp.next;
                }
                if(previous == null)
                    append(val);
                else
                {
                    newNode.next = previous.next;
                    previous.next = newNode;
                    size++;
                }
            }
        }

        public void append(int new_data)
        {
            Node new_node = new Node(new_data);
            if (head == null)
            {
                head = new Node(new_data);
                size++;
                return;
            }
            new_node.next = null;
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = new_node;
            size++;
            return;
        }
        public int size()
        {
            return size;
        }
    }

    static void swap(int i, int j, int []tab)
    {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
    static void sort(int []tab)
    {
        for(int i = 0; i < tab.length - 1; i++)
            for(int j = i; j < tab.length; j++)
                if(tab[j] < tab[i])
                    swap(i,j,tab);
    }

    static void createNFiles(int numberOfFiles) throws IOException {
        for(int i = 0; i < numberOfFiles; i++)
        {
            String path = "/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Pliki/Plik"+i+".txt";
            File file = new File(path);
            file.createNewFile();

            int []numbers = new int[10];
            for(int j = 0; j < 10; j++)
                numbers[j] = (int)(Math.random() * 800);
            sort(numbers);

            PrintWriter write = new PrintWriter(path);

            for(int j = 0; j < 10; j++)
                write.println(numbers[j]);
            write.close();
        }
    }

    static void createOneBigFile(int numberOfFiles) throws IOException
    {
        Lista lista = new Lista();
        for(int i = 0; i < numberOfFiles; i++)
        {
            File file = new File("/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Pliki/Plik"+i+".txt");
            Scanner scanFiles = new Scanner(file);
            while (scanFiles.hasNextInt())
            {
                int number = scanFiles.nextInt();

                if(lista.size() == 0)
                    lista.append(number);
                else
                {
                    lista.insertAfter(number);
                }
            }
        }
        File file = new File("/Users/michallejza/Downloads/PJWSTK/src/DuzyPlikZliczbami.txt");
        file.createNewFile();

        PrintWriter writer = new PrintWriter("/Users/michallejza/Downloads/PJWSTK/src/DuzyPlikZliczbami.txt");
        while (lista.head != null)
        {
            writer.print(lista.head.data);
            writer.print(' ');
            lista.head = lista.head.next;
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException
    {
        int numberOfFiles = 500;
        createNFiles(numberOfFiles);
        createOneBigFile(numberOfFiles);
    }
}
