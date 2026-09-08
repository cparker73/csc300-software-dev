package asg6q4;
import java.util.ArrayList;

public class WildcardBookTester 
{
	public static void main(String[] args) 
	{
		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<MysteryBook> mysteryBookList = new ArrayList<>();
		
		addFictionBook(bookList, "Lord Jim");
		
		addFictionBook(mysteryBookList, "Dr. No");
		addFictionBook(mysteryBookList, "Where The Crawdads Sing");
		addFictionBook(mysteryBookList, "Hounds Of The Baskervilles");
		
		System.out.printf("The list of Books in the bookList: %n");
		printAll(bookList);
		System.out.printf("%nThe list of mysteries in the mysteryBookList: %n");
		printAll(mysteryBookList);
		
		deleteFictionBook(mysteryBookList, mysteryBookList.get(0));
		System.out.printf("%nThe list of Mystery Books after a deletion of the first Mystery Book in the Mystery Book List: %n");
		printAll(mysteryBookList);
	}
	
	public static void deleteFictionBook(ArrayList<? extends FictionBook> fictionBookList, FictionBook title)
	{
		fictionBookList.remove(title);
		System.out.printf("Book named %s was removed%n", title);
	}
	
	public static void addFictionBook(ArrayList<? super MysteryBook> mysteryBookList, String bookName)
	{
		MysteryBook newBook = new MysteryBook(bookName);
		mysteryBookList.add(newBook);
		System.out.printf("Book named %s was added%n", newBook);
	}
	
	public static void printAll(ArrayList<?> list)
	{
		for (Object temp : list)
		{
			System.out.println(temp);
		}
	}
}
