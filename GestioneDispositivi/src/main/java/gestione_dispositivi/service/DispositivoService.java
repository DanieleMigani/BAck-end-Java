package gestione_dispositivi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import gestione_dispositivi.model.Dispositivo;
import gestione_dispositivi.model.StatoDispositivo;
import gestione_dispositivi.model.TipoDispositivo;
import gestione_dispositivi.repository.DispositivoDaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {

	@Autowired
	private static DispositivoDaoRepository dipositivoRepo;

	public Dispositivo salveDispositivo(Dispositivo d) {
		dipositivoRepo.save(d);
		return d;
	}

	public static void rimuoviDispositivo(Long id) {
		if (!dipositivoRepo.existsById(id)) {
			throw new EntityNotFoundException("Non si può eliminare un DISPOSITIVO inesistente!");
		}
		dipositivoRepo.deleteById(id);
		System.out.println("DISPOSITIVO eliminato dal DB!");
	}

	public Dispositivo aggiornaDispositivo(Dispositivo d) {
		if (!dipositivoRepo.existsById(d.getId())) {
			throw new EntityNotFoundException("Non si può aggiornare un DISPOSITIVO inesistente!");
		}
		dipositivoRepo.save(d);
		return d;
	}

	public Dispositivo findById(Long id) {
		if (!dipositivoRepo.existsById(id)) {
			throw new EntityNotFoundException("Il DISPOSITIVO cercate è inesistente!");
		}
		return dipositivoRepo.findById(id).get();
	}

	public Page<Dispositivo> findAll(Pageable pageable) {
		return (Page<Dispositivo>) dipositivoRepo.findAll(pageable);
	}

	public Page<Dispositivo> findByStatoDispositivo(StatoDispositivo statoDispositivo, Pageable pageable) {
		return (Page<Dispositivo>) dipositivoRepo.findByStatoDispositivo(statoDispositivo, pageable);
	}

	public Page<Dispositivo> findByTipo(TipoDispositivo tipoDispositivo, Pageable pageable) {
		return (Page<Dispositivo>) dipositivoRepo.findByTipo(tipoDispositivo, pageable);
	}

}
