import java.io.Serializable;

public abstract class Employee implements Serializable
	{
		private String name;
                private double wage;

		protected Employee(String Name, double Wage)
			{
				name = Name;
				wage = Wage;
			}

		public String getName()
			{
				return name;
			}

		public double getWage()
			{
				return wage;
			}

		public void setName(String Name)
			{
				name = Name;
			}

		public void setWage(double Wage)
			{
				wage = Wage;
			}

		public abstract String computePay(double Wage);
			{
			}
		public boolean equals(Employee employee)
			{
				return name.equals(employee.getName());
			}

		public void raise(double Wage)
			{
				wage *= Wage / 100 + 1.0;
			}
	}
