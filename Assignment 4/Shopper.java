package asg4q2;
/* 	This is an abstract class.
	It has one instance variable shopperType of type String.
	It has a default constructor that calls the setShopperType method with an empty String
	It has a second constructor with a String parameter referring to the shopperType, that calls the setShopperType method with the parameter’s value
	It has both mutator and accessor methods for shopperType.

	It has two public abstract methods:
	setTimeIntoCheckoutLine accepts an int value and a void return
	getTotalTimeCheckingOut has no parameters and returns an int
*/
public abstract class Shopper implements ShoppingTimeRemaining
{
	private String shopperType;
	
	public Shopper()
	{
		setShopperType("");
	}
	
	public Shopper(String shopperType)
	{
		setShopperType(shopperType);
	}
	
	public void setShopperType(String shopperType)
	{
		this.shopperType = shopperType;
	}
	
	public String getShopperType()
	{
		return this.shopperType;
	}
	
	public abstract void setTimeIntoCheckoutLine(int n);
	public abstract int getTotalTimeCheckingOut();
}
