package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import JPA_util.JpaUtil;
import model.Elemento_Catalogo;
import model.Libro;
import model.Prestito;
import model.Rivista;
import model.Utente;

public class Archivio {
	
	static EntityManager em = JpaUtil.getEmf().createEntityManager();
	
	public static void aggiungiLibro(Libro l) {
		try {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void aggiungiRivista(Rivista r) {
		try {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void rimuoviElementoISBN(Long i) {
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("RimuoviByISBN");
			q.setParameter("codice", i);
			q.executeUpdate();
			em.getTransaction().commit();
			System.out.println("Rimosso");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static Elemento_Catalogo trovaElementoISBN(Long i) {
		Query q = em.createNamedQuery("ElementoByISBN");
		q.setParameter("codice", i);
		return (Elemento_Catalogo) q.getSingleResult();
	}
	
	public static List<Elemento_Catalogo> trovaElementoAnno(String a) {
		Query q = em.createNamedQuery("ElementiByAnno");
		q.setParameter("anno", a);
		return q.getResultList();
	}
	
	public static List<Libro> trovaElementoAutore(String a) {
		Query q = em.createNamedQuery("LibriByAutore");
		q.setParameter("au", a);
		return q.getResultList();
	}
	
	public static List<Elemento_Catalogo> trovaElementoTitolo(String a) {
		Query q = em.createNamedQuery("ElementoByTitolo");
		q.setParameter("tit", a);
		return q.getResultList();
	}
	
	public static void aggiungiUtente(Utente u) {
		try {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void presta(Prestito p) {
		try {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Aggiunto");
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
