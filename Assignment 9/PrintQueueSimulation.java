package asg9q3;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintQueueSimulation 
{
	private PriorityQueue<Job> waitQueue;
	private PriorityQueue<Job> finishedQueue;
	private Random randy;
	private Printer[] printer;
	private int totalWaitTime;
	private int currentTime;
	private int numberOfPrinters;
	private int numberOfPrintJobs;
	
	public PrintQueueSimulation(int numberOfJobs, int numberOfPrinters, int seed)
	{
		this.numberOfPrintJobs = numberOfJobs;
		this.numberOfPrinters = numberOfPrinters;
		
		randy = new Random(seed);
		
		waitQueue = new PriorityQueue<>(numberOfPrintJobs);
		finishedQueue = new PriorityQueue<>(numberOfPrintJobs);
		
		printer = new Printer[numberOfPrinters];
		
		for (int i = 0; i < numberOfPrinters; i++)
		{
			printer[i] = new Printer("Printer" + i);
		}
	}
	
	public void simulate()
	{
		boolean flagDone = false;
		int jobNumber = 0;
		
		while (!flagDone)
		{
			if (currentTime %75 == 0 && jobNumber < numberOfPrintJobs)
			{
				int jobTime = randy.nextInt(10, 1001);
				int jobPriority = randy.nextInt(1, 12);
				
				waitQueue.add(new Job(currentTime, jobTime, jobPriority));
				
				jobNumber++;
			}
			for (int i = 0; i < numberOfPrinters; i++)
			{
				if (printer[i].getJob() != null)
				{
					Job temp = printer[i].getJob();
					
					if (currentTime >= temp.getStartTime() + temp.getTimeForJob())
					{
						temp.setEndTime(currentTime);
						finishedQueue.add(temp);
						printer[i].setJob(null);
						printer[i].setStartIdleTime(currentTime);
					}
				}
			}
			for (int i = 0; i < numberOfPrinters; i++)
			{
				if (printer[i].getJob() == null)
				{
					if (!waitQueue.isEmpty())
					{
						Job temp = waitQueue.remove();
						
						temp.setStartTime(currentTime);
						
						printer[i].setJob(temp);
						printer[i].setStartInUseTime(currentTime);
						
						totalWaitTime += temp.getWaitTime();
					}
				}
			}
			currentTime++;
			
			if ((jobNumber == numberOfPrintJobs) && waitQueue.isEmpty())
			{
				flagDone = true;
				
				for (int i = 0; i < numberOfPrinters; i++)
				{
					if (printer[i].getJob() != null)
					{
						flagDone = false;
					}
				}
			}
		}
	}
	
	public void displayStatistics() throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.printf("Enter the name of your output file for the results: ");
		String fileName = keyboard.next();
		PrintWriter pw = new PrintWriter(fileName);
		
		pw.printf("Simulation Results%n");
		pw.printf("Simulation with %d printers lasted %d seconds and processed %d jobs%n", numberOfPrinters, currentTime, numberOfPrintJobs);
		pw.printf("The average time in the wait queue for a job is %.2f seconds%n", (double) totalWaitTime / numberOfPrintJobs);
	
		pw.printf("%nPrinter Statistics%n");
		pw.printf("%16s%11s%7s%n", "Jobs", "Time", "Time");
		pw.printf("%6s%13s%8s%7s%n", "Name", "Processed", "In Use", "Idle");
		
		 for (int i = 0; i < numberOfPrinters; i++)
	     {
	            pw.printf("%-10s%5d%12d%7d%n", printer[i].getPrinterName(), printer[i].getTotalJobsProcessed(), 
	            		  printer[i].getTotalInUseTime(), printer[i].getTotalIdleTime(currentTime));
	     }
		 
		 pw.printf("%nJob Statistics%n");
		 pw.printf("Job No. Priority  Wait Time Length Of Job%n");
		 
		 while (!finishedQueue.isEmpty())
		 {
			 Job temp = finishedQueue.remove();
			 
			 pw.printf("%4d%8d%11d%12d%n", temp.getID(), temp.getPriority(), temp.getWaitTime(), temp.getTimeForJob());
		 }
		 
		 System.out.printf("Output file created.%n");
		 pw.close();
		 keyboard.close();
	}
}
