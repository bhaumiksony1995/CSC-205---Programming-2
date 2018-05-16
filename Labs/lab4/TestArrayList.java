import java.util.*;
public class TestArrayList
{
    public static void main(String[] args)
    {
	ArrayList<String> myArrayList = new ArrayList<String>(10);
	myArrayList.add("Python");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");
	delete(myArrayList, "Java");	
	//printArrayList(myArrayList);
	printArrayList(myArrayList);
	String shortest = "before call";
	findMin(myArrayList);
	System.out.println(shortest);




    }

    private static void printArrayList(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines
	System.out.println(myArrayList);	



    }

    private static void delete(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : All copies of key are removed from myArrayList
		myArrayList.remove(myArrayList.indexOf(key));	
		myArrayList.remove(myArrayList.indexOf(key));	
		myArrayList.remove(myArrayList.indexOf(key));	
		myArrayList.remove(myArrayList.indexOf(key));	
		myArrayList.remove(myArrayList.indexOf(key));	

    }

    private static int count(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : number of occurrences of key is computed and returned
	int count = 0;
	for (int i=0; i<myArrayList.size(); i++)
		{
			System.out.println(myArrayList.contains("Java"));
			count++;
		}
			
	return count;	
		


    }
    
    private static String findMin(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The smallest (in lexicographic order) string in the vector is returned
	String shortest = myArrayList.get(0);

for(String str : myArrayList) 
{
    if (str.length() < shortest.length()) 
	{
        shortest = str;
    	}
}
return shortest;
    }
}
