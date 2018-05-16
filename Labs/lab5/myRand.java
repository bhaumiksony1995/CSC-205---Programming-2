import java.util.*;
public class myRand
{
	public static void main (String args[])
	{
		Scanner stdin = new Scanner (System.in);
		//System.out.println("Please enter size");
		int size = stdin.nextInt();

		for (int i=0; i<size; i++)
		{
			int random = (int)(Math.random()*499);	
			System.out.println(random);
		}
	}
}
			
