package ro.ase.java.primitives;

/**
 * 
 * @author cosmincartas
 * TIPURI DE DATE PRIMITIVE:
 * boolean - dimensiune 1 bit
 * byte - dimensiune 8 biti
 * short - dimensiune 2 bytes
 * char - dimensiune 2 bytes
 * int - dimensiune 4 bytes
 * float - dimensiune 4 bytes
 * long - dimensiune 8 bytes
 * double - dimensiune 8 bytes
 */
public class MainArrays {

	public static void main(String[] args) {
		
		int noShowrooms = 2;
		int noCars = 2;
		
		long[][] pricesOfCars = new long[][] {{425000,110000}, {28000, 70000}}; // masiv de date bidimensional
		
		double[] averagePrices = new double[noShowrooms]; //masiv de date unidimensional
		
		for(int i=0; i < noShowrooms;i++) {
			averagePrices[i] = 0;
			for(int j=0; j<noCars;j++) {
				averagePrices[i] += pricesOfCars[i][j];
			}
			averagePrices[i] = averagePrices[i]/noCars;
		}
		
		for(int i=0; i<noShowrooms;i++) {
			System.out.println("Pretul mediu al unei masini in showroom-ul "+ (i+1) + " este: " + averagePrices[i]);
		}
	}
}
