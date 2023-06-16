package it.w07.d05.model;

import lombok.Data;

@Data
public class InfoSensori {
	private final Long id;
	private final double latitudine;
	private final double longitudine;
	private final int livelloFumi;

}