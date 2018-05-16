import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable
	{
		public SalariedEmployee(String Name, double Wage)
			{
				super(Name, Wage / 52 / 40);
			}

		public double getSalary()
			{
				return super.getWage() * 40 * 52;
			}

		public void setSalary(double Wage)
			{
				super.setWage(Wage / 52 / 40);
			}

		public String computePay(double Wage)
			{
				double Wage1 = getSalary() / 52;
				String Name = "" + Wage1;
				try
				{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 3);
				}
				
				catch(StringIndexOutOfBoundsException sioobe)
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 2) + 0;
					}

				return Name;
			}

		public String toString()
			{
				String Name = "" + getSalary();
				
				try
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 2) + 0;
					}

				catch(StringIndexOutOfBoundsException sioobe)
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 2) + 0;
					}

				int i = 40 - super.getName().length() - Name.length() - "$/year".length();

				String Name1 = super.getName();

				for(int j = 0; j <= i; j++)
					{
						Name1 = Name1 + " ";
					}

				return Name1 + "$" + Name + "/year";
			}
}		
