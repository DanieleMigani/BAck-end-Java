package it.w07.d05.model;

public class CentroDiControlloFactory {
	
	public static CentroDiControlloInterface createCtrlCenter() {
		return new CentroDiControllo();
	}

}
