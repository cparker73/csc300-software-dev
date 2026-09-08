package asg12q3;
import java.util.List;
import java.util.ArrayList;

public class Pet 
{
	private static List<Pet> pets = new ArrayList<>();
	
	private String name;
	private String animal;
	private String breed;
	private String color;
	private double price;
	
	//constructors
	public Pet()
	{
		
	}
	
	public Pet(String name, String animal, String breed, String color, double price)
	{
		setName(name);
		setAnimal(animal);
		setBreed(breed);
		setColor(color);
		setPrice(price);
	}
	
	//getters
	public static List<Pet> getPets()
    {
    	 return pets;
    }
	
	public String getName() 
	{
        return name;
    }

    public String getAnimal() 
    {
        return animal;
    }

    public String getBreed() 
    {
        return breed;
    }

    public String getColor() 
    {
        return color;
    }

    public double getPrice() 
    {
        return price;
    }
    
    //setters
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setAnimal(String animal) 
    {
        this.animal = animal;
    }

    public void setBreed(String breed) 
    {
        this.breed = breed;
    }

    public void setColor(String color) 
    {
        this.color = color;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }
    
	public String toString()
	{
		return String.format("%s: a %s %s %s purchased for $%.2f", name, color, breed, animal, price);
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof Pet)) return false;
		Pet temp = (Pet) o;
		
		if (this.animal == null || temp.animal == null || this.breed == null | temp.breed == null) return false;
		
		return (this.animal.equals(temp.animal) && this.breed.equals(temp.breed));
	}
}
