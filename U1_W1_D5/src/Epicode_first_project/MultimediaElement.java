package Epicode_first_project;


public class MultimediaElement {
	protected String titolo;
	protected int durata;
	
	public MultimediaElement(String titolo, int durata) {
		this.titolo = titolo;
		this.durata = durata;
	}

	public boolean eReproducible() {
		return durata > 0;
	}
	
	public void esegui() {
		if (this instanceof Imagine) {
			((Imagine) this).show();
		} else if (eReproducible()) {
			((Reproducible) this).play();
		}
	}
}
