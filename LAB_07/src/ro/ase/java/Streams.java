package ro.ase.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Streams {

	
	public static void main(String[] args) {
		
		
		List<Integer> values = new ArrayList<>();
		
		values.add(200);
		values.add(3);
		values.add(20);
		values.add(100);
		values.add(40);
		
		values.stream().map(value -> value = value * 2).forEach(v -> {
			System.out.println(v);
		});;
		
		System.out.println("Dupa filtrare");
		values.stream().map(value -> value = value * 2).filter(v -> v < 100 ).limit(2).forEach(val -> {
			System.out.println(val);
		});
		
		List<Integer> values1 = values.stream().map(value -> value = value * 2)
								.filter(v -> v < 100 )
								.limit(2)
								.collect(Collectors.toList());
		
		System.out.println("Dupa collect");
		for(Integer i : values1) {
			System.out.println(i);
		}
		
	}
}
