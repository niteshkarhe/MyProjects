package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableSortingEmplyoee 
{
	public static void main(String[] args) 
	{
		List<Employee> Elist = new ArrayList<Employee>();
		Elist.add(new Employee("Nitesh", 25, 40000));
		Elist.add(new Employee("Prem", 50, 41000));
		Elist.add(new Employee("Sonali", 35, 38000));
		Elist.add(new Employee("Kiran", 20, 9600));
		Elist.add(new Employee("Sonali", 36, 27000));
		
		Collections.sort(Elist);
		
		//Sorting by age
		for(Employee emp: Elist)
		{
			System.out.println("Name: "+emp.getName()+" Age: "+emp.getAge()+" Salary: "+emp.getSalary());
		}
	}

}

class Employee implements Comparable<Employee>
{
	private String name;
	private int age;
	private int salary;
	
	public Employee(String nm, int ag, int sal)
	{
		this.name = nm;
		this.age = ag;
		this.salary = sal;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public int getSalary() {return salary;}
	
	public int compareTo(Employee e) 
	{
		return e.age - this.age;
	}
	
}
