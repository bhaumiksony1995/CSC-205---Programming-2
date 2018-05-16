import java.util.*;

public class Clock
	{
		private int Hours;
		private int Minutes;
		private int Seconds;
		private int inputhours;
		private int inputseconds;
		private int inputminutes; 		

		private Clock (int inputhours, int inputminutes, int inputseconds)
			{
				Hours = inputhours;
				Minutes = inputminutes;
				Seconds = inputseconds; 		
			}
		
		public Clock ()
			{
				Hours = 0;
				Minutes = 0;
				Seconds = 0;
			}
		
		public void reset ()
			{
				Hours = 0;
				Minutes = 0;
				Seconds = 0;
			}

		public void Reset (int inputhours, int inputminutes, int inputseconds)
			{
				Hours = 00;
				Minutes = 00;
				Seconds = 00;
			}

		public void advance ()
			{
				if (inputseconds == 60)
					{
						inputminutes++;
					}
				if (inputminutes == 60)
					{
						inputhours++;
						inputseconds = 0;
					}
				if (inputhours == 24)
					{
						inputhours = 0;
						inputminutes = 0;
					}			
			}
		
		public String toString ()
			{
				return "" + inputhours + ":" + inputminutes + ":" + inputseconds;
			}					
	}















				

