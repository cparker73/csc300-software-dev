package asgq2;
import java.util.Comparator;

public class ComparatorSortName implements Comparator<Contractor> 
{
	@Override
	public int compare(Contractor c1, Contractor c2)
	{
		return c1.getName().compareTo(c2.getName());
	}
}
