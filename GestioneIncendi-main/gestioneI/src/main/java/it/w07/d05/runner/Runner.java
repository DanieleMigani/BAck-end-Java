package it.w07.d05.runner;

import it.w07.d05.model.CentroDiControlloProxy;
import it.w07.d05.model.Sensori;
import it.w07.d05.model.ControlloSensori;

public class Runner {

	private static CentroDiControlloProxy centroControllo;

	private static ControlloSensori Cs1;
	private static ControlloSensori Cs2;

	public static void main(String[] args) {

		Sensori s1 = new Sensori(01l, 432, 492);
		Sensori s2 = new Sensori(02l, 457, 518);
		s1.setLivelloFumi(5);
		s2.setLivelloFumi(5);

		centroControllo = new CentroDiControlloProxy();
		Cs1 = new ControlloSensori(1l, centroControllo);
		Cs2 = new ControlloSensori(2l, centroControllo);

		s1.addObserver(Cs1);
		s2.addObserver(Cs2);

		if (s1.getLivelloFumi() > s1.smokeLimit) {
			System.out.println("incendio al sensore numero 1");
			Cs1.update(s1);
		} else if (s2.getLivelloFumi() > s2.smokeLimit) {
			System.out.println("incendio al sensore numero 2");
			Cs2.update(s2);
		}

	}

}