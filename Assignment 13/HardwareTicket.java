package q5;

public class HardwareTicket extends TroubleTicket 
{
	private String device;
	private String model;
	private String serialNumber;
	
	public HardwareTicket(String customerName, int ticketID, String description, int due, String device, String model, String serialNumber)
	{
		super(customerName, ticketID, description, due);
		setDevice(device);
		setModel(model);
		setSerialNumber(serialNumber);
	}
	
	public String getDevice()
	{
		return this.device;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public String getSerialNumber()
	{
		return this.serialNumber;
	}
	
	public void setDevice(String device)
	{
		this.device = device;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}
	
	public String toString()
	{
		return String.format("%s%nDEVICE: %s%nMODEL: %s%nSERIAL NUMBER: %s%n", super.toString(), device, model, serialNumber);
	}
}
