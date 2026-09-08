package asgq2;
import java.util.Comparator;

public class ComparatorMultiSort implements Comparator<Contractor> 
{
	@Override
	public int compare(Contractor c1, Contractor c2)
	{
		if (c1.getName().equals(c2.getName()))
		{
			if (c1.getLocation().equals(c2.getLocation()))
			{
				return c1.getOwnerID() - c2.getOwnerID();
			}
			else return c1.getLocation().compareTo(c2.getLocation());
		}
		else return c1.getName().compareTo(c2.getName());
	}
}
