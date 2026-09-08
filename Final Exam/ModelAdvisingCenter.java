//package finalProject;

import java.io.IOException;
import java.util.Scanner;

public class ModelAdvisingCenter 
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Please enter the name of department name at the Advising Center at CSUDH:%n");
		String deptName = keyboard.nextLine();
		
		System.out.printf("Please enter a seed value as an int:%n");
		int seed = keyboard.nextInt();
		
		System.out.printf("Please enter the number of advisors as an int:%n");
		int numAdv = keyboard.nextInt();
	
		AdvisingCenter advCenter = new AdvisingCenter(deptName, seed, numAdv);
		advCenter.openAdvisingCenter();
		
		System.out.printf("Please enter the number of minutes to keep the Advising Center open:%n");
		int durationForArriving = keyboard.nextInt();
		advCenter.operateAdvisingCenter(durationForArriving);
		
		System.out.printf("Please enter the name of the output file for Advising Center results: ");
		String outFile = keyboard.next();
		advCenter.generateAdvisingCenterResults(outFile);
		
		System.out.printf("%nOutput file has been created.");
		keyboard.close();
	}
}
