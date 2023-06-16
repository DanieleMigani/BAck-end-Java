package it.w07.d05.model;

public class CentroDiControllo implements CentroDiControlloInterface {

	private Comunicazione comunicazione;

	public CentroDiControllo() {
		this.comunicazione = new Comunicazione(toString());
	}

	@Override
	public void controlloFumi(InfoSensori sensorInfo) {
		comunicazione.invioInfo(sensorInfo.getId(), sensorInfo.getLatitudine(), sensorInfo.getLongitudine(), sensorInfo.getLivelloFumi());
	}

}
