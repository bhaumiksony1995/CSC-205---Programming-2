public class mySums
{
	public static void main(String[] args)
	{
		int n = 4;
		//double sum = iterativeSum(n);
		double sum = recurSum(n);
		System.out.println(sum);
	}

	public static double iterativeSum(int n)
	{
		double Sum = 0;

		for(int k=1; k<=n; k++)
		{
			Sum += ((Math.pow(2, k)) + 1);
		}
	return Sum;
	}

	public static double recurSum(int n)
	{
		double Sum = 0;
		if(n==0)
			return 0;
		else
			return ((Math.pow(2,n) + 1) + (recurSum(n-1)));
	}
}		
