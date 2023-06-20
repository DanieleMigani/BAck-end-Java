package gestione_dispositivi.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import gestione_dispositivi.model.Utente;

public interface UtenteDaoRepository
		extends CrudRepository<Utente, Long>, PagingAndSortingRepository<Utente, Long> {
	
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
	Optional<Utente> findByEmail(String email);
	Optional<Utente> findByUsername(String username);

}
