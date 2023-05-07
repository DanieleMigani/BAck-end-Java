package Epicode_first_project;

public class Imagine extends MultimediaElement {
	private int luminosita;
	
	public Imagine(String titolo, int luminosita) {
		super(titolo, 0);
		this.luminosita = luminosita;
	}
	
	public int getLuminosita() {
		return luminosita;
	}
	
	public void aumentaLuminosita() {
		if (luminosita < 10) {
			luminosita++;
		}
	}
	
	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}
	}
	
	public void show() {
		for (int i = 0; i < luminosita; i++) {
			System.out.print("*");
		}
		System.out.println(titolo);
	}
}
