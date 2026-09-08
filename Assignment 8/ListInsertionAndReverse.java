package asg8q2;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class ListInsertionAndReverse 
{
	public static void main(String[] args) 
	{
		long startTime, endTime;
		LinkedList<Integer> lList = new LinkedList<>();
		Random randy1 = new Random(5);
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 25000; i++)
		{
			lList.add(randy1.nextInt(0,2000));
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.printf("The time for populating the LinkedList is %d millisecs%n", endTime - startTime);
		
		listSorting(lList, "LinkedList");
		
		ArrayList<Integer> aList = new ArrayList<>();
		Random randy2 = new Random(5);
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 25000; i++)
		{
			aList.add(randy2.nextInt(0,2000));
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.printf("The time for populating the ArrayList is %d millisecs%n", endTime - startTime);
		
		listSorting(aList, "ArrayList");
	}
	
	public static void listSorting(List<Integer> list, String str)
	{
		long startTime, endTime, totalTime;
		int sum = 0;
		double avg = 0.0;
		
		startTime = System.currentTimeMillis();
		Collections.sort(list);
		for (Integer temp : list)
		{
			sum += temp;
		}
		avg = (double) sum / list.size();
		
		Collections.reverse(list);
		
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		
		System.out.printf("For %s the sum is: %d%n", str, sum);
		System.out.printf("For %s the average is: %.2f%n", str, avg);
		System.out.printf("The total time for averaging, sorting and reversing with %s is %d millisecs%n", str, totalTime);
	}
}
