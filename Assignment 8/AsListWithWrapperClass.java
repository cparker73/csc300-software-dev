package asg8q1;
import java.util.List;
import java.util.Arrays;

public class AsListWithWrapperClass 
{
	public static void main(String[] args) 
	{
		Integer[] arr = new Integer[4];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = i; 
		}
		for (Integer temp: arr)
		{
			System.out.printf("%d ", temp);
		}
		
		List<Integer> list = Arrays.asList(arr);
		System.out.printf("%n%s%n", list);
		
		arr[0] = 10;
		System.out.printf("%s%n", list);
	}
}
