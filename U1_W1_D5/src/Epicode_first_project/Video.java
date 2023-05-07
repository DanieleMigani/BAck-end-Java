package Epicode_first_project;

public class Video extends MultimediaElement implements Reproducible {
	private int volume;
	private int luminosita;
	
	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo, durata);
		this.volume = volume;
		this.luminosita = luminosita;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void abbassaVolume() {
		if (volume > 0) {}
		volume--;
	}
	
	public void alzaVolume() {
		volume++;
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
	
	public void play() {
		for (int i = 0; i < durata; i++) {
			for (int j = 0; j < volume; j++) {
				System.out.print("!");
			}
			for (int j = 0; j < luminosita; j++) {
				System.out.print("*");
			}
			System.out.println(titolo);
		}
	}

	@Override
	public void abbasaVolume() {
		// TODO Auto-generated method stub
		
	}
}
