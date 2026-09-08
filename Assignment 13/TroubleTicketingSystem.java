package q5;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.function.BooleanSupplier;

public class TroubleTicketingSystem 
{
	private static ArrayList<TroubleTicket> tickets = new ArrayList<>();
	private static LocalDate today = LocalDate.now();
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void populateDatabase()
	{
		HardwareTicket ht1 = new HardwareTicket("Kalpana Patel", 54641, "Cell phone won't power on",5, "Smartie", "SM250","SN546497-S23");
		SoftwareTicket st1 = new SoftwareTicket("Chester Rodriguez", 89034,"MapApp can't find grandma's house", 2,"MapApp", "1.01",
                             Domain.PHONE_HOSTED);
		SoftwareTicket st2 = new SoftwareTicket("Britney Delmonica", 91472,"Can't change banking info on website", 1,    
                             "awesomecheapcellphones.com", "2.65", Domain.WEB_HOSTED);
		HardwareTicket ht2 = new HardwareTicket("Kalpana Patel", 54641, "Cell phone's screen goes black", 7, "Rover", "RV100","SN456742-R31");
	
		tickets.add(ht1);
		tickets.add(st1);
		tickets.add(st2);
		tickets.add(ht2);
	}
	public static void main(String[] args) 
	{
		Supplier<? extends TroubleTicket> nextTicket = () ->
		{
			TroubleTicket next = null;
			
			for (int i = 0; i < tickets.size(); i++)
			{
				TroubleTicket troubTick = tickets.get(i);
				
				if (troubTick.getServicedDate().compareTo(today) < 0)
				{
					if (next == null || troubTick.compareTo(next) < 0)
					{
						next = troubTick;
					}
				}
			}
			
			if (next != null)
			{
				next.setServicedDate(today);
			}
		
			return next;
		};
	
		BooleanSupplier canClose = () ->
		{
			boolean result = false;
			
			System.out.printf("Can you close the ticket (Y or N)?%n");
			String answer = keyboard.next();
			
			if (answer.equalsIgnoreCase("Y"))
			{
				result = true;
			}
			
			return result;
		};
		
		BooleanSupplier isQuittingTime = () ->
		{
			boolean result = false;
			
			System.out.printf("Is it quitting time (Y or N)?%n");
			String answer = keyboard.next();
			
			if (answer.equalsIgnoreCase("Y"))
			{
				result = true;
			}
			
			return result;
		};
	
		populateDatabase();
		TroubleTicket next;
		boolean done = false;
		
		do
		{
			next = nextTicket.get();
			if (next != null)
			{
				System.out.printf("%n");
				System.out.printf("%s", next);
				System.out.printf("%n");
				
				if (canClose.getAsBoolean() == true)
				{
					tickets.remove(next);
				}
				
				if(isQuittingTime.getAsBoolean() == true)
				{
					done = true;
				}
			}
		} while (next != null && done == false);
		
		if (next == null)
		{
			System.out.printf("%n");
			System.out.printf("Congrats, you get a $50 bonus today!");
			System.out.printf("%n");
		}
		else
		{
			System.out.printf("%n");
			System.out.printf("See you tomorrow");
			System.out.printf("%n");
		}
			
		keyboard.close();
	}
}
