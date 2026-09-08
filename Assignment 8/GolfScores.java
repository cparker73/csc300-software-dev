package asg8q3;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GolfScores 
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter name of file to write Golf Courses results to: ");
		String outFileName = keyboard.next();
		PrintWriter outFile = new PrintWriter(outFileName);
		
		long startTime, endTime;
		
		LinkedList<Hole> lList = new LinkedList<>();
		Random randy1 = new Random(5);
		
		startTime = System.currentTimeMillis();
		
		//Build 1800 holes
		for (int course = 0; course < 100; course++)
		{
			for (int hole = 0; hole < 18; hole++)
			{	
				int par = randy1.nextInt(3, 6);
				int score = randy1.nextInt(par - 2, par + 5);
				
				lList.add(new Hole(par, score));
			}
		}

		//insert totals into 19th hole
		for (int course = 0; course < 100; course++)
		{
			int totalPar = 0;
			int totalScore = 0;
			
			int start = course * 19; //incrementing starts at 0th hole for every course (0, 19, 38...)
			
			for(int hole = start; hole < start + 18; hole++) //adding total pars and scores for 18 holes
			{
				Hole h = lList.get(hole);
				totalPar += h.getPar();
				totalScore += h.getScore();
			}
				lList.add(start + 18, new Hole(totalPar, totalScore)); //storing totals into 19th hole
		}
		
		outFile.printf("Output for LinkedList%n");
		
		//print linked list
		for (int course = 1; course <= 100; course++)
		{
			int start = (course - 1) * 19;
			
			outFile.printf("Course %d%n", course);
			
			outFile.printf("%-6s", "Hole");
			for (int hole = 1; hole <= 18; hole++)
			{	
				outFile.printf("%4d", hole);
			}
			outFile.printf("%6s%n", "Total");
			
			outFile.printf("%-6s", "Par");
			for (int hole = 0; hole < 19; hole++)
			{	
				outFile.printf("%4d", lList.get(start + hole).getPar());
			}
			
			outFile.printf("%n%-6s", "Score");
			for (int hole = 0; hole < 19; hole++)
			{
				outFile.printf("%4d", lList.get(start + hole).getScore());
			}
			
			outFile.printf("%n%n");
		}
		
		endTime = System.currentTimeMillis();
		System.out.printf("The Total number of milliseconds using LinkedList is %d%n", endTime - startTime);
		
		ArrayList<Hole> aList = new ArrayList<>();
		Random randy2 = new Random(5);
		
		startTime = System.currentTimeMillis();
		
		//Build 1800 holes
		for (int course = 1; course <= 100; course++)
		{
			for (int hole = 1; hole <= 18; hole++)
			{	
				int par = randy2.nextInt(3, 6);
				int score = randy2.nextInt(par - 2, par + 5);
				
				aList.add(new Hole(par, score));
			}
		}
		
		//inserts totals at 19th hole
		for (int course = 0; course < 100; course++)
		{
			int totalPar = 0;
			int totalScore = 0;
			
			int start = course * 19; //increments start at every 0th hole for every course (0, 19, 38...)
			
			for(int hole = start; hole < start + 18; hole++) //adding totals of 18 pars and 18 scores
			{
				Hole h = aList.get(hole);
				totalPar += h.getPar();
				totalScore += h.getScore();
			}
				aList.add(start + 18, new Hole(totalPar, totalScore)); //storing totals in 19th hole for every course
		}
		
		outFile.printf("Output for ArrayList%n");
		
		//print array list
		for (int course = 1; course <= 100; course++)
		{
			int start = (course - 1) * 19;
					
			outFile.printf("Course %d%n", course);
					
			outFile.printf("%-6s", "Hole");
			for (int hole = 1; hole <= 18; hole++)
			{	
				outFile.printf("%4d", hole);
			}
			outFile.printf("%6s%n", "Total");
					
			outFile.printf("%-6s", "Par");
			for (int hole = 0; hole < 19; hole++)
			{	
				outFile.printf("%4d", aList.get(start + hole).getPar());
			}
					
			outFile.printf("%n%-6s", "Score");
			for (int hole = 0; hole < 19; hole++)
			{
				outFile.printf("%4d", aList.get(start + hole).getScore());
			}
					
			outFile.printf("%n%n");
		}
		
		endTime = System.currentTimeMillis();
		System.out.printf("The Total number of milliseconds using ArrayList is %d%n", endTime - startTime);
	
	outFile.close();
	keyboard.close();
	}
}
