package asg4;
/*
  	It has instance variables:
	private String brand;
	private int rating – from 1 to 5
	private double price
	It has a constructor with the 5 instance variables: The first two are for the superclass.
	The constructor calls super, and then calls the mutators for each of the remaining variables.  There are also three accessor methods.
	The setRating method sets the rating if it is >=  1 and <=5, otherwise it will 
	throw new IllegalArgumentException( "Rating must be > 0 and <= 5")
	The setPrice method sets the price if it is >=  0.0, otherwise it will 
	throw new IllegalArgumentException( "Price must be >= 0.0")
	The toString method returns a String with the Destination and Budget (using super()) and the three other instance values and moves to the next line i.e.:
	Destination: Orlando; Budget: $1000.00
	Brand: Disney; Rating: 4; Price: $989.49

	The equals(Object obj) is overridden with a value of true if the conditions from the super class are true and brand (ignore the case) and rating are equal, and the prices are within 0.0001.

	It overrides overbudget returning by how much the vacation is over or under budget as a double. 
 */
public class AllInclusiveVacation extends Vacation
{
	private String brand;
	private int rating;
	private double price;
	
	public AllInclusiveVacation(String destination, double budget, String brand, int rating, double price)
	{
		super(destination, budget);
		setBrand(brand);
		setRating(rating);
		setPrice(price);
	}
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setRating(int rating)
	{
		if (rating >= 1 && rating <= 5)
			this.rating = rating;
		else 
			throw new IllegalArgumentException("Rating must be > 0 and <= 5");
	}
	
	public void setPrice(double price)
	{
		if (price >= 0.0)
			this.price = price;
		else
			throw new IllegalArgumentException("Price must be >= 0.0");
	}

	public String getBrand()
	{
		return this.brand;
	}
	
	public int getRating()
	{
		return this.rating;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	@Override
	public String toString()
	{
		String toString = String.format("%sBrand: %s; Rating: %d; Price: $%,.2f\n", super.toString(), this.getBrand(), this.getRating(), this.getPrice());
		return toString;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof AllInclusiveVacation)) return false;
		
		AllInclusiveVacation temp = (AllInclusiveVacation) obj;
		
		if (super.equals(temp) && temp.getBrand().equalsIgnoreCase(this.brand) && temp.getRating() == this.rating && (Math.abs(temp.price - this.price) <= 0.0001))
			return true;
		else 
			return false;
	}
	
	@Override
	public double overbudget()
	{	
		return this.getPrice() - this.getBudget();
	}
}
