package asg5;

public class Dinosaur implements Comparable<Dinosaur>
{
	public static int dinoCounter = 1;
	String dinoName;
	int dinoWeight;
	
	public Dinosaur()
	{
		this.dinoName = "Barney";
	}
	
	public Dinosaur(int dinoWeight)
	{
		setDinoWeight(dinoWeight);
		this.dinoName = "DINO" + dinoCounter;
		dinoCounter++;
	}
	
	public void setDinoWeight(int dinoWeight)
	{
		this.dinoWeight = dinoWeight;
	}
	
	public int getDinoWeight()
	{
		return this.dinoWeight;
	}
	
	public String toString()
	{
		String toString = String.format("%-13s%,d", this.dinoName, this.dinoWeight);
		return toString;
	}
	
	public int compareTo(Dinosaur d2)
	{
		return this.dinoWeight - d2.dinoWeight;
	}

}
