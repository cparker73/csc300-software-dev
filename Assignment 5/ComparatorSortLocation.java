package asgq2;
import java.util.Comparator;

public class ComparatorSortLocation implements Comparator<Contractor>
{
	@Override
	public int compare(Contractor c1, Contractor c2)
	{
		return c1.getLocation().compareTo(c2.getLocation());
	}
}
