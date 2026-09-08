//package finalProject;

public class FullTimeAdvising extends AdvisingType
{
	private static int fullTimeCounter = 0;
	private String advisingNumber;
	
	public FullTimeAdvising()
	{
		super("FullTime ");
		setAdvisingNumber();
	}
	
	@Override
	public void setAdvisingNumber()
	{
		fullTimeCounter++;
		this.advisingNumber = "FullTime " + fullTimeCounter;
	}
	
	@Override
	public String getAdvisingNumber()
	{
		return advisingNumber;
	}
}
