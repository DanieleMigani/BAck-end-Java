package model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("Libro")
@NamedQuery(name = "LibriByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :au")
public class Libro extends Elemento_Catalogo{
	
	private String autore;
	private String genere;

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + "]";
	}
	
}
