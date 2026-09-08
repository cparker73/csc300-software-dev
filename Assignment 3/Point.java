package quadrilaterialinheritance;

public class Point 
{
	private double x_coord;
	private double y_coord;
	
	public Point()
	{
		
	}
	
	public Point(double x_coord, double y_coord)
	{
		this.x_coord = x_coord;
		this.y_coord = y_coord;
	}
	
	public void setXCoord(double x_coord)
	{
		this.x_coord = x_coord;
	}
	
	public void setYCoord(double y_coord)
	{
		this.y_coord = y_coord;
	}
	
	public double getXCoord()
	{
		return this.x_coord;
	}
	
	public double getYCoord()
	{
		return this.y_coord;
	}
	
	public String toString()
	{
		String toString = String.format("(%.2f, %.2f) ", x_coord, y_coord);
		return toString;
	}
	
	
}
