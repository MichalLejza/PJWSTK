package zad1;

public class Country 
{
	private String name;
	private String capital;
	private int population;
	
	public Country(String name, String capital, int population)
	{
		this.capital = capital;
		this.name = name;
		this.population = population;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCapital()
	{
		return capital;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public boolean redWriting()
	{
		return population > 20000;
	}
}
