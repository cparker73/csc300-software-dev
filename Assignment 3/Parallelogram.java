package quadrilaterialinheritance;

public class Parallelogram extends Trapezoid
{
	public Parallelogram(double x_coord1, double y_coord1,
			 double x_coord2, double y_coord2,
			 double x_coord3, double y_coord3,
			 double x_coord4, double y_coord4)
	{
		super(x_coord1, y_coord1, 
				x_coord2, y_coord2, 
				x_coord3, y_coord3, 
				x_coord4, y_coord4);
	}
	
	public double getWidth() 
	{
		Point point1 = getPoint1();
		Point point2 = getPoint2();
		Point point3 = getPoint3();
		
		if (point1.getYCoord() == point2.getYCoord()) 
		{
			return Math.abs(point1.getXCoord() - point2.getXCoord());
		}
		else 
		{
			return Math.abs(point2.getXCoord() - point3.getXCoord());
		}
	}
	
	public String toString()
	{
		String toString = String.format("\nCoordinates of a parallelogram are %s\nWidth is %.2f Height is %.2f Area is: %.2f\n", returnCoordsAsString(), getWidth(),  getHeight(), getArea());
		return toString;
	}
}
