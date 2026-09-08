package asg4;
/*	It has instance variables:
	private String destination
	private double budget
	It has a constructor with the two instance variables that calls the mutators for each of the variables.  There are also two accessor methods.
	The setBudget method sets the budget if it is >=  0, otherwise it will 
	throw new IllegalArgumentException( "Budget must be >= 0.0")

	The toString method returns a String with the Destination and Budget and moves to the next line i.e.:
	Destination: Orlando; Budget: $1000.00
	The equals(Object obj) is overridden with a value of true if the destinations are the same (ignore the case) and the budgets are within 0.0001.
	It has an abstract method overbudget returning a double. */
public abstract class Vacation 
{
	private String destination;
	private double budget;
	
	public Vacation(String destination, double budget)
	{
		setDestination(destination);
		setBudget(budget);
	}
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	public void setBudget(double budget)
	{
		if (budget >= 0) 
			this.budget = budget;
		else 
			throw new IllegalArgumentException( "Budget must be >= 0.0");
	}
	
	public String getDestination()
	{
		return this.destination;
	}
	
	public double getBudget()
	{
		return this.budget;
	}
	
	@Override
	public String toString()
	{
		String toString = String.format("Destination: %s; Budget: $%,.2f\n" , destination, budget);
		return toString;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof Vacation))
			return false;
		
		Vacation temp = (Vacation) obj;
		
		if (temp.getDestination().equalsIgnoreCase(this.getDestination()) && Math.abs(temp.getBudget() - this.getBudget()) <= 0.0001) 
			return true;
		else 
			return false;
	}
	
	public abstract double overbudget();
}
