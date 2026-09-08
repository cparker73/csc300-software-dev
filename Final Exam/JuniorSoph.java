//package finalProject;

public class JuniorSoph extends Student 
{
	private String studentID;
	
	public JuniorSoph(int arrivalTime, AdvisingType advT)
	{
		super(arrivalTime);
		setStudentType("JuniorSoph ");
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
	
	@Override
	public int compareTo(Student s)
	{
		return -(this.getStudentType().compareTo(s.getStudentType()));
	}
}
