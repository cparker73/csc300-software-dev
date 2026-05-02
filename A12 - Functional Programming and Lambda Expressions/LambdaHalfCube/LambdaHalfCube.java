package asg12;
import java.util.Scanner;

interface CalcValue
{
	double calculate (double b);
}

public class LambdaHalfCube
{
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		CalcValue e1 = x -> Math.pow(x, 3) / 2;
		CalcValue e2 = x -> { return Math.pow(x, 3) / 2; };
		
		System.out.printf("Please enter the base as a type double to 2 decimal places: ");
		double base1 = keyboard.nextDouble();
		double result = e1.calculate(base1);
		System.out.printf("Without using return the value of half the cube power of %.2f is %.3f%n", base1, result);
		
		System.out.printf("Please enter the base as a type double to 2 decimal places: ");
		double base2 = keyboard.nextDouble();
		result = e2.calculate(base2);
		System.out.printf("Using return the value of half the cube power of %.2f is %.3f%n", base2, result);
	
		keyboard.close();
	}
}
