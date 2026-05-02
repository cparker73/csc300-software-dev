package asg9q2AirlineBoarding;
import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>
{
	public int compare(Passenger p1, Passenger p2)
	{
		if (p1.getTicketClass().equals(p2.getTicketClass()))
		{
			if (p1.getTicketNumber() < p2.getTicketNumber()) return -1;
			else if (p1.getTicketNumber() > p2.getTicketNumber()) return 1;
			else return 0;
		}
		else if ((p1 instanceof FirstClassPassenger) && !(p2 instanceof FirstClassPassenger)) //p1 is First and p2 is coach
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
