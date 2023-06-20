package gestione_dispositivi.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import gestione_dispositivi.model.Utente;
import gestione_dispositivi.repository.DispositivoDaoRepository;
import gestione_dispositivi.repository.UtenteDaoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	@Autowired
	private UtenteDaoRepository utenteRepo;

	@Autowired
	private DispositivoDaoRepository dipositivoRepo;

	@Autowired
	@Qualifier("FakeUtente")
	private ObjectProvider<Utente> fakeUtenteProvider;

	public Utente salvaUtente(Utente u) {
		if (utenteRepo.existsByEmail(u.getEmail()) || utenteRepo.existsByUsername(u.getUsername())) {
			throw new EntityExistsException("Username o Email già estenti!");
		}
		utenteRepo.save(u);
		return u;
	}

	public void salvaFakeUtente() {
		Utente u = fakeUtenteProvider.getObject();
		salvaUtente(u);
	}

	public String rimuoviUtente(Long id) {
		if (!utenteRepo.existsById(id)) {
			throw new EntityNotFoundException("L'UTENTE cercato è inesistente!");
		}
		if (dipositivoRepo.findByUtente(utenteRepo.findById(id).get()).size() > 0) {
			throw new EntityExistsException(
					"L'UTENTE non può essere eliminato dal DB in quanto ha un dipositivo assegnato!");
		}
		utenteRepo.deleteById(id);
		return "UTENTE eliminato dal DB!";
	}

	public Utente aggiornaUtente(Utente u) {
		if (!utenteRepo.existsById(u.getId())) {
			throw new EntityNotFoundException("Non si può aggiornare un UTENTE inesistente!");
		}
		utenteRepo.save(u);
		u.setDispositivo(dipositivoRepo.findByUtente(u));
		return u;
	}

	public Utente findById(Long id) {
		if (!utenteRepo.existsById(id)) {
			throw new EntityNotFoundException("ID UTENTE inesistente!");
		}
		return utenteRepo.findById(id).get();
	}

	public Utente findByEmail(String email) {
		if (!utenteRepo.existsByEmail(email)) {
			throw new EntityNotFoundException("EMAIL UTENTE inesistente!");
		}
		return utenteRepo.findByEmail(email).get();
	}

	public Utente findByUsername(String username) {
		if (!utenteRepo.existsByUsername(username)) {
			throw new EntityNotFoundException("USERNAME UTENTE inesistente!");
		}
		return utenteRepo.findByUsername(username).get();
	}

	public Page<Utente> findAll(Pageable pageable) {
		return (Page<Utente>) utenteRepo.findAll(pageable);
	}

}
