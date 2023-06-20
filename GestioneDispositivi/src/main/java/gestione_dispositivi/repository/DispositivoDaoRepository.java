package gestione_dispositivi.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import gestione_dispositivi.model.Dispositivo;
import gestione_dispositivi.model.StatoDispositivo;
import gestione_dispositivi.model.TipoDispositivo;
import gestione_dispositivi.model.Utente;

public interface DispositivoDaoRepository
		extends CrudRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo, Long> {
	
	Page<Dispositivo> findByStatoDispositivo(StatoDispositivo statoDispositivo, Pageable pageable);
	Page<Dispositivo> findByTipo(TipoDispositivo tipoDispositivo, Pageable pageable);
	List<Dispositivo> findByUtente(Utente utente);

}
