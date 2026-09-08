package asg12q3;
import java.util.List;
import java.util.ArrayList;

public class PlayfulPets 
{
	public static void main(String[] args) 
	{
		Pet.getPets().add(new Pet("Scruffy", "dog", "collie", "brown", 695.00));
		Pet.getPets().add(new Pet("Meow", "cat", "siamese", "white", 740.25));
		Pet.getPets().add(new Pet("Max", "dog", "collie", "black", 540.50));
		Pet.getPets().add(new Pet("Cuddles", "dog", "pug", "black", 1282.75));
		Pet.getPets().add(new Pet("HotDog", "dog", "dachsund", "brown", 921.75));
		Pet.getPets().add(new Pet("Slider", "snake", "garden", "green", 320.00));
		
		PetMatcher breedMatcher = p ->
		{
			List<Pet> temp = new ArrayList<>();
			
			for (Pet pet : Pet.getPets())
			{
				if (p.getBreed().equals(pet.getBreed()))
				{
					temp.add(pet);
				}
			}
			
			return temp;
		};
		
		PetMatcher priceMatcher = new PetMatcher()
		{
			@Override
			public List<Pet> matchPet(Pet p)
			{
				List<Pet> temp = new ArrayList<>();
			
				for (Pet pet: Pet.getPets())
				{
					if (p.getPrice() >= pet.getPrice())
					{
						temp.add(pet);
					}
				}
				
				return temp;
			}
			
			@Override
			public Pet firstPet(Pet p)
			{
				for (Pet pet: Pet.getPets())
				{
					if (p.getPrice() >= pet.getPrice())
					{
						return pet;
					}
				}
				
				return null;
			}
		};
		
		PetMatcher colorMatcher = new PetMatcher()
		{
			@Override
			public List<Pet> matchPet(Pet p)
			{
				List<Pet> temp = new ArrayList<>();
			
				for (Pet pet: Pet.getPets())
				{
					if (p.getColor().equals(pet.getColor()))
					{
						temp.add(pet);
					}
				}
				
				return temp;
			}
			
			@Override
			public Pet firstPet(Pet p)
			{
				for (Pet pet: Pet.getPets())
				{
					if (p.getColor().equals(pet.getColor()))
					{
						return pet;
					}
				}
				
				return null;
			}
		};
	
	matchPetsFromTheList("Collies", breedMatcher, new Pet(null, "dog", "collie", null, 0.0));
	matchPetsFromTheList("Pets for $750 or less", priceMatcher, new Pet(null, null, null, null, 750.0));
	matchPetsFromTheList("Pets that are brown", colorMatcher, new Pet(null, null, null, "brown", 0.0));
	
	}
	
	public static void matchPetsFromTheList(String criteria, PetMatcher matcher, Pet myPet)
	{
		Pet first = matcher.firstPet(myPet);
		System.out.printf("%s:%nFirst: %s%n", criteria, first);
		
		System.out.printf("%nAll matches:%n");
		List<Pet> allMatches = matcher.matchPet(myPet);
		
		for (Pet p : allMatches)
		{
			System.out.printf("%s%n", p);
		}
		
		System.out.printf("%n");
	}
}
