public class CheckingAccount extends Account
{
	double balance;
        int numChecks = 0;
	
	public CheckingAccount (double initBalance)
	{
	  super(initBalance);
	  balance = initBalance;
	}
	
	public double getBalance()
	{	
		return balance;
	}
	
	public void writeCheck(double amount)	
	{
		numChecks++;
		balance = balance - amount;
	}   
	public int getChecksWritten ()	
	{
		return numChecks;
	}

	public void close()	
	{
		balance = 0.0;
	}
}


