package zad1;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

class NumberTableCellRenderer extends DefaultTableCellRenderer 
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setForeground(Color.BLACK);

        if (value instanceof Integer) 
        {
        	
        	int number = (Integer) value;
            if (number > 20000)
                 component.setForeground(Color.RED);
            else 
                 component.setForeground(Color.BLACK);
       
        }
        return component;
    }
}

public class CountryTable
{
	private String path;
	private CountryList list;
	
    public CountryTable(String countriesFileName)
    {
    	this.path = countriesFileName;
    	this.list = new CountryList();
    }
    
    public void getContentFromFile()
    {
    	try (BufferedReader reader = new BufferedReader(new FileReader(path)))
    	{
    		String line;
    		line = reader.readLine();
    		list.setColumnNames(line.split("\t"));
 
    		while ((line = reader.readLine()) != null)
    		{
    			String []content = line.split("\t");
    			list.add(new Country(content[0], content[1], Integer.parseInt(content[2])));
    		}
    		
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }

    public JTable create()
    {
    	getContentFromFile();
    	JTable table = new JTable(list);
        table.setDefaultRenderer(Object.class, new NumberTableCellRenderer());
        return table;
    }
}
