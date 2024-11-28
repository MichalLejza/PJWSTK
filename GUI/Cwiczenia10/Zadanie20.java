package GUI.Cwiczenia10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie20
{
    void createGui()
    {
        JFrame frame = new JFrame("Zadanie 20");

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
        JTextArea textArea = new JTextArea();

        JButton buttonRed = new JButton("FR");
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.RED);
            }
        });
        JButton buttonGreen = new JButton("FG");
        buttonGreen.setBackground(Color.GREEN);
        buttonGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.GREEN);
            }
        });
        JButton buttonBlue = new JButton("FB");
        buttonBlue.setBackground(Color.BLUE);
        buttonBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLUE);
            }
        });

        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");
        JButton buttonC = new JButton("C");

        northPanel.add(buttonRed);
        northPanel.add(buttonGreen);
        northPanel.add(buttonBlue);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(buttonA);
        northPanel.add(buttonB);
        northPanel.add(buttonC);

        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));

        JPanel numbers = new JPanel();
        numbers.setLayout(new GridLayout(3,3));
        JButton buttonOne = new JButton("1");
        JButton buttonTwo = new JButton("2");
        JButton buttonThree = new JButton("3");
        JButton buttonFour = new JButton("4");
        JButton buttonFive = new JButton("5");
        JButton buttonSix = new JButton("6");
        JButton buttonSeven = new JButton("7");
        JButton buttonEight = new JButton("8");
        JButton buttonNine = new JButton("9");
        numbers.add(buttonOne);
        numbers.add(buttonTwo);
        numbers.add(buttonThree);
        numbers.add(buttonFour);
        numbers.add(buttonFive);
        numbers.add(buttonSix);
        numbers.add(buttonSeven);
        numbers.add(buttonEight);
        numbers.add(buttonNine);

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(3,1));

        JTextField pole1 = new JTextField();
        pole1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = pole1.getText();
                textArea.append(text + "\n");
                pole1.setText("");
            }
        });
        JTextField pole2 = new JTextField();
        pole2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = pole2.getText();
                textArea.append(text + "\n");
                pole2.setText("");
            }
        });
        JTextField pole3 = new JTextField();
        pole3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = pole3.getText();
                textArea.append(text + "\n");
                pole3.setText("");

            }
        });
        text.add(pole1);
        text.add(pole2);
        text.add(pole3);

        south.add(numbers);
        south.add(Box.createHorizontalGlue());
        south.add(text);


        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);

        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Zadanie20()
    {
        SwingUtilities.invokeLater(() -> createGui());
    }

    public static void main(String[] args)
    {
       new Zadanie20();
    }
}
