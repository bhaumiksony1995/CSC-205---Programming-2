import java.io.Serializable;

public class HourlyEmployee extends Employee
	implements Serializable
	{
		public HourlyEmployee(String Name, double Wage)
			{
				super(Name, Wage);
			}

		public String computePay(double Wage)
			{
				double Wage1;
				if(Wage > 40)
					{
						Wage1 = 40 * super.getWage() + (Wage - 40) * super.getWage() * 1.5;
					}

				else
					{
						Wage1 = Wage * super.getWage();
					}

				String Name = "" + Wage1;

				try
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 3);
					}

				catch (StringIndexOutOfBoundsException sioobe)
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 2) + 0;
					}

				return Name;

			}

		public String toString()
			{
				String Name = "" +  super.getWage();

				try
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 3);
					}

				catch(StringIndexOutOfBoundsException sioobe)
					{
						Name = Name.substring(0, Name.indexOf('.')) + Name.substring(Name.indexOf('.'), Name.indexOf('.') + 2) + 0;
					}

				int i = 40 - super.getName().length() - Name.length() - "$/hour".length();

				String Name1 = super.getName();

				for(int j = 0; j <= i; j++)
					{
						Name1 = Name1 + " ";
					}

				return Name1 + "$" + Name +  "/hour";
			}
	}				
