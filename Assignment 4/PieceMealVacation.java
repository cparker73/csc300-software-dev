package asg4;
/*
  	It has instance variables:
	private String [] items – the list of items on the vacation
	private double [] costs – the corresponding price of each item

	It has a constructor with the 4 instance variables: The first two are for the superclass.
	The constructor calls super, and then calls the mutators for each of the remaining variables (remember that they are references to the two arrays).  
	There are also two accessor methods.
	The setItems method accepts an array of items and uses it to create an object array items with the same length, and then sets the items one by one.
	The setCosts method accepts an array of costs (I call it newCosts) create an object array costs with a length equal to the length of the array items. 
	It then sets the costs one by one. 

		if newCosts is a bigger array, extra cost elements are ignored
    		if newCosts is a smaller array, missing cost elements are 0.0

	The toString method returns a String with the Destination and Budget (using super()) and the line by line itemization i.e.:
	Destination: Miami; Budget: $1500.00
	hotel: $750.00
	meals: $250.00
	airfare: $400.00
	windsurfing: $0.00
	The equals(Object obj) is overridden with a value of true if the conditions from the super class are true 
	and Each item is equal and the cost for each item is within 0.0001.

	It overrides the overbudget method by calculating and returning by how much the vacation is over or 
	under budget as a double after summing the costs of all the items.
*/

public class PieceMealVacation extends Vacation
{
	private String[] items;
	private double[] costs;
	
	public PieceMealVacation(String destination, double budget, String[] items, double[] costs)
	{
		super(destination, budget);
		setItems(items);
		setCosts(costs);
	}
	
	public void setItems(String[] newItems)
	{
		String[] items = new String[newItems.length];
		
		for (int i = 0; i < newItems.length; i++)
		{
			items[i] = newItems[i];
		}
		
		this.items = items;
	}
	
	public void setCosts(double[] newCosts)
	{
		double[] costs = new double[getItems().length];
		
		for (int i = 0; i < costs.length; i++)
		{
			if (i < newCosts.length)
				costs[i] = newCosts[i];
			else 
				costs[i] = 0.0;
		}
		
		this.costs = costs;
	}
	
	public String[] getItems()
	{
		return this.items;
	}
	
	public double[] getCosts()
	{
		return this.costs;
	}
	
	@Override
	public String toString()
	{
		StringBuilder temp = new StringBuilder(super.toString());
		
		for (int i = 0; i < this.getItems().length; i++)
		{
			temp = temp.append(String.format("%s: $%,.2f\n", this.getItems()[i],this.getCosts()[i]));
		}
		
		return temp.toString();				
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof PieceMealVacation))
			return false;
		
		PieceMealVacation temp = (PieceMealVacation) obj;
		
		if (!(super.equals(obj)) || temp.getItems().length != this.getItems().length) 
			return false;
		
		for (int i = 0; i < this.getItems().length; i++)
		{
			if (!(temp.items[i].equals(this.items[i])))
				return false;
			if (Math.abs(temp.costs[i] - this.costs[i]) > 0.0001)
				return false;
		}
		
		return true;
	}
	
	@Override
	public double overbudget()
	{
		double price = 0;
		for(double cost : costs)
		{
			price += cost;
		}
		
		return price - this.getBudget();
	}
}
