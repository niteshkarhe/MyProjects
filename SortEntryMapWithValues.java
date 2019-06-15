package hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortEntryMapWithValues 
{
	public static void main(String[] args)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Nilesh", 50);
		map.put("Vikas", 45);
		map.put("Avani", 60);
		map.put("Chetan", 70);
		map.put("Srikant", 85);
		map.put("Ishita", 25);
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> Setlist = new ArrayList<Entry<String, Integer>> (entrySet);
		
		Collections.sort(Setlist, new DescendingValues());
		
		System.out.println("Map with values in descending order:");
		Setlist.forEach(item -> System.out.println(item.getKey()+"----> "+item.getValue()));
		
		Collections.sort(Setlist, new AscendingValues());
		System.out.println("\nMap with values in ascending order:");
		Setlist.forEach(item -> System.out.println(item.getKey()+"----> "+item.getValue()));

	}
}

class DescendingValues implements Comparator<Entry<String, Integer>>
{
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2 )
	{
		return o2.getValue() - o1.getValue();
	}
}

class AscendingValues implements Comparator<Entry<String, Integer>>
{
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2 )
	{
		return o1.getValue() - o2.getValue();
	}
}