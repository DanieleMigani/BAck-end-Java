package gestione_dispositivi.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import gestione_dispositivi.model.Dispositivo;
import gestione_dispositivi.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Value("${user.admin.username}")
	private String adminNomeUtente;
	@Value("${user.admin.name}")
	private String adminNome;
	@Value("${user.admin.name}")
	private String adminCognome;
	@Value("${user.admin.email}")
	private String adminEmail;
	@Value("${user.admin.password}")
	private String adminPassword;

	@Bean("UtenteAdmin")
	@Scope("singleton")
	public Utente nuovoUtenteAdmin() {
		return Utente.builder().username(adminNomeUtente).nome(adminNome).cognome(adminCognome).email(adminEmail)
				.build();
	}

	@Bean("NuovoUtente")
	@Scope("prototype")
	public Utente nuovoUtente(String username, String nome, String cognome, String email, Dispositivo dispositivo) {
		return new Utente(null, username, nome, cognome, email, null);
	}

	@Bean("FakeUtente")
	@Scope("prototype")
	public Utente fakeUtente() {
		Faker fake = new Faker(new Locale("it-IT"));
		Utente u = new Utente();
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setUsername(u.getNome() + "_" + u.getCognome());
		u.setEmail(u.getNome() + "." + u.getCognome() + "@example.com");
		return u;
	}

}
