package asg6q4;

public class Book 
{
	private String bookName;
	
	public Book(String bookName) 
	{
		setName(bookName);
	}
	
	public String getName() 
	{
		return bookName;
	}
	
	public void setName(String bookName) 
	{
		this.bookName = bookName;
	}
	
	@Override
	public String toString() 
	{
		return this.bookName;
	}
}
