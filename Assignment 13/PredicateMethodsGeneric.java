package q1;

import java.util.function.*; 
class PredicateMethodsGeneric
{
	public static <T> void result(Predicate<T> p, T arg)
	{
		if (p.test(arg))
			System.out.printf("The Predicate is true for %s\n",  arg);
		else
			System.out.printf("The Predicate is false for %s\n", arg);
	}
	
	public static void main(String [] args)
	{
		Predicate<Integer> p1 = x->x == 5;
		Predicate<String> p3 = x -> x.charAt(0) == 'G';
		
		for (int x = 4; x < 7; x++)
		{
			result(p1,x);
			result(y->y%2== 0, x);
		}
		
		result(p3, "Hello");
		result(p3, "Goodbye");
	}
}