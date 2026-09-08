package q1;

import java.util.function.Predicate;

public class CompoundPredicates
{
	public static <T> void result(Predicate<T> p, T arg)
	{
		if (p.test(arg))
			System.out.printf("The Predicate is true for %s\n",  arg);
		else
			System.out.printf("The Predicate is false for %s\n", arg);
	}

	public static void main(String[] args)
	{	
		Predicate<Integer> pr1 = x -> x >= 60;
		Predicate<Integer> pr2 = x -> x % 2 == 0;
		Predicate<Integer> pr3 = x -> x < 130;
		
		Predicate<Integer> pr4 = pr1.or(pr2).negate().and(pr3);
		
		for (int i = 11; i <= 139; i += 7)
		{
			result(pr4, i);
		}
	}

}
