package it.w07.d05.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensori extends Subject{
	
	private Long id;
	private double latitudine;
	private double longitudine;
	private int livelloFumi;
	
	public final int smokeLimit = 5;

	public Sensori(Long id, double lat, double lon) {
		super();
		this.id = id;
		this.latitudine = lat;
		this.longitudine = lon;
		livelloFumi = 0;
	}
	
	public int getLivelloFumi() {
		return livelloFumi;
	}
	
	public void setLivelloFumi(int livelloFumi) {
		this.livelloFumi = livelloFumi;
		
		if (livelloFumi >= smokeLimit) {
			super.alertObservers();
		}
	}

}
