package asg6q1;
import java.util.Scanner;

public class IsEqualToTest {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		boolean result;
		
		System.out.printf("Enter two integer values: ");
		Integer int1 = keyboard.nextInt();
		Integer int2 = keyboard.nextInt();
		result = isEqualTo(int1, int2);
		System.out.printf("%d and %d %s\n\n", int1, int2, (result ? "are equal" : "are not equal"));
		
		System.out.printf("Enter two double values: ");
		Double doub1 = keyboard.nextDouble();
		Double doub2 = keyboard.nextDouble();
		result = isEqualTo(doub1, doub2);
		System.out.printf("%.1f and %.1f %s\n\n", doub1, doub2, (result ? "are equal" : "are not equal"));
		
		System.out.printf("Enter two string values: ");
		String str1 = keyboard.next();
		String str2 = keyboard.next();
		result = isEqualTo(str1, str2);
		System.out.printf("%s and %s %s\n\n", str1, str2, (result ? "are equal" : "are not equal"));
	
		Object obj1 = new Object();
		Object obj2 = new Object();
		result = isEqualTo(obj1, obj2);
		System.out.printf("%s and %s %s\n\n", obj1, obj2, (result ? "are equal" : "are not equal"));
		
		keyboard.close();
	}
	
	public static <T> boolean isEqualTo(T val1, T val2)
	{
		return val1.equals(val2);
	}

}
