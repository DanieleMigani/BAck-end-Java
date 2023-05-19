package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "elementi_catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elemento", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "ElementoByISBN", query = "SELECT el FROM Elemento_Catalogo el WHERE el.codiceISBN = :codice")
@NamedQuery(name = "RimuoviByISBN", query = "DELETE Elemento_Catalogo el WHERE el.codiceISBN = :codice")
@NamedQuery(name = "ElementiByAnno", query = "SELECT el FROM Elemento_Catalogo el WHERE el.annoPubblicazione = :anno")
@NamedQuery(name = "ElementoByTitolo", query = "SELECT el FROM Elemento_Catalogo el WHERE el.titolo = :tit")
public abstract class Elemento_Catalogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	private String titolo;
	private String annoPubblicazione;
	private Integer numPagine;
	
	@OneToOne
	private Prestito prestito;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(Integer numPagine) {
		this.numPagine = numPagine;
	}

	public Long getCodiceISBN() {
		return codiceISBN;
	}

	@Override
	public String toString() {
		return "Elemento_Catalogo [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", numPagine=" + numPagine + "]";
	}

}
