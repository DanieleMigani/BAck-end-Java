package gestione_dispositivi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gestione_dispositivi.model.Dispositivo;
import gestione_dispositivi.model.StatoDispositivo;
import gestione_dispositivi.service.DispositivoService;
import gestione_dispositivi.service.UtenteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

	@Autowired
	DispositivoService dispositivoService;

	@Autowired
	UtenteService utenteService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllDevices(Pageable pageable) {
		return new ResponseEntity<>(dispositivoService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(dispositivoService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/stato_dispositivo/{stato}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getStatusDevices(@PathVariable(name = "stato") String stato, Pageable pageable) {
		return new ResponseEntity<>(
				dispositivoService.findByStatoDispositivo(StatoDispositivo.valueOf(stato.toUpperCase()), pageable),
				HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createDevice(@RequestBody Dispositivo d) {
		return new ResponseEntity<>(dispositivoService.salveDispositivo(d), HttpStatus.CREATED);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateDevice(@RequestBody Dispositivo d) {
		if (!d.getStatoDispositivo().equals(StatoDispositivo.ASSEGNATO)) {
			d.setUtente(null);
		}
		return new ResponseEntity<>(dispositivoService.aggiornaDispositivo(d), HttpStatus.OK);
	}

}
