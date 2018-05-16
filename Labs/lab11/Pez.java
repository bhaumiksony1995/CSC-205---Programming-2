import java.util.*;
public class Pez
{
	public static void main(String[] args)
   	{
		Stack pez = new Stack();
		fillStack(pez);
		removeGreen(pez);
	}

	public static  Stack fillStack(Stack pez)
	{
		pez.push("green");
		pez.push("red");
		pez.push("yellow");
		pez.push("yellow");
		pez.push("green");
		pez.push("green");
		pez.push("red");
		pez.push("yellow");
	}

	public static Stack removeGreen(Stack pez)	
	{
		String color = "";
		Stack temp = new Stack();
		while (!pez.isEmpty())
                {
                        temp = pez.pop();
                        if (color != "green")
                                temp.push(color);
                        else
                        {
                                pez.push(color);
                        }
                }
                reverseStack();		
	}

	public static void reverseStack(Stack temp)
	{
		while (!temp.isEmpty())
                {
                        temp.push(temp.pop());
                }
	}
}
