package GUI.Cwiczenia10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie19
{
    public Zadanie19()
    {
        SwingUtilities.invokeLater(() -> createGui());
    }

    protected void createGui()
    {
        JFrame frame = new JFrame("Zadanie19");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Button");
        button.addActionListener(e -> {
            Color randomColor = generateRandomColor();
            button.setBackground(randomColor);
        });

        frame.setLayout(new GridLayout(3,2));
        frame.getContentPane().add(button);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Zadanie19();
    }

    private static Color generateRandomColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new Color(red, green, blue);
    }
}
