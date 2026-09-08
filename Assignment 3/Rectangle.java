package quadrilaterialinheritance;

public class Rectangle extends Parallelogram
{
	public Rectangle(double x_coord1, double y_coord1,
			 double x_coord2, double y_coord2,
			 double x_coord3, double y_coord3,
			 double x_coord4, double y_coord4)
	{
		super(x_coord1, y_coord1, 
				x_coord2, y_coord2, 
				x_coord3, y_coord3, 
				x_coord4, y_coord4);
	}
	
	public String toString()
	{
		String toString = String.format("\nCoordinates of Rectangle are %s\nWidth is %.2f Height is %.2f Area is: %.2f\n", returnCoordsAsString(), getWidth(), getHeight(), getArea());
		return toString;
	}
}
