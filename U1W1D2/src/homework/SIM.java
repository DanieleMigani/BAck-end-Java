package homework;

public class SIM {
	String numero;
	int credito= 0;
	String chiamate[] = new String [5];
	private String chiamata;
	
	
	public SIM(String a) {
		this.numero= a;
	}
	
	public String chiama(String numChiamato, String durataChiamata) {
		this.chiamata = numChiamato;
		this.credito -= 1;
		return this.chiamata;
	}
	
	
	
	public int riarica(int euro) {
		return this.credito += euro;
	}
	
	public static void stampaInfoSim(SIM s) {
		System.out.println("Il tuo numero" + s.numero);
		System.out.println("Le tue ultime 5 chiamate");
	}

}
