package hw2;
import java.io.*;
import java.util.*;

public class NameSubstrings {

	public static Scanner keyboard = new Scanner(System.in);
	public static String[] noFirst(String[] origArr, int size)
	{
		String[] modifiedArr = new String[size];
		
		StringBuilder temp;
		for (int i = 0; i < size; i++)
		{
			temp = new StringBuilder(origArr[i]);
			temp.deleteCharAt(0);
			modifiedArr[i] = temp.toString();
		}
	
		return modifiedArr;
	}
	public static void main(String[] args) throws IOException
	{
		//Define variables needed
		String[] lastNames, modifiedArr;
		String inputFileName, outputFileName;
		
		File inputFile, outputFile;
		PrintWriter outputWriter;
		Scanner inputReader;
		
		//Create input file for reading
		System.out.printf("Please enter the input file name: ");
		inputFileName = keyboard.next();
		inputFile = new File(inputFileName);

		if (!inputFile.exists())
		{
			System.out.printf("\nInput file does not exist. ");
		}
		
		inputReader = new Scanner(inputFile);
		
		//Create output file for writing
		System.out.printf("Please enter the output file name: ");
		outputFileName = keyboard.next();
		outputFile = new File(outputFileName);
		outputWriter = new PrintWriter(outputFile);
		
		//String array with 100 rows
		lastNames = new String[100];
		
		//Read input file into String array
		int nameCount = 0;
		while (inputReader.hasNext())
		{
			lastNames[nameCount] = inputReader.next();
			nameCount++;
		}
		
		inputReader.close();
		
		//Calls noFirst
		modifiedArr = noFirst(lastNames, nameCount);
		
		//First name array + " " + modified array
		StringBuilder temp;
		for (int i = 0; i < nameCount; i++)
		{
			temp = new StringBuilder(lastNames[i]);
			temp.append(" ").append(modifiedArr[i]);
			outputWriter.println(temp.toString());
		}
		
		System.out.printf("\nOutput file has been created. ");
		
		outputWriter.close();
		keyboard.close();
	}

}
