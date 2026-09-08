package salesemployees;

public class CommissionEmployee 
{
	private final String firstName;
	private final String lastName;
	private double grossSales;
	private double commissionPercent; // As a percentage
	
	public CommissionEmployee(String firstName, String lastName,
							  double grossSales, double commissionPercent)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		setGrossSales(grossSales);
		setCommissionPercent(commissionPercent);
	}
	
	public void setGrossSales(double grossSales)
	{
		if(grossSales < 0.0)
		{
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		this.grossSales = grossSales;
	}
	
	public void setCommissionPercent(double commissionPercent)
	{
		if(commissionPercent < 0.0 || commissionPercent > 100.0)
		{
			throw new IllegalArgumentException("Commission rate must be >= 0.0 and <= 100.0");
		}
		
		this.commissionPercent = commissionPercent;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public double getGrossSales()
	{
		return this.grossSales;
	}
	
	public double getCommissionPercent()
	{
		return this.commissionPercent;
	}
	
	public double earnings()
	{
		double earnings = grossSales * (commissionPercent/100.0);
		return earnings;
	}
	
	public String toString()
	{
		String toString = String.format("%-9s %-10s $%-,10.2f\n", firstName, lastName, earnings());
		return toString;
	}
}
