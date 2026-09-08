package q5;
import java.time.LocalDate;

abstract class TroubleTicket implements Comparable<TroubleTicket> 
{
	private String customerName;
	private int ticketID;
	private String description;
	private LocalDate dueDate;
	private LocalDate servicedDate;
	
	public TroubleTicket(String customerName, int ticketID, String description, int due)
	{
		setCustomerName(customerName);
		setTicketID(ticketID);
		setDescription(description);
		setDueDate(due);
		setServicedDate(LocalDate.now().minusDays(1));
	}
	
	@Override
	public int compareTo(TroubleTicket t)
	{
		return this.dueDate.compareTo(t.getDueDate());
	}
	
	public String getCustomerName() 
	{
		return customerName;
	}
	
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	
	public int getTicketID() 
	{
		return ticketID;
	}
	
	public void setTicketID(int ticketID) 
	{
		this.ticketID = ticketID;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public LocalDate getDueDate() 
	{
		return dueDate;
	}
	
	public void setDueDate(int due)
	{
		this.dueDate = LocalDate.now().plusDays(due);
	}
	
	public LocalDate getServicedDate() 
	{
		return servicedDate;
	}
	
	public void setServicedDate(LocalDate servicedDate)
	{
		this.servicedDate = servicedDate;
	}
	
	@Override
	public String toString()
	{
		return String.format("NAME: %s%nID: %d%nDESCRIPTION: %s%nDUE DATE: %s%nSERVICED DATE: %s%n", 
							 customerName, ticketID, description, dueDate, servicedDate);
	}
	
}
