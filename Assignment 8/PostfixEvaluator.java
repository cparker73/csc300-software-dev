package asg8q5;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PostfixEvaluator {

	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter name of the file to read postfix expressions from: ");
		String inFileName = keyboard.nextLine();
		File inFile = new File(inFileName);
		Scanner inFileRead = new Scanner(inFile);
		
		while(inFileRead.hasNextLine())
		{
			StringBuilder postfixExpression = new StringBuilder(inFileRead.nextLine());
			System.out.printf("The original postfix expression is: %n%s%n", postfixExpression);
			System.out.printf("The value of the expression is: %d%n", evaluatePostfixExpression(postfixExpression));
		}
		
		inFileRead.close();
		keyboard.close();
	}
	
	public static int evaluatePostfixExpression(StringBuilder expr)
	{
		Stack<Integer> intStack = new Stack<>();
		expr.append(')');
		
		for (int i = 0; expr.charAt(i) != ')'; i++)
		{
			Character curr = expr.charAt(i);
			
			if(Character.isDigit(curr))
			{
				intStack.push(curr - '0');
				printStack(intStack);
			}
			else if (isOperator(curr))
			{
				Integer popVal2 = intStack.pop();
				Integer popVal1 = intStack.pop();
				
				printStack(intStack);
				intStack.push(calculate(popVal1, popVal2, curr));
				printStack(intStack);
			}	
		}
		
		return intStack.pop();
	}
	
	public static boolean isOperator(char ch)
	{
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%')
		{
			return true;
		}
		else return false;
	}
	
	public static int calculate(int op1, int op2, char oper)
	{
		switch(oper)
		{
			case '+':
				return op1 + op2;
			case '-':
				return op1 - op2;
			case '*':
				return op1 * op2;
			case '/':
				return op1 / op2;
			case '^':
				return (int)Math.pow(op1, op2);
			case '%':
				return op1 % op2;
			default:
				return 0;
		}
	}
	
	public static void printStack(Stack<Integer> intStack)
	{
		for (Integer n : intStack)
		{
			System.out.println(n);
		}
		System.out.println();
	}
}
