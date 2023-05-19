package model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rivista")
public class Rivista extends Elemento_Catalogo{
	
	@Enumerated(EnumType.STRING)
	private Periodicità periodicità;

	public Periodicità getPeriodicità() {
		return periodicità;
	}

	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [periodicità=" + periodicità + "]";
	}

}
