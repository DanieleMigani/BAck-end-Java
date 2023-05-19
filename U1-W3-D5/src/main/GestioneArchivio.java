package main;

import java.util.List;

import Dao.Archivio;
import model.Elemento_Catalogo;
import model.Libro;
import model.Periodicità;
import model.Prestito;
import model.Rivista;
import model.Utente;

public class GestioneArchivio {

	public static void main(String[] args) {
		
		Rivista r = new Rivista();
		r.setPeriodicità(Periodicità.MENSILE);
		r.setAnnoPubblicazione("2020");
		r.setNumPagine(18);
		r.setTitolo("Cucina stagionale");
		
		Libro l = new Libro();
		l.setAnnoPubblicazione("2010");
		l.setAutore("Federica G.");
		l.setGenere("commedia");
		l.setNumPagine(310);
		l.setTitolo("Il mostro sotto il letto a Gardaland");
		
		Utente u = new Utente();
		u.setCognome("Neri");
		u.setNome("Federica");
		u.setDataNascita("04/05/1993");
		
		Prestito p = new Prestito();
		p.setElemento(l);
		p.setUtente(u);
		p.setInizioPrestito(2023/02/05);
		
		//Archivio.aggiungiUtente(u);
		//Archivio.aggiungiLibro(l);
		//Archivio.aggiungiRivista(r);
		
		//List<Elemento_Catalogo> el = Archivio.trovaElementoTitolo("% mostro %");
		//System.out.println(el);
		//Archivio.rimuoviElementoISBN(3L);
		

	}

}
