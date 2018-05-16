
import java.util.*;

public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                identicalCheck(queue1, queue2));
		findAndReplace(queue1, key, new Character('*'));
		System.out.println("** After findAndReplace **");
		printQueue(queue1);
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{
		if(queue1.equals(queue2))
			return true;
	
		else 
			return false;
	}

	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{
		int size = queue1.size();
		LinkedList temp = new LinkedList();
		for (int i = 0; i < size; i++)
		{
			if (queue1.element().equals(key))
				{
					temp.addLast(newVal);
					queue1.removeFirst();
				}
			else
				{
					temp.addLast(queue1.element());
					queue1.removeFirst();
				}
		}

	}

	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{
		if (q.size() == 0)
			System.out.println("Queue is empty");
		else
			System.out.println(q);
	}


}
