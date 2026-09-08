package asgq2;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Collections;

public class ContractorSortTest
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.printf("Please enter the name of the input file with Contractor Data: %n");
		String inFileName = keyboard.next();
		File inFile = new File(inFileName);
		Scanner in = new Scanner(inFile);
		
		if (!inFile.exists())
		{
			throw new FileNotFoundException("File does not exist.");
		}
		
		ArrayList<Contractor> contractList = new ArrayList<>();
		
		while(in.hasNext())
		{	
			contractList.add(new Contractor(in.next(), in.next(), in.nextInt()));
		}
		
		in.close();
		
		System.out.printf("List Sorted By Contractor Name%n");
		Collections.sort(contractList, new ComparatorSortName());
		for (Contractor temp : contractList)
		{
			System.out.printf("%s", temp.toString());
		}
		
		System.out.printf("%nList Sorted By Location%n");
		Collections.sort(contractList, new ComparatorSortLocation());
		for (Contractor temp : contractList)
		{
			System.out.printf("%s", temp.toString());
		}
		
		System.out.printf("%nList Sorted By OwnerID%n");
		Collections.sort(contractList, new ComparatorSortOwnerID());
		for (Contractor temp : contractList)
		{
			System.out.printf("%s", temp.toString());
		}
		
		System.out.printf("%nList MultiSorted%n");
		Collections.sort(contractList, new ComparatorMultiSort());
		for (Contractor temp : contractList)
		{
			System.out.printf("%s", temp.toString());
		}
		
		keyboard.close();
	}
}
