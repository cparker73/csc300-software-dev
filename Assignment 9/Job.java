package asg9q3;

public class Job implements Comparable<Job>
{
	private int id;
	private int arrivalTime;
	private int timeForJob;
	private int priority;
	private int startTime;
	private int waitTime;
	private int endTime;
	
	private static int idCounter = 1;
	
	public Job()
	{
		
	}
	
	public Job(int arrivalTime, int timeForTheJob, int priority)
	{
		setID();
		setArrivalTime(arrivalTime);
		setTimeForJob(timeForTheJob);
		setPriority(priority);
	}
	
	public void setID()
	{
		id = idCounter;
		idCounter++;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
	
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	public void setTimeForJob(int timeForJob)
	{
		this.timeForJob = timeForJob;
	}
	
	public int getTimeForJob()
	{
		return timeForJob;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
		waitTime = startTime - arrivalTime;
	}
	
	public int getStartTime()
	{
		return startTime;
	}
	
	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}
	
	public int getEndTime()
	{
		return endTime;
	}
	
	public int getWaitTime()
	{
		return waitTime;
	}
	
	@Override
	public int compareTo(Job j)
	{
		if (priority < j.getPriority()) return -1;
		else if (priority > j.getPriority()) return 1;
		else return 0;
	}
}
