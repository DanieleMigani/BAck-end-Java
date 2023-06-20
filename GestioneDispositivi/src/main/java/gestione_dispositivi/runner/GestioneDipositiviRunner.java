package gestione_dispositivi.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import gestione_dispositivi.model.Utente;
import gestione_dispositivi.service.DispositivoService;
import gestione_dispositivi.service.UtenteService;

@Component
public class GestioneDipositiviRunner {
	
	@Autowired 
	@Qualifier("UtenteAdmin") 
	ObjectProvider<Utente> adminBeanProvider;
	
	@Autowired 
	@Qualifier("FakeUtente") 
	ObjectProvider<Utente> fakeBeanProvider;
	
	@Autowired 
	UtenteService utenteService;
	
	@Autowired
	DispositivoService dispositivoService;
	
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
	}

}
