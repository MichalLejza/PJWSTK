package zad1;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class SimpleTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JTable table = new JTable(new MyTableModel());
            JScrollPane scrollPane = new JScrollPane(table);
            
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}

class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name", "Age", "Country"};
    private Object[][] data = {
            {"John", 25, "USA"},
            {"Alice", 30, "Canada"},
            {"Bob", 22, "UK"},
            {"Eva", 28, "Australia"}
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }
}
