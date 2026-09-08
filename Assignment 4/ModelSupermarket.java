package asg4q2;
import java.io.IOException;
import java.util.Scanner;

/*
 * 	This class consists of only the main method which could have a throws clause
	Remember to make any necessary import statements
	Create a Scanner for interactive input
	Request and read in the name of the supermarket (use nextLine)
	Create a new Supermarket with the name as an input parameter
	Request and read in the name of the output file (use next)
	Request and read in the number of minutes to operate the Supermarket
	Call openSupermarket for the created Supermarket
	Call operateSupermarket with the number of minutes to operate the Supermarket for the created Supermarket
	Call generateSupermarketResults with the name of the output file for the created Supermarket

 */
public class ModelSupermarket {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter the name of the Supermarket: ");
		String superName = keyboard.nextLine();
		Supermarket sm = new Supermarket(superName);
		
		System.out.printf("Please enter the name of the output file for Supermarket results: ");
		String outFileName = keyboard.next();
		
		System.out.printf("Please enter the number of minutes to operate the Supermarket: ");
		int minutes = keyboard.nextInt();
		
		System.out.printf("Output file has been created. ");
		
		sm.openSupermarket();
		sm.operateSupermarket(minutes);
		sm.generateSupermarketResults(outFileName);
	}

}
