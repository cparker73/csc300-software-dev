package solarsystem;
import java.util.Random;

public class Sun
{
	private String sunName;
	private int sunAge;
	private Random randy = new Random(6);
	
	public Sun()
	{
		setSunName("unknown");
	}
	
	public Sun(String sunName)
	{
		int minYears = 1000000000; //1 billion years
		int maxYears = 2000000000;  //2 billion years
		
		setSunName(sunName);
		setSunAge(randy.nextInt(minYears, maxYears + 1)); //1 billion to 2 billion
	}
	
	public String getSunName()
	{
		return this.sunName;
	}
	
	public int getSunAge()
	{
		return this.sunAge;
	}
	
	public void setSunName(String sunName)
	{
		this.sunName = sunName;
	}
	
	public void setSunAge(int age)
	{
		this.sunAge = age;
	}
	
	public String toString()
	{
		String toString = String.format("The sun named %s is %,d years old\n", getSunName(), getSunAge());
		return toString;
	}
}
