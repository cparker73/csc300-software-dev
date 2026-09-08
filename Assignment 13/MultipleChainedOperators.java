package q1;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MultipleChainedOperators 
{
	public static void main(String[] args) 
	{
		BiFunction<Integer, Integer, Integer> f1 = (x, y) -> 3 * x - 2 * y;
		Function<Integer, Integer> f2 = x -> 4 * x;
		Function<Integer, Double> f3 = x -> x - 2.0;
		
		BiFunction<Integer, Integer, Double> f4 = f1.andThen(f2).andThen(f3);
		
		for (int x = 3; x <= 5; x++)
		{
			for (int y = 5; y <= 8; y++)
			{
				System.out.printf("for the values x = %d and y = %d the result is %.2f%n", x, y, f4.apply(x,  y));
			}
		}
	}
}
