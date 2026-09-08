package hw22;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class OrderRandomIntegersLeastToGreatest 
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException 
	{
		Random randy;
		int seed;
		
		//Request Seed
		System.out.printf("Please enter a seed: ");
		seed = keyboard.nextInt(10);
		
		//Create random based on seed
		randy = new Random(seed);
		
		//Create variables tempInt and Counter
		int tempInt, counter;
		
		//Create int ArrayList named numberList
		ArrayList<Integer> numberList = new ArrayList<>();
		
		//Initialize tempInt with random int from 3 to 25 and add to numList
		tempInt = randy.nextInt(3, 26);
		numberList.add(tempInt);
		
		//for each of 20 more nums
		for (int i = 1; i <= 20; i++)
		{
			tempInt = randy.nextInt(3, 26);
			
			for(counter = 0; counter < numberList.size(); counter++)
			{
				//sorts from least to greatest
				if (tempInt < numberList.get(counter))
				{
					numberList.add(counter, tempInt);
					break;
				}
			}
			//add to end if never inserted
			if (counter == numberList.size())
			{
				numberList.add(tempInt);
			}
		}
		
		//Request output file name and prep for writing
		System.out.printf("Please enter an output file name: ");
		String outputFileName = keyboard.next();
		File outputFile = new File(outputFileName);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		
		//Write arraylist to output file using toString
		outputWriter.println("Output Using ArrayList to String: ");
		outputWriter.println(numberList.toString());
		
		//Write arraylist to output file using enhanced for
		outputWriter.println();
		outputWriter.println("Output Using Enhanced For: ");
		for (int integer : numberList)
		{
			outputWriter.print(integer + " ");
		}
		
		//Write arraylist to outputfile using iterator
		outputWriter.println();
		outputWriter.println("Output Using The Iterator: ");
		Iterator<Integer> it = numberList.iterator();
		while(it.hasNext())
		{
			outputWriter.print(it.next() + " ");
		}
		
		System.out.printf("\nOutput File has been created. ");
		
		//Close printwriter and keyboard
		outputWriter.close();
		keyboard.close();
	}
}
