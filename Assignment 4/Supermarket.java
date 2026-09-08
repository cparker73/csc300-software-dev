package asg4q2;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Iterator;

public class Supermarket 
{
	/*
	 * 	Determine and use the necessary import statements
		The following instance variables are used
		A String superName with a standard accessor and standard mutator
		An int bigCheckerOccupied set to 0
		An int fastCheckerOccupied set to 0
		The following ArrayLists, each of which can be instantiated when declared
			An ArrayList of type Shopper called currentShoppers 
			An ArrayList of type BigShopper called bigCheckOut 
			An ArrayList of type FastShopper called fastCheckOut 
			An ArrayList of type Shopper called doneShopping 

		Supermarket has a single constructor that accepts a String value
		It calls setSuperName with that value
	 */
	
	private String superName;
	private int bigCheckerOccupied = 0;
	private int fastCheckerOccupied = 0;
	private ArrayList<Shopper> currentShoppers = new ArrayList<Shopper>();
	private ArrayList<BigShopper> bigCheckOut = new ArrayList<BigShopper>();
	private ArrayList<FastShopper> fastCheckOut = new ArrayList<FastShopper>();
	private ArrayList<Shopper> doneShopping = new ArrayList<Shopper>();
	
	//Supermarket has a single constructor that accepts a String value
	//It calls setSuperName with that value
	public Supermarket(String superName)
	{
		setSuperName(superName);
	}
	
	public String getSuperName()
	{
		return this.superName;
	}
	
	public void setSuperName(String superName)
	{
		this.superName = superName;
	}
	
	/*
	 * 	Method openSupermarket with no parameters and a void return
		Create a loop with i going from 0 to less than 14
		if i is divisible by 3
		Create a new BigShopper instantiated with startTime equal to 0
		Add the BigShopper to the currentShoppers ArrayList
		else
		Create a new FastShopper instantiated with startTime equal to 0
		Add the FastShopper to the currentShoppers ArrayList
	 */
	
	public void openSupermarket()
	{
		for (int i = 0; i < 14; i++)
		{
			if (i % 3 == 0)
			{
				int startTime = 0;
				currentShoppers.add(new BigShopper(startTime));
			}
			else
			{
				int startTime = 0;
				currentShoppers.add(new FastShopper(startTime));
			}
		}
	}
	
	/*
	 * 	Method operateSupermarket with an int parameter with the minutes to run the simulation and
		a void return
		Set an int minCounter with the current minute equal to 1
		While (currentShoppers is not empty or bigCheckOut is not empty or fastCheckout is not empty
		//This section lets more shoppers in
		If the minCounter <=minutes and minCounter is divisible by 5
		Create a loop with i going from 0 to less than 9
		if i is divisible by 3
		Create a new BigShopper instantiated with startTime (the constructor
		parameter) equal to minCounter
		Add the BigShopper to the currentShoppers ArrayList
		else
	11
		Create a new FastShopper instantiated with startTime (the constructor
		parameter) equal to minCounter
		Add the FastShopper to the currentShoppers ArrayList
		end loop
		End the If
	 */
	
