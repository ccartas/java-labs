package ro.ase.cts;

import java.util.List;

public class AsistentInteligent {
	String nume;
	List<String> comenzi;
	
	public AsistentInteligent(String nume){
		nume=nume;
	}
	
	public void adaugaComandaVocala(String comanda) {
		this.comenzi.add(comanda);
	}
	
	public double getProcentajBaterie() {
		double full = 100;
		for(String s : comenzi) {
			if(s.length() <= 15) {
				full -= 1;
			}
		}
		return full;
	}
	
	public List<String> clasificareComezi(IInteligentaArtificiala ai) throws ExceptieClasificareComenzi {
		if(this.comenzi != null)
			return ai.clusterizare(this.comenzi);
		throw new ExceptieClasificareComenzi();
	}
	
}
