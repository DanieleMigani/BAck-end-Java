package it.w07.d05.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Comunicazione extends CanaleComunicazione {
	private static final Logger logger = LoggerFactory.getLogger(Comunicazione.class);
	private String baseurlnotification;

	public Comunicazione(String baseurlnotification) {

		this.baseurlnotification = baseurlnotification;
	}

	public void sendGet(Long sensorId, double latitudine, double longitudine, int livelloFumi) {
		logger.info("Allarme sonda:{} - latitudine: {} longitudine: {} - Livello fumo: {}", sensorId, latitudine, longitudine, livelloFumi);

		String url = baseurlnotification + "?sensorid=" + sensorId + "&latitudine=" + latitudine + "&longitudine" + longitudine + "&livelloFumi="
				+ livelloFumi;
		logger.info("Call: {}", url);
	}

}
