package asg8q3;

public class Hole 
{
	private int par;
	private int score;
	
	public Hole(int par, int score)
	{
		setPar(par);
		setScore(score);
	}
	
	public void setPar(int par)
	{
		this.par = par;
	}
	
	public int getPar()
	{
		return par;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getScore()
	{
		return score;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true; //same memory address
		if (obj == null || !(obj instanceof Hole)) return false; //checks if empty or not a hole
		
		Hole h2 = (Hole) obj;
		return this.score == h2.getScore(); //score only
	}
}
