
public class Queue implements QueueInterface {
  private Node lastNode;
  private Object[] List;
  private int front, back, count;
  private int max = 50;
  
  public Queue() 
  {
	lastNode = null;   
  }  // end default constructor
  
  // queue operations:
  
  public boolean isEmpty() 
  {
        return (lastNode == null);
  }  // end isEmpty

  public void dequeueAll() 
  {
	lastNode = null;
  }  // end dequeueAll

  public void enqueue(Object newItem) 
  {
	Node newNode = new Node(newItem);
	
	//insert new queue
	if(isEmpty())
	{
		newNode.setNext(newNode);
	}

	else
	{
		newNode.setNext(lastNode.getNext());
		lastNode.setNext(newNode);
    	}  // end if
	
	lastNode = newNode;
  }  // end enqueue

  public Object dequeue() throws QueueException 
  {
	if (!isEmpty()) // queue is not empty; remove front
	{
        	Node firstNode = lastNode.getNext();
	
		if (firstNode == lastNode) 
		{ 
			lastNode = null;           // yes, one node in queue
		}
		else 
		{
			lastNode.setNext(firstNode.getNext());
		}// end if
	
		return firstNode.getItem();
	}
	
	else
	{
		throw new QueueException("QueueException on dequeue:" + "queue empty");
	}  // end if
  }  // end dequeue  

public Object front() throws QueueException 
{
 if (!isEmpty()) 
 {
      // queue is not empty; retrieve front
      Node firstNode = lastNode.getNext();
      return firstNode.getItem();
 }
 
 else 
 {
      	throw new QueueException("QueueException on front:"
      + "queue empty");
 }
}

  public Object clone() throws CloneNotSupportedException
  {
  boolean copied = false;
        Queue copy = new Queue();
        Node curr = lastNode, prev = null;
        while ( (! copied) && (lastNode != null) )
        {
                Node temp = new Node(curr.getItem());
                if (prev == null)
                        copy.lastNode = temp;
                else
                        prev.setNext(temp);
                prev = temp;
                curr = curr.getNext();
                copied = (lastNode == curr);
        }
        prev.setNext(copy.lastNode);
        return copy;
  }
} // end Queue
