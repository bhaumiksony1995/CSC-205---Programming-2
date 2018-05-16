
public class Links
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
		count(pos1);
		findMax(pos1);
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}

	public static int count(Node head)
	{
		int counter = 0;
	
		if(head != null)
			return 0;
		else 
			return (1 + count(head.getNext())); 
		
		//return counter;
	}
	
	private static Node findMax(Node head)
	{
		Node max = head;
		Node temp = head.getNext();

		while(temp != null)
		{
			if(((Comparable)max.getItem()).compareTo((Comparable)temp.getItem()) < 0)
				{
					max = temp;
				}
		}
		temp = head.getNext();
		return max;
	}
}

