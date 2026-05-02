package asg9q2AirlineBoarding;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class OperateAirline 
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		String flightName;
		int seed; 
		
		ArrayList<Flight> flightList = new ArrayList<>();
		
		for (int i = 0; i < 3; i++)
		{
			System.out.printf("Please enter the Flight Name:%n");
			flightName = keyboard.nextLine();
			System.out.printf("Please enter an integer seed from 1 to 50:%n");
			seed = keyboard.nextInt();
			
			keyboard.nextLine();
			
			flightList.add(new Flight(flightName, seed));
		}
		
		System.out.printf("Please enter the name of the output file: ");
		String fileName = keyboard.next();
		PrintWriter pw = new PrintWriter(fileName);
		System.out.printf("Output file has been created.%n");
		
		for (Flight temp : flightList)
		{
			temp.sellSeats();
			temp.lineUpCall();
			temp.boarding(pw);
			pw.printf("%n%n");
		}
		
		keyboard.close();
		pw.close();
	}
}
