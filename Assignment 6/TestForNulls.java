package asg6q2;
import java.util.ArrayList;
import java.util.Random;

public class TestForNulls 
{
	public static void main(String[] args)
	{ 
		Random randy = new Random(5);
		ArrayList<Integer> intArrayL = new ArrayList<>();
		for (int i = 1; i <= 9; i++)
		{
			intArrayL.add(randy.nextInt(5, 16));
		}
		System.out.printf("It is %s that intArrayL has no null value\n", hasNoNulls(intArrayL));
		intArrayL.add(null);
		System.out.printf("It is %s that intArrayL has no null value\n", hasNoNulls(intArrayL));
		System.out.printf("%s\n", intArrayL);
		
		ArrayList<String> stringArrayL = new ArrayList<>();
		for (int i = 1; i <= 6; i++)
		{
			stringArrayL.add("wxy" + randy.nextInt(9, 28));
		}
		System.out.printf("It is %s that stringArrayL has no null value\n", hasNoNulls(stringArrayL));
		stringArrayL.add(3, null);
		System.out.printf("It is %s that stringArrayL has no null value\n", hasNoNulls(stringArrayL));
		System.out.printf("%s\n", stringArrayL);
	
	}
	
	public static boolean hasNoNulls(ArrayList<?> list)
	{
		for (Object temp : list) {if (temp == null) return false;}
		return true;
	}
}
