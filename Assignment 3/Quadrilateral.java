package quadrilaterialinheritance;

public class Quadrilateral 
{
	private Point point1, point2, point3, point4; //end-points
	
	public Quadrilateral(double x_coord1, double y_coord1, double x_coord2, double y_coord2,
						 double x_coord3, double y_coord3, double x_coord4, double y_coord4)
	{
		point1 = new Point(x_coord1, y_coord1);
		point2 = new Point(x_coord2, y_coord2);
		point3 = new Point(x_coord3, y_coord3);
		point4 = new Point(x_coord4, y_coord4);
	}
	
	public Point getPoint1()
	{
		return point1;
	}
	
	public Point getPoint2()
	{
		return point2;
	}
	
	public Point getPoint3()
	{
		return point3;
	}
	
	public Point getPoint4()
	{
		return point4;
	}
	
	public String returnCoordsAsString()
	{
		return this.point1.toString() + this.point2.toString() + this.point3.toString() + this.point4.toString();
	}
	
	public String toString()
	{
		String toString = String.format("Coordinates of a quadrilateral are %s", returnCoordsAsString());
		return toString;
	}
}
