package zad1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CountryList  extends AbstractTableModel
{
	private List<Country> list;
	private String []columnNames;
	
	public CountryList()
	{
		this.list = new ArrayList<Country>();
		
	}
	
	public void setColumnNames(String []names)
	{
		this.columnNames = names;
	}
	
	public void add(Country country)
	{
		list.add(country);
	}
	
	public Country getElemetAt(int index)
	{
		return list.get(index);
	}

	@Override
	public String getColumnName(int column) 
	{
	    return columnNames[column];
	}
	
	@Override
	public int getRowCount() 
	{
		return list.size();
	}

	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		return columnIndex == 0 ? list.get(rowIndex).getName() : 
			   columnIndex == 1 ? list.get(rowIndex).getCapital() : 
			   columnIndex == 2 ? list.get(rowIndex).getPopulation() : 
				"OBRAZEK";
	}
	
}
