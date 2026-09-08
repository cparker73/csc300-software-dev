package solarsystem;
import java.io.IOException;
import java.util.Scanner;

public class CreateSolarSystem 
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter the name of the Solar System: ");
		String solSystemName = keyboard.nextLine();
		System.out.printf("Please enter the name of the Sun: ");
		String sunName = keyboard.nextLine();
		
		SolarSystem solSystem = new SolarSystem(solSystemName, sunName);
		System.out.printf(solSystem.toString());
		
		Planet firstPlanet = solSystem.getPlanet(0);
		if (solSystem.getNumPlanets() > 1)
		{
			boolean noMatches = true;
			for (int i = 1; i < solSystem.getNumPlanets(); i++)
			{
				Planet currPlanet = solSystem.getPlanet(i);
				
				if (firstPlanet.equals(currPlanet))
				{
					System.out.printf("\n%s matches %s", currPlanet, firstPlanet);
					noMatches = false;
				}
			}
			if (noMatches) System.out.printf("\nThere is no planet that matches the first planet\n");
		
			Planet finalPlanet = solSystem.getPlanet(solSystem.getNumPlanets() - 1);	
			finalPlanet.setPlanetName(firstPlanet.getPlanetName());
			finalPlanet.setPlanetTons(firstPlanet.getPlanetTons());
			if (finalPlanet.equals(firstPlanet))
			{
				System.out.printf("%sand equals the first planet in the ArrayList\n", finalPlanet.toString());
			}
		}	
		else System.out.printf("There are no planets to compare\n");
	}
}
