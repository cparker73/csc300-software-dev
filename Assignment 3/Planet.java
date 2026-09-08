package solarsystem;
import java.util.Random;

public class Planet 
{
	public static Random randyPlanet = new Random(11);
	private String planetName;
	private int planetTons;
	
	public Planet()
	{
		setPlanetName("unknown");
	}
	
	public Planet(String planetName)
	{
		int minWeight = 10000000; //10 million
		int maxWeight = 80000000; //80 million
		
		setPlanetName(planetName);
		setPlanetTons(randyPlanet.nextInt(minWeight, maxWeight + 1));
	}
	
	public void setPlanetName(String planetName)
	{
		this.planetName = planetName; 
	}
	
	public void setPlanetTons(int planetTons)
	{
		this.planetTons = planetTons;
	}
	
	public String getPlanetName()
	{
		return this.planetName;
	}
	
	public int getPlanetTons()
	{
		return this.planetTons;
	}
	
	public String toString()
	{
		String toString = String.format("The planet named %s weighs %,d tons\n", getPlanetName(), getPlanetTons());
		return toString;
	}
	
	public boolean equals(Planet planet)
	{
		if (this.planetName.equals(planet.planetName) && this.planetTons == planet.planetTons)
		{
			return true;
		}
		else return false;
	}
}
