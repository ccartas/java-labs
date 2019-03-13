package ro.ase.java;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import ro.ase.java.models.ClothingItem;

public class Application {
	
	public static void main(String[] args) {
		List<ClothingItem> outlet = new ArrayList<>();
		
		ClothingItem c1 = new ClothingItem("Zara", "TSHIRT", "S", 100);
		ClothingItem c2 = new ClothingItem("Gucci", "HOODIE", "XS", 800);
		ClothingItem c3 = new ClothingItem("LV", "SHIRT", "M", 1000);
		ClothingItem c4 = new ClothingItem("LV", "SHIRT", "M", 1000);
		
		outlet.add(c3);
		outlet.add(c1);
		outlet.add(c2);
		outlet.sort(null);
		for (ClothingItem ci : outlet) {
			System.out.println(ci.toString());
		}
		
		Map<ClothingItem, String> locationMap = new Hashtable<ClothingItem, String>();
		
		locationMap.put(c1, "BANEASA");
		locationMap.put(c2, "MILITARI");
		locationMap.put(c3, "ROMANA");
		
		for(Entry<ClothingItem, String> entry : locationMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Set<ClothingItem> set  = new TreeSet<ClothingItem>();
		
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		
		for(ClothingItem item : set) {
			System.out.println(item);
		}
		
		Iterator<ClothingItem> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			ClothingItem item = iterator.next();
			System.out.println(item);
		}
	}
}
