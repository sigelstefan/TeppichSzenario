package de.wim.smarthome;

public class Messwert {

	private TeppichIdentifier teppichIdentifier; // die ersten 3 bytes
	private ModulIdentifier modulIdentifier; // byte 4 & 5
	private String unbekannt; // byte 6 - irgendein counter oder so
	private String unbekanntKonstant; // byte 7, 8, 9 ;; 0,17,0
	private String TBDkapazitaet; // Gewicht oder so - die letzten 8? bytes

	int i = 0;

	public Messwert(String inputString) {
		System.out.println("Messwert " + ++i + inputString);
	}

}