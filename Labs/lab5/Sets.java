
import java.util.*;

public class Sets
{
	private static final int BOUND = 8;
	public static void main(String[] args)
	{
		BitSet set1 = new BitSet(BOUND);
		BitSet set2 = new BitSet(BOUND);
		
		for (int i = 1;  i < BOUND;  i *= 2)
			set1.set(i);

		for (int i = BOUND-1;  i > 0;  i /= 2)
			set2.set(i);
	
		System.out.print("set1 = ");
		print1(set1);
		System.out.println("");
		System.out.print("set2 = ");
		print2(set2);

		System.out.print("\ninverse of set1 = ");
		printi1(set1);
		System.out.println("");
		System.out.print("inverse of set2 = ");
		printi2(set2);

		//System.out.println("\ncardinality of set1 = " +
		//		    cardinality(set1));
		//System.out.println("cardinality of set2 = " +
	        //		    cardinality(set2));

		//System.out.print("\nset1 a subset of set2? ");
		//System.out.println(isSubset(set1, set2));
	}

public static void print1 (BitSet set1)
{
	
	System.out.println(set1);
	for (int i=0; i<set1.length(); i++)
	{	if ((set1.get(i) == true))
		{	
			System.out.print("1");
		}
	
		else if ((set1.get(i) == false))
		{	
			System.out.print("0");
		}
	}
}

public static void print2 (BitSet set2)
{
	 System.out.println(set2);
	 for (int j=0; j<set2.length(); j++)
        {       if ((set2.get(j) == true))
                {
                        System.out.print("1");
                }

                else if ((set2.get(j) == false))
                {
                        System.out.print("0");
                }
	
	}
}
public static void printi1 (BitSet set1)
{
for (int k=0; k<set1.length(); k++)
{
	if (set1.get(k) == true)
	{
		set1.set(k);
	}
	else if (set1.get(k) == false)
	{
		set1.clear(k);
	}
System.out.print(set1);
}
}

public static void printi2(BitSet set2)
{
for (int l=0; l<set2.length(); l++)
{
	if (set2.get(l) == true)
	{
		set2.set(l);
	}
	else if (set2.get(l) == false)
	{
		set2.clear(l);
	}
System.out.print(set2);
}
}

}
