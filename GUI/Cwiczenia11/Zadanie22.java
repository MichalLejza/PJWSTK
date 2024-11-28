package GUI.Cwiczenia11;

import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

class CalendarListModel extends AbstractListModel<String> {
    private final ArrayList<String> data;

    public CalendarListModel() {
        data = new ArrayList<>();
        generateData();
    }

    private void generateData() {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int daysInMonth = YearMonth.of(currentYear, currentMonth).lengthOfMonth();

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = LocalDate.of(currentYear, currentMonth, day);
            String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault());
            String entry = day + " - " + dayOfWeek;
            data.add(entry);
        }
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index);
    }
}

public class Zadanie22 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();

            JFrame frame = new JFrame(currentMonth + "." + currentYear);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JList<String> calendarList = new JList<>(new CalendarListModel());
            calendarList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            JScrollPane scrollPane = new JScrollPane(calendarList);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}