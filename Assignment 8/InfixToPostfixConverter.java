package asg8q4;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class InfixToPostfixConverter 
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		System.out.printf("Please enter name of the file to read infix expressions from: ");
		String inFileName = keyboard.nextLine();
		File inFile = new File(inFileName);
		Scanner inFileRead = new Scanner(inFile);
		
		while(inFileRead.hasNextLine())
		{
			StringBuilder infix = new StringBuilder(inFileRead.nextLine());
			System.out.printf("The original infix expression is:%n%s%n", infix);
			StringBuilder postfix = convertToPostfix(infix);
			System.out.printf("The expression in postfix notation is:%n%s%n%n", postfix);
		}
		
		inFileRead.close();
		keyboard.close();
	}
	
	public static StringBuilder convertToPostfix(StringBuilder infix)
	{
		Stack<Character> charStack = new Stack<>();
		StringBuilder postfixExpression = new StringBuilder();
		charStack.push('(');
		infix.append(')');
		
			for (int infixCount = 0; !charStack.isEmpty(); ++infixCount)
			{
				Character curr = infix.charAt(infixCount);
				
				if (Character.isDigit(curr))
				{
					postfixExpression.append(curr);
					postfixExpression.append(" ");
				}
				
				else if (curr == '(')
				{
					charStack.push(curr);
				}
				
				else if (isOperator(curr))
				{
					while (isOperator(charStack.peek()) && precedence(curr, charStack.peek()))
					{
						postfixExpression.append(charStack.pop());
						postfixExpression.append(" ");
					}
					charStack.push(curr);
				}
				
				else if(curr == ')')
				{
					while(charStack.peek() != '(')
					{
						postfixExpression.append(charStack.pop());
						postfixExpression.append(" ");
					}
					charStack.pop();
				}
			}
			
			return postfixExpression;
		}
	
	public static boolean isOperator(char ch)
	{
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%')
		{
			return true;
		}
		else return false;
	}
	
	public static boolean precedence(char operator1, char operator2)
	{
		if (operator1 == '^') return false;
		else if (operator2 == '^') return true;
		else if (operator1 == '*' || operator1 == '/' || operator1 == '%') return false;
		else if (operator2 == '*' || operator2 == '/' || operator2 == '%') return true;
		else return false;
	}
}
