import java.util.*;
import java.io.*;

public class greatBooks
{
private static int numBooks = 0;
final static int length = 50;
final static LibraryBook[] records = new LibraryBook[length];
public static void main(String[] args)
{
	clearScreen();
	System.out.println("\t\t\tThe Book Search Program");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("\n\tWhat file is your book stored in?");
	System.out.println("\tHere are the files in your current directory");
	
	File curDir = new File(".");
	String[] fileNames = curDir.list();
	ArrayList<String> data = new ArrayList<String>();
	
	for(String s : fileNames)
	{
		if(s.endsWith("dat"))
		data.add(s);
	}
	System.out.println("\n" + data);
	System.out.print("\n\tFile name: ");
	Scanner stdin = new Scanner(System.in);
	String recordFile = stdin.next();	

	fillLibrary(recordFile);
        sortLibrary(numBooks);
        menu();
}

private static int fillLibrary(String recordFile)
{
	int counter = 0;
	try
	{
		Scanner input = new Scanner(new File(recordFile));
		while(input.hasNextLine())
		{
			Scanner lsc = new Scanner(input.nextLine()).useDelimiter(";");
			String title = lsc.next();
			String author = lsc.next();
			int copyright = lsc.nextInt();
			double price = lsc.nextDouble();
			String genre = (lsc.next()).replace(';',' ').trim();

			if (genre.equals("f"))
			{
				genre = "Fiction";
			}
			else if (genre.equals("nf"))
			{
				genre = "Non-Fiction";
			}
			else if (genre.equals("p"))
			{
				genre = "Poetry";
			}
			else
			{
				genre = "Drama";
			}
			LibraryBook myBook = new LibraryBook(title, author, copyright, price, genre);
			records[counter] = myBook;
			
			counter++;
			
			numBooks++;
		}
	  
//	System.out.println("\n\tA total number of " + counter + " books have been input and sorted by title");
	}	
	
	catch (IOException e)
	{
		System.err.println(" Error: File not found."); 
	}
	
	return counter;
}

private static void sortLibrary(int numBooks)
{
	{
	Scanner choice = new Scanner(System.in);
     int minIndex, index, j;
     LibraryBook temp = new LibraryBook("", "", 0, 0.0, "");
      int pass = 0; String titleTemp = temp.getTitle();

     for( index = 0; index < numBooks - 1; index++)
        {
         minIndex = index;
         for( j = minIndex + 1; j < numBooks; j++)
             if((records[j].compareTo(records[minIndex])) < 0)
                 minIndex = j;

         if( minIndex != index)
           {
             titleTemp = records[index].getTitle();
             records[index] = new LibraryBook(records[minIndex].getTitle(), records[index].getAuthor(), records[index].getCopyright(),
                                  records[index].getPrice(), records[index].getGenre());
             records[minIndex] = new LibraryBook(titleTemp, records[minIndex].getAuthor(), records[minIndex].getCopyright(),
                                 records[minIndex].getPrice(), records[minIndex].getGenre());
           }
        }
     System.out.println("\n\tA total of " + numBooks + " books have been input & sorted by title.");
     System.out.print("\n\tPlease Hit Return to Continue...");
	Scanner key = new Scanner(System.in);
        key.nextLine();
	clearScreen();
    }
}

private static void menuScreen()
{
System.out.println("\n\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("\t\t		The Great Books Program");
System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("\t\t1) Display all book records");
System.out.println("\t\t2) Search for a book by title");
System.out.println("\t\t3) Exit Search Program");
System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.print("\t\tPlease enter your choice > ");
}

private static void menu()
{
int numChoice = -1;
Scanner choice = new Scanner(System.in);
do
{
	menuScreen();
	if(choice.hasNextInt())
	numChoice = choice.nextInt();

switch(numChoice)
{
	case 1:	clearScreen();
		displayRecords();
	break;

	case 2: titleSearch(records);
	break;

	case 3: System.out.println("\n\t\tThank You");
		System.out.println("");
		System.exit(0);
	break;

	default: System.out.println("Must choose valid option (1-3)");
	break;
}
}
while(numChoice == -1);
}

private static void titleSearch(LibraryBook[] records)
{
	System.out.print("\n\t\tPlease enter book title: ");
	Scanner book = new Scanner(System.in);
	String bookTitle = book.nextLine();

	int first = 0, last = numBooks-1, middle, location;

	boolean found = false;

	do
	{
		middle = (first + last) / 2;

		System.out.print(middle);

		if(bookTitle.compareTo(records[middle].getTitle()) < 0)
			last = middle-1;

		else
			first = middle + 1;
	}
	
	while((!found) && (first <= last));	

	location = middle;
	clearScreen();
	printRecord(records, location);
	System.out.print("\t\tHit enter to return to menu ");
	
	Scanner key = new Scanner(System.in);
	key.nextLine();
	clearScreen();
	menu();
}

private static void printRecord(LibraryBook[] records, int i)
{
	System.out.println("\t\tRecord # " + i + " : ");
	System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("\t\tAuthor's Name : " + records[i].getTitle());
	System.out.println("\t\tCopyright : " + records[i].getCopyright());
	System.out.println("\t\tPrice : " + records[i].getPrice());
	System.out.println("\t\tGenre : " + records[i].getGenre());
	System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}

private static void displayRecords()
{
	Scanner input = new Scanner(System.in);
	for(int j=1; j<numBooks; j++)
	{
		printRecord(records, j);
		System.out.print("\n\t\tPlease hit M for menu or enter to continue ");
		String choice = input.nextLine();
		if ((choice.equals("M")) || (choice.equals("m")))
		{
			clearScreen();
			menu();
		}

		else 
		{
			clearScreen();
		}
	}
	
	clearScreen();
	menu();
}

private static void clearScreen()
    {
        System.out.println("\u001b[H\u001b[2J");
    }                           
}
