package asg4q2;
import java.util.Random;
/*
 * note: all the abstract methods in
	Shopper and in the interface ShoppingTimeRemaing are implemented here
	Note: You don’t say implement in the class header since you this is done in Shopper
	Note: Items in red are different From FastShopper
	It has a public static int variable bigShopperCounter set to 0
	It has a public static constantint variable TIMEWITHCHECKER = 2
	It has a private String instance variable bigShopperID - – note: has a simple accessor method
	It has the following additional private instance int variables, each of which has a simple accessor
	method that returns its current value. Those with an * also have a simple mutator method
	 startTime*
	 timeShopping
	 shoppingTimeRemaining*
	 timeIntoCheckoutLine*
	 timeOutOfCheckoutLine
	 endTime – calculated in calculateFinalDurations method
	 totalTimeCheckingOut - calculated in calculateFinalDurations method
	 totalTimeInStore - calculated in calculateFinalDurations method
	It also has a Random reference variable randy (don’t forget the proper import statement)
 */
public class BigShopper extends Shopper
{
	public static int bigShopperCounter = 0;
	public static final int TIMEWITHCHECKER = 2;
	
	private String bigShopperID;
	private int startTime;
	private int timeShopping;
	private int shoppingTimeRemaining;
	private int timeIntoCheckoutLine;
	private int timeOutOfCheckoutLine;
	private int endTime;
	private int totalTimeCheckingOut;
	private int totalTimeInStore;
	private Random randy;
	
	public BigShopper(int startTime)
	{
		super("BigShopper");
		randy = new Random(bigShopperCounter);
		setBigShopperID();
		setStartTime(startTime);
		setTimeShopping();
		setShoppingTimeRemaining(timeShopping);
	}
	
	public String getBigShopperID()
	{
		return this.bigShopperID;
	}
	
	public int getStartTime()
	{
		return this.startTime;
	}
	
	public int getTimeShopping()
	{
		return this.timeShopping;
	}
	
	@Override
	public int getShoppingTimeRemaining()
	{
		return this.shoppingTimeRemaining;
	}
	
	public int getTimeIntoCheckoutLine()
	{
		return this.timeIntoCheckoutLine;
	}
	
	public int getTimeOutOfCheckoutLine()
	{
		return this.timeOutOfCheckoutLine;
	}
	
	public int getEndTime()
	{
		return this.endTime;
	}
	
	@Override
	public int getTotalTimeCheckingOut()
	{
		return this.totalTimeCheckingOut;
	}
	
	public int getTotalTimeInStore()
	{
		return this.totalTimeInStore;
	}
	
	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}
	
	@Override
	public void setShoppingTimeRemaining(int shoppingTimeRemaining)
	{
		this.shoppingTimeRemaining = shoppingTimeRemaining;
	}
	
	@Override
	public void setTimeIntoCheckoutLine(int timeIntoCheckoutLine)
	{
		this.timeIntoCheckoutLine = timeIntoCheckoutLine;
	}
	
	/* 
		The following methods has special code used in the mutator method.
		setBigShopperID has no parameters and a void return. It
		increments bigShopperCounter by 1
		sets bigShopperID equal to the concatenation of the return from getShopperType() and bigShopperCounter

		setTimeShopping has no parameters and a void return
		It sets the timeShopping variable to a value between 5 and 15 inclusively using the randy Random object

		setTimeOutOfCheckoutLine has an int input parameter and a void return 
		It sets timeOutOfCheckoutLine to the input parameter value
		It calls calculateFinalDurations with no parameters

		There are two additional methods.
		calculateFinalDurations has no parameters and a void return and sets the following values:
		endTime equals the sum of timeOutOfCheckoutLine and TIMEWITHCHECKER
		totalTimeCheckingOut is the positive difference of the endTime and timeIntoCheckoutLine
		totalTimeInStore is the positive difference between the endTime and the startTime;

		There is also a toString method that returns a formatted String for printing as shown in the output. It includes the following values:
		bigShopperID, startTime, endTime, timeShopping, totalTimeCheckingOut, totalTimeInStore
	 */
	
	public void setBigShopperID()
	{
		bigShopperCounter++;
		bigShopperID = getShopperType() + bigShopperCounter;
	}
	
	public void setTimeShopping()
	{
		timeShopping = randy.nextInt(5, 16);
	}
	
	public void setTimeOutOfCheckoutLine(int timeOutOfCheckoutLine)
	{
		this.timeOutOfCheckoutLine = timeOutOfCheckoutLine;
		calculateFinalDurations();
	}
	
	public void calculateFinalDurations()
	{
		endTime = timeOutOfCheckoutLine + TIMEWITHCHECKER;
		totalTimeCheckingOut = Math.abs(endTime - timeIntoCheckoutLine);
		totalTimeInStore = Math.abs(endTime - startTime);
	}
	
	@Override
	public String toString()
	{
		String toString = String.format("%15s%12d%10d%16d%16d%16d", bigShopperID, startTime, endTime, timeShopping, totalTimeCheckingOut, totalTimeInStore);
		return toString;
	}
}
