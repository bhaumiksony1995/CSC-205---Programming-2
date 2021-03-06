import Utils.Print;
import java.io.*;
import jpb.SimpleIO;

public class Personnel
	{
		public static Employee employees[] = new Employee[1];
                private static int numEmployees = 0;
		
		public Personnel()
			{
			}

		public static void main(String args[])
			{
				do
					switch(menu())
					{
					case 'n':
						newEmployee();
						break;

					case 'c':
						paychecks();
						break;

					case 'r':
						raise();
						break;

					case 'p':
						print();
						break;

					case 'd':
						download();
						break;

					case 'u':
						upload();
						break;

					case 'q':
						System.exit(-1);
					
					default:
						menuError();
						break;
					}
				while(true);
			}

		public static char menu()
			{
				System.out.println("\n-----------------------------------");;
				System.out.println("|Commands: n - New employee       |");
				System.out.println("|          c - Computer paychecks |");
				System.out.println("|          r - Raise wages        |");
				System.out.println("|          p - Print records      |");
				System.out.println("|          d - Download data      |");
				System.out.println("|          u - Upload data        |");
				System.out.println("|          q - Quit               |");
				System.out.println("-----------------------------------");

				SimpleIO.prompt("Enter Command: ");
				char array[] = SimpleIO.readLine().trim().toLowerCase().toCharArray();
				if(array.length > 1)
					return '0';
				else
					return array[0];
			}

		public static void newEmployee()
			{
				SimpleIO.prompt("Enter the name of the new employee: ");
				String Name = SimpleIO.readLine().trim();
				SimpleIO.prompt("Hourly (h) or Salaried (s): ");
				char array[] = SimpleIO.readLine().trim().toLowerCase().toCharArray();
				switch(array[0])
					{
						case 'h':
							newHourly(Name);
							break;

						case 's':
							newSalaried(Name);
							break;

						default:
							System.out.println("Input was not in hours, please try again.");
							break;
					}
			}

		public static void newHourly(String Name)
			{
				SimpleIO.prompt("Enter hourly wage: ");
				try
					{
						double Wage = Double.parseDouble(SimpleIO.readLine().trim());
						employees[numEmployees] = new HourlyEmployee(Name, Wage);
						numEmployees++;
						checkSize();
					}
				catch(NumberFormatException nfe)
					{
						System.out.println("\nError: the wage must be entered as a number. Please try again.");
					}
			}

		public static void newSalaried(String Name)
			{
				SimpleIO.prompt("Enter annual salary: ");
				try
					{
						double Wage = Double.parseDouble(SimpleIO.readLine().trim());
						employees[numEmployees] = new SalariedEmployee(Name, Wage);
						numEmployees++;
						checkSize();
					}
				catch(NumberFormatException nfe)
					{
						System.out.println("\nError: the salary must be entered as a number. Please try again");
					}
			}

		public static void paychecks()
			{
				try
					{
						for(int i = 0; i < numEmployees; i++)
							{
								SimpleIO.prompt("Enter number of hours worked by " + employees[i].getName() + ": ");
								System.out.println("Pay: $" + employees[i].computePay(Double.parseDouble(SimpleIO.readLine().trim())));
							}
					}
				catch(NumberFormatException nfe)
					{
						System.out.println("\nHours must be entered as a number; Please try again.");
					}
			}

		public static void raise()
			{
				SimpleIO.prompt("Enter raise rate: ");
				try
					{
						double Wage = Double.parseDouble(SimpleIO.readLine().trim());
						for(int i = 0; i < numEmployees; i++)
							{
								employees[i].raise(Wage);
							}
						System.out.println("\nNew Wages\n---------");
						print();
					}
				catch(NumberFormatException nfe)
					{
						System.out.println("\nError in rate increase; Please try again.");
					}
			}

		public static void print()
			{
				for(int i = 0; i < numEmployees; i++)
					{
						System.out.println(employees[i]);
					}
			}

		public static void download()
			{
				try
					{
						System.out.println("Now downloading these records...:");
						print();
						ObjectOutputStream outputs = new ObjectOutputStream(new FileOutputStream("Employees.dat"));
						outputs.writeObject(employees);
						outputs.close();
					}

				catch(IOException ioe)
					{
						System.err.println("\nError writing to Employees.dat\n");
					}
			}

		public static void upload()
			{
				try
					{
						ObjectInputStream inputs = new ObjectInputStream(new FileInputStream("Employees.dat"));
						Employee oneemployee[] = (Employee[])inputs.readObject();
						compare(oneemployee);
					}
				catch(IOException ioe)
					{
						System.err.println("\nError readong from Employees.dat");
					}
				catch(ClassNotFoundException cfe)
					{
						System.err.println("\nError reading from Employees.dat");
					}
			}

		public static void compare(Employee oneemployee[])
			{
				int i = 0;
				try
				{
					for(int j = 0; j < oneemployee.length; j++)
					{
						boolean alert = false;
						for(int k = 0; j < numEmployees; k++)
						{
							if(oneemployee[j].equals(employees[k]))
								alert = true;
						}
						
						if(!alert)
						{
							employees[numEmployees] = oneemployee[j];
							numEmployees++;
							i++;
							checkSize();
						}
					}
				}
				catch(NullPointerException npe)
					{
						System.out.println(i + " new employees added.");
					}
				catch (Exception e)
					{
						System.out.println(i + " new employees added.");
					}
			}
			
		public static void menuError()
			{
				System.out.println("\nCommand was not recognized. Please try again.");
			}

		public static void checkSize()
			{
				if(numEmployees == employees.length)
					{
						Employee oneemployee[] = new Employee[employees.length * 2];
						for(int i = 0; i < employees.length; i++)
							{
								oneemployee[i] = employees[i];
							}

						employees = oneemployee;
					}
			}
		}
