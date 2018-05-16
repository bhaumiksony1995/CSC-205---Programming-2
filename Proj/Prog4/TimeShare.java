import java.io.*;
import java.util.Scanner;

public class TimeShare extends Queue
{
	public static void main(String args[]) throws IOException, CloneNotSupportedException
	{
		Queue myQueue = new Queue();
		//Queue inputQ = new Queue();
		//int ArrT[] = new int [2];
		makeInput(myQueue, args);
		//processJob(myQueue, inputQ, ArrT);
		//SummaryReport(inputQ, ArrT[0], ArrT[1]);
	}

	public static void makeInput(Queue myQueue, String args[]) throws IOException, CloneNotSupportedException
	{
		Queue inputQ = new Queue();
		int ArrT[] = new int [2];
		int startTime = 0;
		int arrivalTime = 0;
		if(args.length == 0)
		{
			System.out.println("No file name was entered, please try again");
			System.exit(-1);
		}
		
		Scanner input = new Scanner(new File(args[0]));
		
		while (input.hasNext())
		{
			String jobName = input.next();
			startTime = input.nextInt();
			arrivalTime = input.nextInt();
			Job myJob = new Job (jobName, startTime, arrivalTime);
			if(!myQueue.isEmpty())
			{
				myQueue.enqueue(myJob);
	//			System.out.print(myQueue);
			}
		}
		//while(input.hasNext());
		processJob(myQueue, inputQ, ArrT);
		SummaryReport(inputQ, ArrT[0], ArrT[1]);
	}
	private static Queue processJob(Queue myQueue, Queue inputQ, int ArrT[]) throws CloneNotSupportedException
	{
		int clock = 1;
		int idle = 0;
		int usage = 0; 	
		Queue Q2 = new Queue();

		do {
				if(!myQueue.isEmpty())
					{
						Job myJob = (Job)myQueue.front();
					
						if(myJob.arrivalTime == clock) //Check for seeing if arrival time is same as clock
						{
							Q2.enqueue(myJob);
		//					System.out.print(Q2);
							myQueue.dequeue();
		//					System.out.print(myQueue);
						}
					}

				if(!Q2.isEmpty())
					{
						Job myJob2 = ((Job)Q2.front());
						if(myJob2.startTime != -1 && clock - myJob2.startTime == myJob2.runTime)
							{	
								myJob2.turnTime = clock - myJob2.arrivalTime;
								inputQ.enqueue(myJob2);
		//						System.out.print(inputQ);
								Q2.dequeue();
		//						System.out.print(Q2);
							}
					}

				if(!Q2.isEmpty())
					{
						Job myJob3 = (Job)Q2.front();
						if(myJob3.arrivalTime <= clock && !Started(Q2, myJob3))
							{
								((Job)Q2.front()).startTime = clock;
								((Job)Q2.front()).waitTime = clock - myJob3.arrivalTime;
							}
					}
			
				if(Q2.isEmpty() && !myQueue.isEmpty()) 
					{
						idle++;
					}
				else
				if(!Q2.isEmpty())
					{
						usage++;
					}

				clock++;
			}
		while((!myQueue.isEmpty()) || (!Q2.isEmpty()));
		ArrT[0] = idle;
		ArrT[1] = usage;
		return inputQ;
	}

	private static boolean Started(Queue queue, Job myJob) throws CloneNotSupportedException
                {       
			while(!queue.isEmpty())
                        {       
                                String input =((Job)queue.front()).jobName;
				if(input.equals(myJob.jobName) && myJob.startTime != -1)
					return true;
                        }
/* for(queue1 = (Queue)queue.clone(); !queue1.isEmpty(); queue1.dequeue())
                        {       
                                String input = ((Job)queue1.front()).jobName;
                                if(input.equals(myJob.jobName) && myJob.startTime != -1)
                                        return true;
                        }

                        */return false;
                }

	private static void SummaryReport(Queue inputQ, int idle, int usage) throws CloneNotSupportedException
		{
			System.out.println("");
			System.out.println("\tJob Control Analysis : Summary Report");
			System.out.println("\t");
			System.out.println("\tJob id\tArrival\tStart\tRun \tWait\tTurnAround");
			System.out.println("	    \tTime   \tTime \tTime\tTime\tTime");
			System.out.println("\t------\t-------\t-----\t----\t----\t----");
			System.out.println("");
			System.out.println("\tJob 1");
			System.out.println("\tJob 2");
			System.out.println("\tJob 3");	
			Job myJob;
			//Queue copyQ = (Queue) inputQ.clone();
			while(!inputQ.isEmpty())
			{
				//System.out.print(inputQ);
				myJob = (Job) inputQ.front();
				usage += myJob.waitTime;
				idle++;
				inputQ.dequeue();
			}
			//Queue queue = new Queue();	
			/*for(queue = (Queue)inputQ.clone(); !queue.isEmpty(); queue.dequeue())
			        {
					System.out.print(queue);
            				Job myJob = (Job)queue.front();
			                b += myJob.waitTime;
         			        a++;
       				}
			*/
			System.out.println("");
			System.out.println("\t\tAverage Wait Time -> " + (double)Math.round(((double)usage / (double)idle) * 100) / 100);
			System.out.println("\t\t	CPU Usage -> " + (double)usage);
			System.out.println("\t\t     	 CPU Idle -> " + (double)idle);
			System.out.println("\t\tCPU Usage Percent -> " + (double)Math.round(((double)usage / (double)(usage + idle)) * 100 * 100) / 100);
		}

	private static void printQueue(Queue inputQ) throws CloneNotSupportedException
	{
		Job outputJob;
                	//Queue copyQ = (Queue) inputQ.clone();

                while (! inputQ.isEmpty())
                {
                        outputJob = (Job) inputQ.front();
                        System.out.println("\t" + outputJob);
                        inputQ.dequeue();
		}
			/*Queue queue = new Queue();
			for(queue = (Queue)inputQ.clone(); !queue.isEmpty(); queue.dequeue())
				{
					Job myJob = (Job)queue.front();
					System.out.println("\t" + myJob);
				}
			*/
		
	}	
}	
				
				
