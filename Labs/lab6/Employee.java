import java.util.*;
public class Employee extends Person
{
	private Date HireDate = new Date();
	private double Salary;
	
	public Employee (String lastName, String firstName, Date birthDate, double Salary, Date HireDate)
	{
		super(lastName, firstName, birthDate);
		this.Salary = Salary;
		this.HireDate = HireDate;
	}

	public void double getSalary(double Salary)
	{
		this.Salary = Salary;
	}

	public void Date getHireDate(Date HireDate)
	{
		this.HireDate = HireDate;
	}

	public Date setSalary(Date birthDate)
	{
		return birthDate;
	}

	public Date setHireDate(Date HirDate)
	{
		return HireDate;
	}
	
	public String toString()
	{
	return ("name = " + getLastName() + ", " + getFirstName() + "\nsalary = " + Salary + "\nbirth = " + getBirthDate() + "\nhired = " + HireDate);
	}
}		
