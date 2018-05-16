public class blowUp
{
	public static int Counter = 0;
	public static void main(String[] args)
	{
		System.out.println(Counter);
		Counter++;
		main(args);
	}
}
