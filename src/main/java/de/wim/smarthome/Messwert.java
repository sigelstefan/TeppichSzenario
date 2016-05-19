package de.wim.smarthome;

import org.apache.commons.lang3.StringUtils;

public class Messwert {

	private Teppich teppich; // die ersten 3 Werte
	private Modul modul; // Werte 4 & 5
	private String unbekannt; // Wert 6 - irgendein counter oder so
	private String unbekanntKonstant; // Werte 7, 8, 9 ;; 0,17,0
	private String TBDkapazitaet; // Gewicht oder so - die letzten 8? Werte

	public Messwert(String inputString) {
		String cleanedInputString = cleanInputString(inputString);
		String[] values = StringUtils.split(cleanedInputString, ",");
		
		short[] values12und3 = getValues(values, 0, 3);
		this.teppich = new Teppich(values12und3);
		
		short[] values4und5 = getValues(values, 4, 2);
		this.modul = new Modul( values4und5);
	}

	private short[] getValues(String[] values, int startValue, int length) {
		short[] relevantValues = new short[length];
		for (int i = startValue; i < length; i++) {
			relevantValues[i] = Short.valueOf(values[i]);
		}
		return relevantValues;
	}
	
	private String cleanInputString( String inputString) {
		inputString = StringUtils.remove(inputString, "{[");
		inputString = StringUtils.remove(inputString, "]}");
		
		return inputString;
	}

	public Teppich getTeppichIdentifier() {
		return teppich;
	}

	public Modul getModulIdentifier() {
		return modul;
	}

	public String getUnbekannt() {
		return unbekannt;
	}

	public String getUnbekanntKonstant() {
		return unbekanntKonstant;
	}

	public String getTBDkapazitaet() {
		return TBDkapazitaet;
	}

	@Override
	public String toString() {
		return "Messwert [teppichIdentifier=" + teppich + ", modulIdentifier=" + modul
				+ ", unbekannt=" + unbekannt + ", unbekanntKonstant=" + unbekanntKonstant + ", TBDkapazitaet="
				+ TBDkapazitaet + "]";
	}
}