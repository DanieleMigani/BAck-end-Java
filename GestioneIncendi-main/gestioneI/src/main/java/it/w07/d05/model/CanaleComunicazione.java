package it.w07.d05.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CanaleComunicazione {

	private static final Logger logger = LoggerFactory.getLogger(CanaleComunicazione.class);

	public void invioInfo(Long id, double latitudine, double longitudine, int livelloFumi) {
		logger.info("La sonda " + id + " Coordinate: [" + latitudine + ","
				+ longitudine + "]" + " rileva un livello di fumo pari a: " + livelloFumi );
	}

}
