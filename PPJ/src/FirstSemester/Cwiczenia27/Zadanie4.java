package PPJ.FirstSemester.Cwiczenia27;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zadanie4
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
            if (val <= head.data)
            {
                push(val);
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
                newNode.next = previous.next;
                previous.next = newNode;
                size++;
            }
        }

        public void append(int newData)
        {
            Node newNode = new Node(newData);

            if (head == null)
            {
                head = new Node(newData);
                size++;
                return;
            }

            newNode.next = null;
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = newNode;
            size++;
        }

        public int size() {
            return size;
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
                    lista.insertAfter(number);
            }
        }

        File file = new File("/Users/michallejza/Downloads/PJWSTK/src/DuzyPlikZliczbami.txt");

        if( file.createNewFile() )
        {
            PrintWriter writer = new PrintWriter("/Users/michallejza/Downloads/PJWSTK/src/DuzyPlikZliczbami.txt");
            while (lista.head != null)
            {
                writer.print(lista.head.data);
                writer.print(' ');
                lista.head = lista.head.next;
            }
            writer.close();
        }
        else
        {
            System.out.println("Error, file was not created correctly");
        }
    }

    public static void main(String[] args) throws IOException
    {
        int numberOfFiles = 1000;
        createOneBigFile(numberOfFiles);
    }
}
