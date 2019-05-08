package eu.ase.test;

public class App {

	public static void main(String[] args) {
		Vehicle v1;
		try {
			v1 = new Vehicle("", "A5", "VS-94-CRT", 177, 0);
			Vehicle v2 = v1.clone();
			System.out.println(v1.getMake() == v2.getMake());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	}
}