	public void operateSupermarket(int minutes)
	{
		int minCounter = 1;
		
		while(!currentShoppers.isEmpty() || !bigCheckOut.isEmpty() || !fastCheckOut.isEmpty())
		{
			if (minCounter <= minutes && minCounter % 5 == 0)
			{
				for (int i = 0; i < 9; i++)
				{
					if (i % 3 == 0)
					{
						int startTime = minCounter;
						currentShoppers.add(new BigShopper(startTime));
					}
					else
					{
						int startTime = minCounter;
						currentShoppers.add(new FastShopper(startTime));
					}
				}
			}
			
			/*
			 * /This section processes the Shoppers
		For i = 0 to i < number of Shoppers in currentShoppers (i.e. its size)
		Get the iTH Shopper on the currentShoppers ArrayList (create a tempShopper
		variable to reference this Shopper)
		Use the appropriate methods to retrieve shoppingTimeRemaining for
		tempShopper and decrement by 1
		if the shoppingTimeRemaining for the tempShopper now equals 0
		if the tempShopper is a BigShopper
		Create a casted BigShopper reference variable from the
		tempShopper variable (call it tempBig)
		Set the timeIntoCheckoutLine for tempBig to the minCounter
		Add the BigShopper referenced by tempBig to bigCheckOut
		else
		Create a casted FastShopper reference variable from the
		tempShopper variable (call it tempFast)
		Set the timeIntoCheckoutLine for tempFast to the minCounter
		Add the FastShopper referenced by tempFast to fastCheckOut
		End if else
		Remove the tempShopper from currentShoppers
		Decrement i by 1. Note:This is necessary since you’ve removed an item
		from CurrentShoppers
		End the outer if
		End Of the For Loop
			 */
			
			for (int i = 0; i < currentShoppers.size(); i++)
			{
				Shopper tempShopper = currentShoppers.get(i);
				tempShopper.setShoppingTimeRemaining(tempShopper.getShoppingTimeRemaining() - 1);
				if (tempShopper.getShoppingTimeRemaining() == 0)
				{
					if(tempShopper instanceof BigShopper)
					{
						BigShopper tempBig = (BigShopper) tempShopper;
						tempBig.setTimeIntoCheckoutLine(minCounter);
						bigCheckOut.add(tempBig);
					}
					else
					{
						FastShopper tempFast = (FastShopper) tempShopper;
						tempFast.setTimeIntoCheckoutLine(minCounter);
						fastCheckOut.add(tempFast);
					}
					
					currentShoppers.remove(i);
					i--;
				}
			}
			
			/*
			 * if bigCheckOut is not empty and bigCheckerOccupied == 0
		Remove the shopper from the 0TH position of bigCheckOut and create a
		temporary reference variable tempBig for it
		Set the timeOutOfCheckoutLine tempBig to the minCounter
		Add the tempBig BigShopper to the doneShopping ArrayList
		Set bigCheckerOccupied to BigShopper.TIMEWITHCHECKER
		else if bigCheckerOccupied doesn’t equal 0
		Decrement bigCheckerOccupied by 1
		if fastCheckOut is not empty and fastCheckerOccupied == 0
		Remove the shopper from the 0TH position of fastCheckOut and create a
		temporary reference variable tempFast for it
		Set the timeOutOfCheckoutLine for tempFast to the minCounter
		Add the tempFast FastShopper to the doneShopping ArrayList
		12
		Set fastCheckerOccupied to FastShopper.TIMEWITHCHECKER
		else if fastCheckerOccupied doesn’t equal 0
		Decrement fastCheckerOccupied by 1
			 */
			
			if (!bigCheckOut.isEmpty() && bigCheckerOccupied == 0)
			{
				BigShopper tempBig = bigCheckOut.remove(0);
				tempBig.setTimeOutOfCheckoutLine(minCounter);
				doneShopping.add(tempBig);
				bigCheckerOccupied = BigShopper.TIMEWITHCHECKER;
			}
			else if (bigCheckerOccupied != 0)
			{
				bigCheckerOccupied--;
			}
			
			if (!fastCheckOut.isEmpty() && fastCheckerOccupied == 0)
			{
				FastShopper tempFast = fastCheckOut.remove(0);
				tempFast.setTimeOutOfCheckoutLine(minCounter);
				doneShopping.add(tempFast);
				fastCheckerOccupied = FastShopper.TIMEWITHCHECKER;
			}
			else if (fastCheckerOccupied != 0)
			{
				fastCheckerOccupied--;
			}
			
		/*
		 * 	Increment the minCounter
			End Of The while loop
			End of the operateSupermarket method
		 */
			
			minCounter++;
		}
	}
	
	/*
	 * Method generateSupermarketResults accepts a String with the name of the Physical file
		(remember what it throws) Note: You mist produce output in columns nicely formatted for full
		credit
		Create a PrintWriter object based on the input parameter
		Create the output headers as per the sample output
		Create the necessary counter variables set to 0
		Create an Iterator for the doneShopping ArrayList
		Use the Iterator to go through the items,
		Print each item using toString
		Collecting the data necessary to separately be able to figure out the average time a
		BigShopper or a FastShopper waits on line and checks out based on the times returned
		with the getTotalTimeCheckingOut() method
		Print out the two averages as shown in the output file
		Close the PrintWriter object
	 */
	
	public void generateSupermarketResults(String outFileName) throws IOException
	{
		PrintWriter outFile = new PrintWriter(outFileName);
		outFile.println("Data For Supermarket Beheshti's MarketPlace");
		outFile.printf("%15s%15s%12s%18s%18s%15s\n", "Shopper ID", "Start Time", "End Time", "Time Shopping", "Checkout Time", "Time In Store");
	
		Iterator<Shopper> it = doneShopping.iterator();
		
		int totalBig = 0;
		int numItemsBig = 0;
		int totalFast = 0;
		int numItemsFast = 0;
		
		while (it.hasNext())
		{
			Shopper tempShopper = it.next();
			outFile.println(tempShopper.toString());
			
			if (tempShopper instanceof BigShopper)
			{
				totalBig += tempShopper.getTotalTimeCheckingOut();
				numItemsBig++;
			}
			else
			{
				totalFast += tempShopper.getTotalTimeCheckingOut();
				numItemsFast++;
			}
		}
		
		double avgBig = 0.0;
		double avgFast = 0.0;
		
		avgBig = (double)totalBig / numItemsBig;
		avgFast = (double)totalFast / numItemsFast;
		
		outFile.printf("The average time checking out on the Big Queue for %d Shoppers is %.2f minutes\n", numItemsBig, avgBig);
		outFile.printf("The average time checking out on the Fast Queue for %d Shoppers is %.2f minutes\n", numItemsFast, avgFast);
		
		outFile.close();
	}
}
