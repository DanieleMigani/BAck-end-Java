package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numPrestito;
	
	@ManyToOne
	private Utente utente;
	
	@OneToOne
	private Elemento_Catalogo elemento;
	private LocalDate inizioPrestito;
	private LocalDate restituzionePrevista;
	private LocalDate restituzioneEffettiva;
	
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public Elemento_Catalogo getElemento() {
		return elemento;
	}
	
	public void setElemento(Elemento_Catalogo elemento) {
		this.elemento = elemento;
	}
	
	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}
	
	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}
	
	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}
	
	public void setRestituzionePrevista(LocalDate restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista.plusDays(30);
	}
	
	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}
	
	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
	public Long getNumPrestito() {
		return numPrestito;
	}
	
	@Override
	public String toString() {
		return "Prestito [numPrestito=" + numPrestito + ", utente=" + utente + ", elemento=" + elemento
				+ ", inizioPrestito=" + inizioPrestito + ", restituzionePrevista=" + restituzionePrevista
				+ ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}

}
