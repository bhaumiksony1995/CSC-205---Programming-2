import java.util.*;
import java.io.*;

public class MaxTest  
{
   public static void main(String[] args) throws IOException, CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push("Andy");
		stack1.push("Allison");
		stack1.push("Aaron");
		stack1.push("Austin");
		stack1.push("Abbey");
		stack1.push("Alex");
        	System.out.println("findMax(stack1)="+findMax(stack1)); 
//        	System.out.println("stack1.findMax()="+stack1.findMax()); 
   }

   public static Stack findMax(Stack stack1) throws CloneNotSupportedException
   {
	Stack temp = stack1;
	Stack max = new Stack();
	while (!temp.isEmpty())
	{
		if(((Comparable)temp.top()).compareTo((Comparable)temp.top()) > )
			{}
		else
		{
			max = temp;
			temp = temp.top();
		}
       	}
	return max;
    }
}
