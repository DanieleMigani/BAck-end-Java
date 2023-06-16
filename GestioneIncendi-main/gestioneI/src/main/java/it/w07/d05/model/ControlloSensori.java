package it.w07.d05.model;

public class ControlloSensori implements Observer {

	private final Long id;

	private CentroDiControlloInterface centroControllo;

	public ControlloSensori(Long id, CentroDiControlloInterface centroCon) {
		this.id = id;
		this.centroControllo = centroCon;
	}

	private InfoSensori createSensorInfo(Sensori sensor) {
		return new InfoSensori(sensor.getId(), sensor.getLatitudine(), sensor.getLongitudine(), sensor.getLivelloFumi());
	}

	@Override
	public void update(Subject sensor) {
		InfoSensori info = createSensorInfo((Sensori) sensor);
		centroControllo.controlloFumi(info);
	}

	public Long getId() {
		return id;
	}

}