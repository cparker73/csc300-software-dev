//package finalProject;

public class Advisor 
{
	private static int advisorCounter = 0;
	private boolean isFree;
	private int advisorIDNumber;
	private int totalStudentsSeenByAdvisor;
	private int timeRemainingForMeeting;
	private Student assignedStudent;
	
	public Advisor()
	{
		setAdvisorIDNumber();
		setIsFree(true);
	}
	
	//getters
	public boolean getIsFree() 
	{
	    return isFree;
	}

	public int getAdvisorIDNumber() 
	{
	    return advisorIDNumber;
	}

	public int getTotalStudentsSeenByAdvisor() 
	{
	    return totalStudentsSeenByAdvisor;
	}

	public int getTimeRemainingForMeeting() 
	{
	    return timeRemainingForMeeting;
	}

	public Student getAssignedStudent() 
	{
	    return assignedStudent;
	}
	
	//setters
	public void setAdvisorIDNumber()
	{
		advisorCounter++;
		advisorIDNumber = advisorCounter;
	}
	
	public void setIsFree(boolean isFree)
	{
		this.isFree = isFree;
	}
	
	public void setAssignedStudent(Student assignedStudent)
	{
		this.assignedStudent = assignedStudent;
		setIsFree(false);
	}
	
	public Student removeAssignedStudent()
	{
		Student tempStudent = assignedStudent;
		
		assignedStudent = null;
		setIsFree(true);
		totalStudentsSeenByAdvisor++;
		
		return tempStudent;
	}
	
	public void setTimeRemainingForMeeting(int timeRemainingForMeeting)
	{
		this.timeRemainingForMeeting = timeRemainingForMeeting;
	}
	
	public void decrementTimeRemainingForMeeting()
	{
		timeRemainingForMeeting--;
	}
	
	@Override
	public String toString()
	{
		return String.format("Advisor %d advises %d students%n", advisorIDNumber, totalStudentsSeenByAdvisor);
	}
}
