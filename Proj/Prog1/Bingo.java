import java.util.*;
import java.util.Scanner.*;
import java.io.*;
public class Bingo
{
	public static final int HORIZONTAL = 1;
	public static final int VERTICAL = 2;
	public static final int DIAGONAL = 3;
	public static int [][]bcard = new int [5][5];
	public static int NumofPicks = 75;
	public static int pickCount = 0;
	private static int randomArray[][] = new int[4][9];
	public static BitSet calledNumbers = new BitSet(76);
	public static void main (String args[])
	{
	fillCard();
	printCard();
	playGame();
	printCard();
	}
	
public static void fillCard ()
{
try {
	Scanner scanner = new Scanner(new File("bingo.in"));
	int i = 0;
	int j = 0;
	while((scanner.hasNextInt()) && (i<5))
	{
		bcard[i][j] = scanner.nextInt();
		j++;
		if (j > 4) 
		{
			i++;
			j = 0;
		}
	}
    }  

catch (FileNotFoundException ex) 
{
	System.err.println("An IOException was caught!");
	ex.printStackTrace();
}
}

public static boolean copy(int i, int bcard[], int j)
{
for (int k=0; k<j; k++)
{
	if(bcard[k] == i)
	{
		return true;
	}
}
return false;
}

public static void printCard()
{
System.out.println("\n\t\007YOUR BINGO CARD :");
System.out.println("\t   B    I    N    G    O   ");
System.out.println("\t--------------------------");
for (int i = 0; i<bcard.length; i++)
{
	for (int j=0; j<bcard.length; j++)
		if(bcard[i][j]==0)
			System.out.print("X |" + "\t");
		else 
			System.out.print(bcard[i][j] + "|" +  "\t");
			System.out.println();
	System.out.println();
}
		/*for(int i = 0; i < bcard.length; i++)
           		{	
				System.out.println();
				System.out.println();
              			System.out.print("| ");
		for(int j = 0; j < bcard[0].length; j++)
              		{
                if(bcard[i][j] == 0)
                        {
			System.out.print('X' + "  | ");
			continue;
			}
                if(bcard[i][j] < 10)
			{
                		 System.out.print(bcard[i][j] +  "  | ");
			}
		else 
			{
                 		System.out.print(bcard[i][j] + " | "); 
			}
		
			}
		System.out.println("\n\t--------------------------\n");	
          		}
	System.out.println();*/
	}	

public static void printBin() 
{
System.out.println("\tBingo numbers picked at random from bin : ");
for(int i = 0; i < randomArray.length; i++)
{
	for(int j = 0; j < randomArray[0].length; j++)
	{	
	System.out.print("\t" + randomArray[i][j] + "  ");
	}
System.out.println();	
}
}	

public static void randomBin()
	{
	int number = 0;

        while (true)
        {
        number = (int) (Math.random() * 75 + 1);
        if (calledNumbers.get(number))
                continue;
        else
        {
                calledNumbers.set(number);
                break;
        }
        }
                for (int i=0; i<5; i++)
                        {
                                for(int j=0; j<5; j++)
                                        {
                                                if(number == bcard[i][j])
                                                        {
                                                                bcard[i][j] = 0;
                                                        }
                                        }

                        }

                                                if((pickCount+1) % 6 ==0)
                                                        System.out.println();
                                                System.out.print(number + "\t");

                                pickCount++;
        }

public static void playGame()
	{
		int j = 0;
		int i = 0;
		for (i=0; i==0; i++)
                 /*       {
                                randomBin();
                                i = CheckWinner();
                                j++;
                                winner(i,j);
                        }
		*/
		do
			{
				randomBin();
				i = CheckWinner();
				j++;
			}
		while (i == 0);
			{
				winner(i, j);
			}			
	}


public static void winner(int i, int j)
	{
		System.out.print("\n\n\tYou Have Won With A ");
		switch(i)
		{
			case 1:
				System.out.print("Diagonaltal Bingo");
				break;
			case 2:
				System.out.print("Horizontal Bingo");
				break;
			case 3:
				System.out.print("Vertical Bingo");
				break;
		}
		StringBuffer printWin = new StringBuffer();
		printWin.append(" After ").append(j).append( " Picks!");
		System.out.print(printWin);
	}

public static int CheckWinner()
	{
	int i = 0;
        for(int i1 = 0; i1 <bcard.length; i1++)
        {
            int j = 0;
            for(int i2 = 0; i2 < bcard.length; i2++)
                j += bcard[i1][i2];

            if(j == 0)
                return 1;
	    else
		return i;
        }

        for(int j1 = 0; j1 < bcard.length; j1++)
        {
            int k = 0;
            for(int j2 = 0; j2 < bcard.length; j2++)
                k += bcard[j2][j1];

            if(k == 0)
                return 2;
	    else
		return i;
        }

        int l = 0;
        for(int k1 = 0; k1 < bcard.length; k1++)
            l += bcard[k1][bcard.length - k1 - 1];

        if(l == 0)
            return 3;
        l = 0;
        for(int l1 = 0; l1 < bcard.length; l1++)
            l += bcard[l1][l1];

        if(l == 0)
            return 3;
        else
            return i;

	}
}
