package GUI.Cwiczenia11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Zadanie23 extends JFrame
{
    private final JTextField textField;
    private final ArrayList<String> dataList;
    private final JList<String> list;

    public Zadanie23()
    {
        setTitle("Zadanie23");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (!text.isEmpty() && !dataList.contains(text)) {
                    int index = getInsertIndex(text);
                    dataList.add(index, text);
                    list.setListData(dataList.toArray(new String[0]));
                    textField.setText("");
                }
            }
        });
        add(textField, BorderLayout.NORTH);

        dataList = new ArrayList<>();
        list = new JList<>();
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) {
                        dataList.remove(selectedIndex);
                        list.setListData(dataList.toArray(new String[0]));
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int[] selectedIndices = list.getSelectedIndices();
                for (int index : selectedIndices) {
                    String selectedValue = dataList.get(index);
                    System.out.println("Selected: " + selectedValue);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private int getInsertIndex(String text) {
        int index = 0;
        while (index < dataList.size() && text.compareTo(dataList.get(index)) >= 0)
            index++;
        return index;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Zadanie23 app = new Zadanie23();
            app.setVisible(true);
        });
    }
}