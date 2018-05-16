public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }

  public Person()
	{
		String name = "N/A";
		id = -1;
		personCount++;
	}
  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }

  public void reset (String input, int number)
	{
		name = input;
		id = number;
	}
  
  public String getName ()
	{
		return name;
	}

  public int getId()
	{
		return id;
	}
}
