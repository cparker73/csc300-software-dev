package asg9q3;

public class Printer 
{
	private Job printJob;
	private String printerName;
	private int startIdleTime;
	private int startInUseTime;
	private int totalIdleTime;
	private int totalInUseTime;
	private int totalJobsProcessed;
	
	public Printer()
	{
		
	}
	
	public Printer(String printerName)
	{
		setPrinterName(printerName);
	}
	
	public void setPrinterName(String printerName)
	{
		this.printerName = printerName;
	}
	
	public void setJob(Job printJob)
	{
		this.printJob = printJob;
	}
	
	public void setStartInUseTime(int startInUseTime)
	{
		this.startInUseTime = startInUseTime;
		totalJobsProcessed++;
	}
	
	public void setStartIdleTime(int startIdleTime)
	{
		totalInUseTime += startIdleTime - startInUseTime;
		this.startIdleTime = startIdleTime;
	}
	
	public String getPrinterName()
	{
		return printerName;
	}
	
	public Job getJob()
	{
		return printJob;
	}
	
	public int getTotalIdleTime(int currentTime)
	{
		return currentTime - totalInUseTime;
	}
	
	public int getTotalInUseTime()
	{
		return totalInUseTime;
	}
	
	public int getTotalJobsProcessed()
	{
		return totalJobsProcessed;
	}
}
