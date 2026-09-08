//package finalProject;

public class Freshman extends Student 
{
	private String studentID;
	
	public Freshman(int arrivalTime, AdvisingType advT)
	{
		super(arrivalTime);
		setStudentType("Freshman ");
		setAdvisingType(advT);
		setStudentID();
	}
	
	@Override
	public String getStudentID()
	{
		return studentID;
	}
	
	@Override
	public void setStudentID()
	{
		idCounter++;
		studentID = String.format("CSUDH %s%d", getStudentType(), idCounter);
	}
	
	public int compareTo(Student s)
	{
		return -(this.getStudentType().compareTo(s.getStudentType()));
	}
}
