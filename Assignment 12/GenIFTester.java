package asg12q2;
import java.util.Scanner;

public class GenIFTester 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		GenericInterface<String> reverse = s -> new StringBuilder(s).reverse().toString();
		
		for (int i = 0; i < 3; i++)
		{
			System.out.printf("Enter a string to be reversed:%n");
			String str = keyboard.nextLine();
			String revStr = reverse.func(str);
			System.out.printf("The entry %s reversed is %s%n", str, revStr);
		}
		
		GenericInterface<Integer> factorial = x -> 
		{
			int temp = 1;
			for (int i = x; i > 0; i--)
			{
				temp *= i;
			}
			
			return temp;
		};
		
		for (int i = 0; i < 3; i++)
		{
			System.out.printf("Enter an integer to be factorialised:%n");
			int n = keyboard.nextInt();
			int nFact = factorial.func(n);
			System.out.printf("factorial of %d = %,d%n", n, nFact);
		}
		
		keyboard.close();
	}
}
