package asgq2;

public class Contractor
{
	private String name = "";
	private String location = "";
	private int ownerID;
	
	public Contractor(){}
	public Contractor(String name, String location, int ownerID)
	{
		setName(name);
		setLocation(location);
		setOwnerID(ownerID);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setOwnerID(int ownerID)
	{
		this.ownerID = ownerID;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public int getOwnerID()
	{
		return this.ownerID;
	}
	
	public String toString()
	{
		String toString = String.format("%s %s %d%n", this.name, this.location, this.ownerID);
		return toString;
	}
}