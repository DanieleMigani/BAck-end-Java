package gestione_dispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dipositivi")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipoDispositivo;

	@Enumerated(EnumType.STRING)
	private StatoDispositivo statoDispositivo;

	@ManyToOne
	@JsonIgnoreProperties({ "dipositivo" })
	private Utente utente;

}
