package asg9q1;

public class EmployeeZ implements Comparable<EmployeeZ> 
{
	private String firstName;
	private double salary;
	
	public EmployeeZ(String firstName, double salary)
	{
		setFirstName(firstName);
		setSalary(salary);
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	@Override
	public int compareTo(EmployeeZ e)
	{
		if (Math.abs(e.getSalary() - getSalary()) <= 0.01) return 0;
		else if (e.getSalary() < getSalary()) return -1;
		else return 1;
	}
}
