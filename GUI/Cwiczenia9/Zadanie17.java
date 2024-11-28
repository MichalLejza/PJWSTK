package GUI.Cwiczenia9;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Zadanie17
{
    public Zadanie17(String font, String bold, String size)
    {
        SwingUtilities.invokeLater(() -> createGui(font,bold,size));
    }

    protected void createGui(String f, String b,String s)
    {
        JFrame frame = new JFrame("Zadanie17");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JColorChooser colorChooser = new JColorChooser(Color.BLUE);
        colorChooser.setOpaque(true);

        JPanel panel = new JPanel();

        JTextArea textArea = new JTextArea(4,20);
        textArea.setBounds(10,30, 200,200);
        Font font = Font.decode(f+"-"+b+"-"+s);
        textArea.setFont(font);
        textArea.setForeground(Color.BLACK);

        ColorSelectionModel model = colorChooser.getSelectionModel();

        ChangeListener changeListener = changeEvent -> {
            Color newForegroundColor = colorChooser.getColor();
            textArea.setForeground(newForegroundColor);
        };
        model.addChangeListener(changeListener);
        panel.add(textArea);
        panel.add(colorChooser);
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Zadanie17(args[0], args[1], args[2]);
    }
}
