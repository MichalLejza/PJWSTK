package GUI.Cwiczenia9;

import javax.swing.*;
import java.awt.*;

public class Zadanie18 extends JFrame
{
    public Zadanie18(String arg)
    {
        SwingUtilities.invokeLater(() -> createGui(arg));
    }

    protected void createGui(String arg)
    {
        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("P 2");
        JButton button3 = new JButton("Większy przycisk numer 3");
        JButton button4 = new JButton("Przycisk 4");
        JButton button5 = new JButton("P5");

        JFrame okno = new JFrame("Zadanie18");

        if(arg.equals("A"))
            okno.setLayout(new BorderLayout());
        else if (arg.equals("B"))
            okno.setLayout(new FlowLayout());
        else if (arg.equals("C"))
            okno.setLayout(new FlowLayout(FlowLayout.LEFT));
        else if(arg.equals("D"))
            okno.setLayout(new FlowLayout(FlowLayout.RIGHT));
        else if (arg.equals("E"))
            okno.setLayout(new GridLayout(1,5));
        else if (arg.equals("F"))
            okno.setLayout(new GridLayout(5,1));
        else
            okno.setLayout(new GridLayout(3,2));

       // okno.setLayout(new GridLayout(3,2));

        okno.add(button1);
        okno.add(button2);
        okno.add(button3);
        okno.add(button4);
        okno.add(button5);

        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(1000, 300);
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Zadanie18("D");
    }
}