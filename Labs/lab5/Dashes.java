import java.util.*;
public class Dashes
{
	public static void main(String[] args)
	{
		String word = "Two-Thousand-And-Ten";
		System.out.println(removeDashes(word));
	}
	public class String removeDashes(StringBuffer word)
	{
		StringBuffer word = new StringBuffer();
		word = new StringBuffer();
		word.replace("-", " ");
		String strword = word.toString();
		return strword;	
	}
}
