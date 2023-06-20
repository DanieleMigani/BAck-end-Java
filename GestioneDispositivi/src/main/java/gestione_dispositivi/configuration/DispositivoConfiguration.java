package gestione_dispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import gestione_dispositivi.model.Dispositivo;
import gestione_dispositivi.model.StatoDispositivo;
import gestione_dispositivi.model.TipoDispositivo;

@Configuration
public class DispositivoConfiguration {
	
	@Bean("NuovoDispositivo")
	@Scope("prototype")
	public Dispositivo nuovoDispositivo(TipoDispositivo tipoDispositivo, StatoDispositivo statoDispositivo) {
		return Dispositivo.builder().tipoDispositivo(tipoDispositivo).statoDispositivo(statoDispositivo).build();
	}

}
