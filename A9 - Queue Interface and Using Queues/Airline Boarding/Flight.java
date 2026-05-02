package asg9q2AirlineBoarding;
import java.util.Random;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.io.PrintWriter;

public class Flight 
{
	private String flightName;
	private int seats;
	private int seatsSold;
	private Random randy;
	
	private LinkedList<Passenger> passBooked = new LinkedList<>();
	private PriorityQueue<Passenger> boardingQueue = new PriorityQueue<>(new PassengerComparator());
	
	public Flight(String flightName, int seed)
	{
		setFlightName(flightName);
		randy = new Random(seed);
		setSeats();
	}
	
	public void setFlightName(String fName)
	{
		flightName = fName;
	}
	
	public void setSeats()
	{
		seats = randy.nextInt(75, 151);
	}
	
	public void sellSeats()
	{
		seatsSold = randy.nextInt(0, 1 + seats/2) + seats/2;
		
		for(int i = 0; i < seatsSold; i++)
		{
			if (randy.nextInt(0, 5) == 0) passBooked.add(new FirstClassPassenger());
			else passBooked.add(new CoachPassenger());
		}
	}
	
	public void lineUpCall()
	{
		Iterator<Passenger> passIt = passBooked.iterator();
		while (passIt.hasNext())
		{
			boardingQueue.add(passIt.next());
		}
	}
	
	public void boarding(PrintWriter outputWriter)
	{
		outputWriter.printf("The boarding order for %s with %d seats and %d seats sold is:%n", flightName, seats, seatsSold);
		
		int count = 0;
		while (!boardingQueue.isEmpty())
		{
			Passenger temp = boardingQueue.remove();
			outputWriter.printf("%-15s", temp.getPassengerID());
			
			count++;
			if (count %3 == 0) outputWriter.printf("%n");
		}
		
		if (count %3 != 0) outputWriter.printf("%n");
	}
}
