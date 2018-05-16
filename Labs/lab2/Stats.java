Simport java.util.*;

public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);
		int range = range(List, numItems);
		double mean = mean(List, numItems);
        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}

	public static int fillUp (int [] List)
		{
			System.out.println("Please enter your values (Enter a 0 to stop) :");
			Scanner stdin = new Scanner(System.in);
			int numItems = 0;
			int myinput = -1;
			while (myinput != 0)
				{
					myinput = stdin.nextInt();
					List[numItems] = myinput;
					numItems++;
				}
			return numItems - 1;
		}	
			
	public static int range (int [] List, int numItems)
		{
			int MIN = List[0];
			int MAX = List[0];

			for (int i=0; i < numItems; i++)
				{
					if(List[i] < MIN)
						{
							MIN = List[i];
						}
					else if (List[i] > MAX)
						{
							MAX = List[i];
						}
				}
			return MAX - MIN;
		} 
	
	public static double mean (int [] List, int numItems)
		{
			double sum = 0.0;
			int i = 0;
			while (i < numItems)
				{
					sum += List[i];
					i++;
				}
			double average = sum / numItems;
			return average;	
		}	
}
