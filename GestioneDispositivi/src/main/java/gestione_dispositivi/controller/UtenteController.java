package gestione_dispositivi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gestione_dispositivi.model.Utente;
import gestione_dispositivi.service.UtenteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllDevices(Pageable pageable) {
		return new ResponseEntity<>(utenteService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(utenteService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createDevice(@RequestBody Utente u) {
		return new ResponseEntity<>(utenteService.salvaUtente(u), HttpStatus.CREATED);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateDevice(@RequestBody Utente u) {
		return new ResponseEntity<>(utenteService.aggiornaUtente(u), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(utenteService.rimuoviUtente(id), HttpStatus.OK);
	}

}
