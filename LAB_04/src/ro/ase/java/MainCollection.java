package ro.ase.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author cosmincartas
 * Most important interfaces:
 * java.util.List
 * java.util.Set
 * java.util.Map
 */
public class MainCollection {
	
	
	public static void main(String[] args) {
		
		Student s1 = new Student("Gigel", new int[] {10,9,7});
		Student s2 = new Student("Popel", new int[] {8,9,7});
		Student s3 = new Student("Dorel", new int[] {7,7,7});
		Student s4 = new Student("Ionel", new int[] {10,5,7});
		Student s5 = new Student("Ionel", new int[] {9,5,7});
		
		//aplicabilitate 
		List<Student> grupa = new ArrayList<>();
		grupa.add(s1);
		grupa.add(s2);
		grupa.add(s3);
		grupa.add(s4);
		
		
		Collections.sort(grupa);
		
		/*grupa.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		*/
		
		//enhanced for loop
		System.out.println("Aici s-a parcurs lista!");
		for(Student s : grupa) {
			System.out.println(s.getName());
		}
		
		
		System.out.println("Aici s-a parcurs setul!");
		
		Set<Student> studentiUnici = new HashSet();
		studentiUnici.add(s1);
		studentiUnici.add(s2);
		studentiUnici.add(s3);
		studentiUnici.add(s4);
		studentiUnici.add(s5);
		
		for(Student s : studentiUnici) {
			System.out.println(s.getName());
		}
		
		//colectie de tip cheie valoare
		Map<String, Student> serie = new HashMap<String, Student>();
		serie.put("1049", s1);
		serie.put("1048", s2);
		serie.put("1050", s3);
		
		System.out.println("Aici s-a parcurs map-ul!");
		for(Entry<String, Student> entry : serie.entrySet()) {
			System.out.println(entry.getValue().getName() + " este la grupa " + entry.getKey());
		}
	}
}
