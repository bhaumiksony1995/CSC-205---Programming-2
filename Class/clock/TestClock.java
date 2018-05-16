import java.util.*;

public class TestClock
	{
		public static void main(String[] args)
			{
				Scanner stdin = new Scanner(System.in);				

				Clock dvr = new Clock();
				
				System.out.println("What time would you like to set your DVR to?");
				System.out.print("Hours = ");
				int inputhours = stdin.nextInt();
				System.out.print("Minutes = ");
				int inputminutes = stdin.nextInt();
				System.out.print("Seconds = ");
				int inputseconds = stdin.nextInt();
		
				System.out.println("The time now is " + inputhours + ":" + inputminutes + ":" + inputseconds);
				System.out.println("Advancing the time!");
		
				dvr.Reset(inputhours, inputminutes, inputseconds);

				System.out.print("The time is now " + inputhours + ":" + inputminutes + ":" + inputseconds);

			}
	}
		
