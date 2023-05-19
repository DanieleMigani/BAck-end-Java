package JPA_util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
	
public class JpaUtil {
		
	private static final EntityManagerFactory emf;
		
	static {
		try {
			emf = Persistence.createEntityManagerFactory("U1-W3-D5");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
		
	public static EntityManagerFactory getEmf() {
		return emf;
	}

	
}
