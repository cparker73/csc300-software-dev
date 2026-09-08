package asg4;

/* Write an abstract Vacation superclass encapsulating a vacation. There will be two concrete subclasses , AllInclusiveVacation and PieceMealVacation. 
   There is also a VacationTest class.*/

/*
 * This class consists of a main program which tests the Vacation.
	See below for a complete sample output.
	Create an AllInclusiveVacation with parameters ( "Orlando", 2000.00 , "Universal", 4, 1979.49 )
	Print out the AllInclusiveVacation.
	Determine if it is on budget (within 0.0001), under budget or over budget and make the
	appropriate printout.
	Create a second AllInclusiveVacation with parameters ( "Virgin Islands", 2100.00, "Sandals", 4,
	2350.99)
	Print out the AllInclusiveVacation.
	Determine if it is on budget (within 0.0001), under budget or over budget and make the
	appropriate printout.
	Set both the brand and price of the second AllInclusiveVacation to that of the first.
	Print out whether they are equal.
	Set both the destination and budget of the second AllInclusiveVacation to that of the first.
	Print out whether they are equal.
	Create an itemsList1 array with { "lodging", "meals", "airfare", " water skiing " }
	Create a costsList1 array with { 750.00, 250.00, 400.00 }
	Create a PieceMealVacation pmv1 with Honolulu and 1500.00 as the first two parameters and
	references to the itemsList1 and costsList1 as the last two parameters
	Print out the PieceMealVacation
	Determine if it is on budget (within 0.0001), under budget or over budget and make the
	appropriate printout.
	Create an itemsList2 with { "lodging", "meals", "airfare", " water skiing " }
	Create a costsList2 with { 750.00, 250.00, 400.00, 120.00, 200.00 }
	Create a PieceMealVacation pmv2 with Honolulu and 1500.00 as the first two parameters and
	references to the itemsList2 and costsList2 as the last two parameters
	Print out the PieceMealVacation
	Determine if it is on budget (within 0.0001), under budget or over budget and make the
	appropriate printout.
	6
	Determine if pmv1 is equal to pmv2 and print out whether or not they are equal.
	Then:
	Set the pmv2 items to itemsList1
	Set the pmv2 costs to costsList1
	Print out whether they or not they are now equal.
 */
public class VacationTest {

	public static void main(String[] args) 
	{
		AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 2000.0, "Universal", 4, 1979.49);
		System.out.printf("The first all-inclusive vacation is:\n");
		System.out.printf(aiv1.toString());
		
		if (Math.abs(aiv1.overbudget()) <= 0.0001)
			System.out.printf("It is within budget by $%.2f\n", Math.abs(aiv1.overbudget()));
		else if (aiv1.overbudget() < 0) 
			System.out.printf("It is under budget by $%.2f\n", Math.abs(aiv1.overbudget()));
		else if (aiv1.overbudget() > 0.0001) 
			System.out.printf("It is over budget by $%.2f\n", Math.abs(aiv1.overbudget()));
		
		System.out.printf("\n");
		
		AllInclusiveVacation aiv2 = new AllInclusiveVacation("Virgin Islands", 2100.00, "Sandals", 4, 2350.99);
		System.out.printf("The second all-inclusive vacation is:\n");
		System.out.printf(aiv2.toString());
		
		if (Math.abs(aiv2.overbudget()) <= 0.0001)
			System.out.printf("It is within budget by $%.2f\n", Math.abs(aiv2.overbudget()));
		else if (aiv2.overbudget() < 0) 
			System.out.printf("It is under budget by $%.2f\n", Math.abs(aiv2.overbudget()));
		else if (aiv2.overbudget() > 0.0001) 
			System.out.printf("It is over budget by $%.2f\n", Math.abs(aiv2.overbudget()));
		
		System.out.printf("\n");
		
		aiv2.setBrand(aiv1.getBrand());
		aiv2.setPrice(aiv1.getPrice());
		
		if (aiv1.equals(aiv2))
			System.out.printf("aiv1 and aiv2 are now equal\n");
		else 
			System.out.printf("aiv1 and aiv2 are not equal\n");
		
		aiv2.setDestination(aiv1.getDestination());
		aiv2.setBudget(aiv1.getBudget());
		
		if (aiv1.equals(aiv2))
			System.out.printf("aiv1 and aiv2 are now equal\n");
		else 
			System.out.printf("aiv1 and aiv2 are not equal\n");
		
		System.out.printf("\n");
		
		String[] itemsList1 = {"lodging", "meals", "airfare", "water skiing"};
		double[] costsList1 = {750.00, 250.00, 400.00};
		
		PieceMealVacation pmv1 = new PieceMealVacation("Honolulu", 1500.00, itemsList1, costsList1);
		System.out.printf("The first piecemeal vacation is:\n");
		System.out.printf(pmv1.toString());
		
		if (Math.abs(pmv1.overbudget()) <= 0.0001)
			System.out.printf("It is within budget by $%.2f\n", Math.abs(pmv1.overbudget()));
		else if (pmv1.overbudget() < 0) 
			System.out.printf("It is under budget by $%.2f\n", Math.abs(pmv1.overbudget()));
		else if (pmv1.overbudget() > 0.0001) 
			System.out.printf("It is over budget by $%.2f\n", Math.abs(pmv1.overbudget()));
		
		System.out.printf("\n");
		
		String[] itemsList2 = {"lodging", "meals", "airfare", "water skiing"};
		double[] costsList2 = {750.00, 250.00, 400.00, 120.00, 200.00};
		
		PieceMealVacation pmv2 = new PieceMealVacation("Honolulu", 1500.00, itemsList2, costsList2);
		System.out.printf("The second piecemeal vacation is:\n");
		System.out.printf(pmv2.toString());
		
		if (Math.abs(pmv2.overbudget()) <= 0.0001)
			System.out.printf("It is within budget by $%.2f\n", Math.abs(pmv2.overbudget()));
		else if (pmv2.overbudget() < 0) 
			System.out.printf("It is under budget by $%.2f\n", Math.abs(pmv2.overbudget()));
		else if (pmv2.overbudget() > 0.0001) 
			System.out.printf("It is over budget by $%.2f\n", Math.abs(pmv2.overbudget()));
		
		System.out.printf("\n");
		
		if (pmv1.equals(pmv2))
			System.out.printf("pmv1 and pmv2 are now equal\n");
		else 
			System.out.printf("pmv1 and pmv2 are not equal\n");
		
		pmv2.setItems(itemsList1);
		pmv2.setCosts(costsList1);
		
		if (pmv1.equals(pmv2))
			System.out.printf("pmv1 and pmv2 are now equal\n");
		else 
			System.out.printf("pmv1 and pmv2 are not equal\n");
	}
}
