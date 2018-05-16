public class arOne
{
  private static final int ASIZE = 10;     // our array size

  public static void main(String args[])
  {
    // create our array
    double ar1[] = new double[ASIZE];
        
    // initialize our array - note use of constant
    for(int i = 0; i < ASIZE; i++)
      ar1[i] = i+11;

    // display array in main
    for(int i = 0; i < ASIZE; i++)
      System.out.println(i + ": " + ar1[i]);

    // which element gets set to 2001?   
    ar1[ASIZE-1] = 2001;

    System.out.println("\nCalling Method to display contents of array:\n");
    DisplayArray(ar1);

    DisplayArray(Triple1(ar1));
    DisplayArray(ar1);
    Triple2(ar1);
    DisplayArray(ar1);

    //call to arrayAvg
    double average = 0.0;
    average = ArrayAvg (ar1);
    System.out.println("");
    System.out.println("Calling Method to calculate average of array:");
    System.out.println("");
    System.out.println("Average of Array: " + average);
    System.out.println("");
  }


  private static void DisplayArray(double ar[])
  //////////////////////////////////////////////////////
  // print the contents of array ar
  //////////////////////////////////////////////////////
  {        
    for (int i = 0; i < ar.length; i++)
      System.out.print(ar[i] + "  ");

    System.out.println();
  }

  private static double[] Triple1(double ar[])
  //////////////////////////////////////////////
  {
    double temp[] = new double[ASIZE];

    for (int i = 0; i < ar.length; i++)
      temp[i] = ar[i] * 3;

    return temp;
  }

  private static void Triple2(double ar[])
  //////////////////////////////////////////////
  {
    for (int i = 0; i < ar.length; i++)
      ar[i] = ar[i] * 3;
  }
  private static double ArrayAvg (double ar[])
	{
		double sum = 0.0;
		int i = 0;
		while (i < ar.length)
			{
				sum += ar[i];
				i++;
			}
		double average = sum / ar.length;
		return average;
	}
}
