//package finalProject;

public class PartTimeAdvising extends AdvisingType
{
	private static int partTimeCounter = 0;
	private String advisingNumber;
	
	public PartTimeAdvising()
	{
		super("PartTime ");
		setAdvisingNumber();
	}
	
	@Override
	public void setAdvisingNumber()
	{
		partTimeCounter++;
		this.advisingNumber = "PartTime " + partTimeCounter;
	}
	
	@Override
	public String getAdvisingNumber()
	{
		return advisingNumber;
	}
}
