package asg5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;

public class WeightyDinos 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ArrayList<Dinosaur> dinoList = new ArrayList<>();
		Random randy = new Random(4);
		
		for (int i = 0; i < 12; i++)
		{
			dinoList.add(new Dinosaur(randy.nextInt(50000, 200001)));
		}
		
		Collections.sort(dinoList);
		Iterator<Dinosaur> it = dinoList.iterator();
		
		System.out.printf("%-13s%s%n", "Name", "Weight");
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
