package solarsystem;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SolarSystem
{
	private String solSystemName;
	private Sun sol;
	private ArrayList<Planet> planetList;
	
	public SolarSystem()
	{
		setSolSystemName("unknown");
		sol = new Sun();
		planetList = new ArrayList<>();
	}
	
	public SolarSystem(String solSystemName, String sunName) throws IOException
	{
		setSolSystemName(solSystemName);
		sol = new Sun(sunName);
		planetList = new ArrayList<>();
		createPlanet();
	}
	
	public void setSolSystemName(String solSystemName)
	{
		this.solSystemName = solSystemName;
	}
	
	public String getSolSystemName()
	{
		return solSystemName;
	}
	
	public String toString()
	{
		String toString = String.format("The name of this solar system is %s\n", solSystemName) + sol.toString();
		for (Planet temp : planetList)
		{
			toString += temp.toString();
		}
		return toString;
	}
	
	public void createPlanet() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Please enter file to read in planet list from: ");
		String planetFileName = keyboard.next();
		File planetFile = new File(planetFileName);
		
		if (!planetFile.exists())
		{
			System.out.printf("Planet file does not exist\n");
		}
		
		Scanner planetReader = new Scanner(planetFile);
		while(planetReader.hasNext())
		{
			planetList.add(new Planet(planetReader.next()));
		}
		
		planetReader.close();
		keyboard.close();
	}
	
	public int getNumPlanets()
	{
		return this.planetList.size();
	}
	
	public Planet getPlanet(int index)
	{
		if (index > getNumPlanets() - 1 || index < 0)
		{
			System.out.printf("Planet does not exist\n");
			return null;
		}
		else
		{
			return planetList.get(index);
		}
	}
}
