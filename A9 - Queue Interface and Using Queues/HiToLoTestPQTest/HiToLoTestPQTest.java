package asg9q1;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.PriorityQueue;

public class HiToLoTestPQTest 
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter the name of your input file: "); //employees.txt
		String inFileName = keyboard.next();
		
		File inFile = new File(inFileName);
		if (!inFile.exists())
		{
			System.out.printf("File does not exist.%n");
			System.exit(0);
		}
		
		Scanner inFileRead = new Scanner(inFile);
		
		System.out.printf("Please enter the name of your output file: ");
		String outFileName = keyboard.next();
		PrintWriter outFile = new PrintWriter(outFileName);
		
		PriorityQueue<EmployeeZ> pq = new PriorityQueue<>();
		while (inFileRead.hasNext())
		{
			String firstName = inFileRead.next();
			double salary = inFileRead.nextDouble();
			
			pq.add(new EmployeeZ(firstName, salary));
		}
		
		inFileRead.close();
		
		outFile.printf("%8s%12s%n", "NAME", "SALARY");
		while(!pq.isEmpty())
		{
			EmployeeZ temp = pq.remove();
			outFile.printf("%8s%12.2f%n", temp.getFirstName(), temp.getSalary());
		}
		
		System.out.printf("Output file has been printed.");
		
		outFile.close();
		keyboard.close();
		System.exit(0);
	}
}
