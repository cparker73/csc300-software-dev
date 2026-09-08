package salesemployees;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class BasePlusCommissionEmployeeTest {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		ArrayList<CommissionEmployee>commOnlyEmp = new ArrayList<>();
		ArrayList<BasePlusCommissionEmployee>basePlusCommEmp = new ArrayList<>();
	
		System.out.printf("Please enter the name of the input file with Commission Only Salespersons Data:\n");
		String inputFileName = keyboard.next();
		File inputFile = new File(inputFileName);
		if (!inputFile.exists())
		{
			System.out.printf("\nInput file does not exist. ");
			return;
		}
		
		Scanner inputReader = new Scanner(inputFile);
		while(inputReader.hasNext())
		{
			String firstName = inputReader.next();
			String lastName = inputReader.next();
			double grossSales = Double.valueOf(inputReader.next());
			double commissionPercent = inputReader.nextDouble();
			
			commOnlyEmp.add(new CommissionEmployee(firstName, lastName, grossSales, commissionPercent));
		}
		inputReader.close();
		
		System.out.printf("Please enter the name of the input file with Base Plus Commission Only Salespersons:\n");
		inputFileName = keyboard.next();
		inputFile = new File(inputFileName);
		if (!inputFile.exists())
		{
			System.out.printf("\nInput file does not exist. ");
			return;
		}
		
		inputReader = new Scanner(inputFile);
		while(inputReader.hasNext())
		{
			String firstName = inputReader.next();
			String lastName = inputReader.next();
			double grossSales = Double.valueOf(inputReader.next());
			double commissionPercent = Double.valueOf(inputReader.next());
			double baseSalary = inputReader.nextDouble();
			
			basePlusCommEmp.add(new BasePlusCommissionEmployee(firstName, lastName, grossSales, commissionPercent, baseSalary));
		}
		inputReader.close();
		
		System.out.printf("Please enter the name of the output file: ");
		String outputFileName = keyboard.next();
		File outputFile = new File(outputFileName);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		
		outputWriter.printf("Statistics On Commission Only Employees\n");
		outputWriter.printf("%-9s %-10s %s%n", "FNAME", "LNAME", "Total Compensation");
		
		double commissionOnlyPayTotal = 0;
		for (CommissionEmployee temp : commOnlyEmp)
		{
			outputWriter.printf(temp.toString());
			commissionOnlyPayTotal += temp.earnings();
		}
		outputWriter.printf("Total Compensation For Base Pay Plus Commission Employees Is: $%,.2f\n", commissionOnlyPayTotal);
		
		outputWriter.printf("\nStatistics On Base Pay Plus Commission Employees\n");
		outputWriter.printf("%-9s %-10s %s%n", "FNAME", "LNAME", "Total Compensation");
		
		double basePlusCommissionPayTotal = 0;
		for (BasePlusCommissionEmployee temp : basePlusCommEmp)
		{
			outputWriter.printf(temp.toString());
			basePlusCommissionPayTotal += temp.earnings();
		}
		outputWriter.printf("Total Compensation For Commission Only Employees Is: $%,.2f\n", basePlusCommissionPayTotal);
		
		double allEmployeePayTotal = commissionOnlyPayTotal + basePlusCommissionPayTotal;
		outputWriter.printf("\nTotal Compensation For All Employees Is: $%,.2f\n", allEmployeePayTotal);
		
		System.out.printf("\nOutput file has been created. ");
		
		outputWriter.close();
		keyboard.close();
	}

}
