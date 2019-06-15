package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSortingEmployee 
{
	public static void main(String[] args) 
	{
		List<Workers> Wlist = new ArrayList<Workers>();
		Wlist.add(new Workers("Nitesh", 25, 40000));
		Wlist.add(new Workers("Prem", 50, 41000));
		Wlist.add(new Workers("Sonali", 35, 38000));
		Wlist.add(new Workers("Kiran", 20, 9600));
		Wlist.add(new Workers("Sonali", 36, 27000));
		
		System.out.println("Sorting by name: ");
		Collections.sort(Wlist, new Sortbyname());
		Wlist.forEach(worker -> System.out.println(worker));
		
		System.out.println("\nSorting by age: ");
		Collections.sort(Wlist, new Sortbyage());
		Wlist.forEach(worker -> System.out.println(worker));
	}
}

class Workers
{
	String name;
	int age;
	int salary;
	
	public Workers(String nm, int ag, int sal)
	{
		this.name = nm;
		this.age = ag;
		this.salary = sal;
	}
	
	// Used to print student details in main() 
    public String toString() 
    { 
        return this.name + " " + this.age + " "+ this.salary; 
    }
}

class Sortbyname implements Comparator<Workers> 
{ 
    // Used for sorting in ascending order of 
    // name
    public int compare(Workers a, Workers b) 
    { 
        return a.name.compareTo(b.name);
    } 
} 
  
class Sortbyage implements Comparator<Workers> 
{ 
    // Used for sorting in ascending order of 
    // age
    public int compare(Workers a, Workers b) 
    { 
        return a.age - b.age;
    } 
}


