package asg9q2AirlineBoarding;

public class Passenger 
{
	private static int ticketCounter = 0;
	
	private String passengerID;
	private String ticketClass;
	private int ticketNumber;
	
	public Passenger(String ticketClass)
	{
		setTicketNumber();
		setTicketClass(ticketClass);
		setPassengerID();
	}
	
	public void setTicketNumber()
	{
		ticketCounter++;
		ticketNumber = ticketCounter;
	}
	
	public void setTicketClass(String tClass)
	{
		ticketClass = tClass;
	}
	
	public void setPassengerID()
	{
		passengerID = String.format("PID_%s %d", ticketClass, ticketNumber);
	}
	
	public String getPassengerID()
	{
		return passengerID;
	}
	
	public String getTicketClass()
	{
		return ticketClass;
	}
	
	public int getTicketNumber()
	{
		return ticketNumber;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%n", getPassengerID());
	}
}
