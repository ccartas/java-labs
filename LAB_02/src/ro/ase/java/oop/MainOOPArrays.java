package ro.ase.java.oop;

public class MainOOPArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Showroom s1 = new Showroom("PORSCHE PIPERA", 3, new long[]{200320, 400000,50000});
		Showroom s2 = new Showroom("BAVARIA BANEASA", 2, new long[] {100000, 150000});
		
		Showroom[] showrooms = new Showroom[2]; // initializare vector de obiecte de tip Showroom
		showrooms[0] = s1;
		showrooms[1] = s2;
		
		for(int i=0; i<2; i++) {
			System.out.println("Pretul mediu al unei masini in showroomul " + showrooms[i].getShowroomName() + " este: " + showrooms[i].getAveragePrice());
		}
	}

}
