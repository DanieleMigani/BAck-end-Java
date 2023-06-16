package it.w07.d05.model;

public class CentroDiControlloProxy implements CentroDiControlloInterface{
	
	private CentroDiControlloInterface Interface;

	public CentroDiControlloProxy () {
		Interface = CentroDiControlloFactory.createCtrlCenter();
	}
	
	@Override
	public void controlloFumi(InfoSensori sensorInfo) {

		Interface.controlloFumi(sensorInfo);
	}

}