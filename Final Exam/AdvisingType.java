//package finalProject;

public abstract class AdvisingType 
{
	private String advisingType;
	
	public AdvisingType(String advisingType)
	{
		setAdvisingType(advisingType);
	}
	
	public void setAdvisingType(String advisingType)
	{
		this.advisingType = advisingType;
	}
	
	public String getAdvisingType()
	{
		return advisingType;
	}
	
	public abstract void setAdvisingNumber();
	public abstract String getAdvisingNumber();
}

