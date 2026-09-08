package quadrilaterialinheritance;

public class Trapezoid extends Quadrilateral
{
	private double height;
	
	public Trapezoid(double x_coord1, double y_coord1,
					 double x_coord2, double y_coord2,
					 double x_coord3, double y_coord3,
					 double x_coord4, double y_coord4)
	{

		super(x_coord1, y_coord1, 
			  x_coord2, y_coord2, 
			  x_coord3, y_coord3, 
			  x_coord4, y_coord4);
	}
	
	public double getHeight()
	{
		Point point1 = getPoint1();
		Point point2 = getPoint2();
		Point point3 = getPoint3();
		Point point4 = getPoint4();
		
		if (point1.getYCoord() == point2.getYCoord()) 
		{
			this.height = Math.abs(point1.getYCoord() - point3.getYCoord());
		}
		else
		{
			this.height = Math.abs(point1.getXCoord() - point4.getXCoord());
		}
		
		return this.height;
	}
	
	public double getSumOfTwoSides() 
	{
		Point point1 = getPoint1();
		Point point2 = getPoint2();
		Point point3 = getPoint3();
		Point point4 = getPoint4();
		
		if (point1.getYCoord() == point2.getYCoord()) 
		{
			return Math.abs(point1.getXCoord() - point2.getXCoord()) +
				   Math.abs(point3.getXCoord() - point4.getXCoord());
		}
		else 
		{
			return Math.abs(point2.getXCoord() - point3.getXCoord()) +
				   Math.abs(point4.getXCoord() - point1.getXCoord());
		}
	}
	
	public double getArea()
	{
		return (getSumOfTwoSides() / 2.0) * getHeight(); // 1/2 * (shortbase + longbase) * height
	}
	
	public String toString()
	{
		String toString = String.format("\nCoordinates of trapezoid are %s\nHeight is: %.2f: Area is %.2f\n", returnCoordsAsString(), getHeight(), getArea());
		return toString;
	}
	
}
