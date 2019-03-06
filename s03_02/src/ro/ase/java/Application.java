package ro.ase.java;

public class Application {

	public static void main(String[] args) {
		Product p = new Product();
		p.setName("Iphone XR");
		p.setPrice(4000);
		
		Product p1 = p.clone() ;
		Product p2 = p;
		p1.setName("Iphone XS");
		p2.setName("Iphone X");
		System.out.println(p.getName());
		System.out.println(p1.getName());
		System.out.println(p2.getName());
	}
}
