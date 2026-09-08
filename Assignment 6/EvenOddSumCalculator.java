package asg6q3;
import java.util.ArrayList;
import java.util.Random;

public class EvenOddSumCalculator {

	public static void main(String[] args) 
	{
		Random randy = new Random(6);
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 1; i <= 7; i++) intList.add(randy.nextInt(3, 41));
		calculateNumberSum(intList);
		
		ArrayList<Double> doubleList = new ArrayList<>();
		for (int i = 1; i <= 7; i++) doubleList.add(randy.nextDouble() * 84);
		calculateNumberSum(doubleList);
	}
	
	public static <T extends Number> void calculateNumberSum(ArrayList<T> val)
	{
		double sumEven = 0;
		double sumOdd = 0;
		
		for(T temp : val)
		{
			int x = temp.intValue();
			if (x % 2 == 0)
			{
				double y = temp.doubleValue();
				sumEven += y;
			}
			else
			{
				double y = temp.doubleValue(); 
				sumOdd += y;
			}
		}
		
		System.out.printf("Original list of numbers is%n");
		for (T temp: val) System.out.printf("%.2f ", temp.doubleValue());
		
		System.out.printf("%nSum of even numbers is: %.2f%n", sumEven);
		System.out.printf("Sum of odd numbers is: %.2f%n", sumOdd);
		System.out.printf("Sum of all numbers is: %.2f%n%n", sumEven + sumOdd);
	}

}
