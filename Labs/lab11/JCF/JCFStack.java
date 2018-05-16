import java.util.*;

public class JCFStack
{
   public static void main(String[] args) throws CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push(new Integer(27));
		stack1.push(new Integer(0));
		stack1.push(new Integer(-3));
		stack1.push(new Integer(-18));
		stack1.push(new Integer(99));
        	printStack (stack1); 

  }

  private static void printStack (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("*** Printing Out Stack:  ");

        while (! tempStack.isEmpty())
        {
               System.out.println(tempStack.peek());
               tempStack.pop();
        }
  }

  public static void keyValue(Stack s)
  {
	System.out.println("key value = ");
	Scanner stdin = new Scanner(System.in);
	int keyval = stdin.nextInt();
	int valuepos = 0;
	while(!s.isEmpty())
	{
		if(s.search() == keyval)
		{
			valuepos++;
			System.out.println("key value found as position " + valuepos);
		}
	
		else
		{
			valuepos = -1;
			System.out.println("key value found at position " + valuepos);
		}
	}
	
}
}
