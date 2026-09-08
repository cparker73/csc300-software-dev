package q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PopulationData 
{
	public static Scanner keyboard = new Scanner(System.in);
	
	/*Method getDataFromFile accepts a reference to an ArrayList of type Integer and the name of the input file as a type String, and has a void return
	Create a Scanner that reads from the input file, making sure that the input file exists
	It reads in the population data as an Integer, line by line, and places the value into the ArrayList*/
	public static void getDataFromFile(ArrayList<Integer> arr, String name) throws FileNotFoundException
	{
		File inputFile = new File(name);
		
		if (!inputFile.exists())
		{
			System.out.printf("Input File does not exist. ");
		}
		
		Scanner inputReader = new Scanner(inputFile);
		
		while(inputReader.hasNext())
		{
			arr.add(inputReader.nextInt());
		}
		
		inputReader.close();
	}
	
	/*Method getAverageChange accepts a reference to an ArrayList of type Integer, and has a return value of type double
	It gets calculates the sum of the changes from one year to the next and returns as a double the average change 
	 */
	public static double getAverageChange(ArrayList<Integer> arr)
	{
		double avgChange;
		
		int sumChange = 0;
		for (int i = 0; i < arr.size() - 1; i++)
		{
			int change = arr.get(i + 1) - arr.get(i);
			sumChange += change;
		}
		
		double numOfChange = arr.size() - 1;
		avgChange = sumChange / numOfChange;
		
		return avgChange;
	}
	
	/*Method getHighestIndex accepts a reference to an ArrayList of type Integer, and has a return value of type int
			This method returns the index in the array List of the highest change year over year*/
	public static int getHighestIndex(ArrayList<Integer> arr)
	{
		int highestChange = arr.get(1) - arr.get(0);
		int index = 0;
		
		for (int i = 0; i < arr.size() - 1; i++)
		{
			int change = arr.get(i + 1) - arr.get(i);
			if (change > highestChange)
			{
				highestChange = change;
				index = i + 1;
			}
		}
		
		return index;
	}
	
	/*Method getLowestIndex accepts a reference to an ArrayList of type Integer, and has a return value of type int
	This method returns the index in the array List of the lowest change year over year*/
	public static int getLowestIndex(ArrayList<Integer> arr)
	{
		int lowestChange = arr.get(1) - arr.get(0);
		int index = 0;
		
		for (int i = 0; i < arr.size() - 1; i++)
		{
			int change = arr.get(i + 1) - arr.get(i);
			if (change < lowestChange)
			{
				lowestChange = change;
				index = i + 1;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) throws IOException 
	{
		//Set the following 2 values:
		final int YEAR_START = 1950;
	    final int YEAR_END = 1990;
		
		//Create an ArrayList population to store each year’s population into.
		ArrayList<Integer> population = new ArrayList<>();
		
		//Read in the name of the file with the population data.
		System.out.printf("Please enter the name of your input file: ");
		String inputFileName = keyboard.next();
		
		//Call getDataFromFile with references to the population ArrayList and the input file name.
		getDataFromFile(population, inputFileName);
		
		//Call getAverageChange with the population ArrayList. It returns the average population changes as a double.
		double avgChange = getAverageChange(population);
		
		//Call getHighestIndex with the population array. It returns the index of the cell with the year with highest change.
		int highestIndex = getHighestIndex(population);
		
		//Use the index value + YEAR_START to find the year with the greatest population change.
		int highestYear = highestIndex + YEAR_START;
		
		//Call getLowestIndex with the population array. It returns the index of the cell with the year with lowest change.
		int lowestIndex = getLowestIndex(population);
		
		//Use the index value + YEAR_START to find the year with the lowest population change.
		int lowestYear = lowestIndex + YEAR_START;
		
		//Print out the results as shown below, based on the values calculated in the methods
		System.out.printf("\nThe average annual change in population from %d through %d was %.2f", YEAR_START, YEAR_END, avgChange);
		System.out.printf("\nThe year with the greatest increase in population from %d through %d was %d", YEAR_START, YEAR_END, highestYear);
		System.out.printf("\nThe year with the smallest increase in population from %d through %d was %d", YEAR_START, YEAR_END, lowestYear);
		
		keyboard.close();
	}
}
