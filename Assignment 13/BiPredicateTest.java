package q1;

import java.util.function.BiPredicate;

public class BiPredicateTest 
{
	public static <T> void resultBi(BiPredicate<T, T> p, T x, T y)
	{
		if (p.test(x, y))
			System.out.printf("The BiPredicate is true for %s and %s%n", x, y);
		else
			System.out.printf("The BiPredicate is false for %s and %s%n", x, y);
	}
	
	public static void main(String[] args) 
	{
		BiPredicate<Integer, Integer> biPred = (x, y) -> x > 3;
		
		for (int x = 1; x <= 4; x++)
		{
			for (int y = 1; y <= 4; y++)
			{
				resultBi(biPred.or((i, j) -> j > i).negate(), x, y);
			}
		}
		
	}
}
