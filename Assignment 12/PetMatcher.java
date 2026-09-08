package asg12q3;
import java.util.List;

@FunctionalInterface
public interface PetMatcher 
{
	List<Pet> matchPet(Pet p);
	
	default Pet firstPet(Pet p)
	{
		int i = Pet.getPets().indexOf(p);
		
		if (i < 0) return null;
		else return Pet.getPets().get(i);
	}
}
