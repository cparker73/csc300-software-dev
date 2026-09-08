package salesemployees;

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName,
			                          double grossSales, double commissionPercent,
			                          double baseSalary)
	{
		super(firstName, lastName, grossSales, commissionPercent);
		setBaseSalary(baseSalary);
	}
	
	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0)
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		
		this.baseSalary = baseSalary;
	}
	
	@Override
	public double earnings()
	{
		double earnings = baseSalary + super.earnings();
		return earnings;
	}
	
	@Override
	public String toString()
	{
		String toString = String.format("%-9s %-10s $%-,10.2f\n", getFirstName(), getLastName(), this.earnings());
		return toString;
	}
}
