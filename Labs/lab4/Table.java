
public class Table
{
  	private static final int ROWS = 3;
  	private static final int COLS = 3;
	
public static void main(String[] args)
	{
		int[][] table = new int[ROWS][COLS];
		int[][] myTable = {{1,1,1},
				  {1,1,1},
				  {1,1,1}};	
		int factor = 5;
		initialize (table);
		scale (table, factor);	
		print (add(table, myTable));
	}

private static void initialize (int[][] table)
	{
           // Post : Each element of Table is initialized to the sum
           //        of its components

	   for (int i = 0;  i < table.length;  i++)
	   	for (int j = 0;  j < table[i].length;  j++)
			table[i][j] = i + j;
	}

private static void print (int[][] table)
	{
	   // Post : The contents of Table are printed to the screen
           //        in tabular format

	   System.out.println("\t[0]\t[1]\t[2]");

	   for (int i = 0;  i < table.length;  i++)
	   {
		System.out.print("[" + i  + "]");
	   	for (int j = 0;  j < table[i].length;  j++)
			System.out.print("\t" + table[i][j]);
		System.out.println();
	   }
	}

private static void scale (int [][] table, int factor)
	{
		table[0][0] = table[0][0] * factor;	
		table[0][1] = table[0][1] * factor;	
		table[0][2] = table[0][2] * factor;	
		table[1][0] = table[1][0] * factor;	
		table[1][1] = table[1][1] * factor;	
		table[1][2] = table[1][2] * factor;	
		table[2][0] = table[2][0] * factor;	
		table[2][1] = table[2][1] * factor;	
		table[2][2] = table[2][2] * factor;	
	}
	
private static int [][] add (int[][] a, int[][] b)
	{
		int [][] result = new int [ROWS] [COLS];
			for (int i=0; i < a.length; i++)
                                for (int j=0; j<a.length; j++)
                                        result[i][j] = a[i][j] + b[i][j];
                        return result;
        }
}	
