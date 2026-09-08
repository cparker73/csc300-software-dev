package asg9q3;
import java.util.Scanner;
import java.io.IOException;

public class TestPrintQueueSimulation {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter the number of printers for the simulation: ");
		int numberOfPrinters = keyboard.nextInt();
		
		System.out.printf("Please enter the number of printer jobs for the simulation: ");
		int numberOfPrintJobs = keyboard.nextInt();
		
		System.out.printf("Please enter a random number seed for the simulation: ");
		int seed = keyboard.nextInt();
		
		PrintQueueSimulation pqs = new PrintQueueSimulation(numberOfPrintJobs, numberOfPrinters, seed);
		pqs.simulate();
		pqs.displayStatistics();
		
		keyboard.close();
		System.exit(0);
	}
}
