package asgq2;
import java.util.Comparator;

public class ComparatorSortOwnerID implements Comparator<Contractor>  
{
	@Override
	public int compare(Contractor c1, Contractor c2)
	{
		return c1.getOwnerID() - c2.getOwnerID();
	}
}
