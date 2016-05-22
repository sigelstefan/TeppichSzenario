package de.wim.smarthome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MesswerteManager {

	private static final int ANZAHL_MESSWERTE = 10;

	private List<Messwert> lastMesswerte = new ArrayList<>();

	private boolean isKleinerTeppichLightOn = false;
	private boolean isGrosserTeppichLightOn = false;

	public void addNewMesswert(Messwert newMesswert) {
		if (lastMesswerte.size() >= ANZAHL_MESSWERTE) {
			lastMesswerte.remove(0);
		}
		lastMesswerte.add(newMesswert);
		checkForStuff();
	}

	private void checkForStuff() {
		checkForKleinerTeppich();
		checkForGrosserTeppich();
		checkForSturz();
		checkForTorkeln();
	}

	private void checkForTorkeln() {
		// TODO implement algorithm
	}

	private void checkForSturz() {
		// TODO implement algorithm
	}

	private void checkForGrosserTeppich() {
		if (isGrosserTeppichActive()) {
			if (!isGrosserTeppichLightOn) {
				System.out.println("set Licht grosser Teppich -> ON");
				isGrosserTeppichLightOn = true;
			}
		} else {
			if (isGrosserTeppichLightOn) {
				System.out.println("set Licht grosser Teppich -> OFF");
				isGrosserTeppichLightOn = false;
			}
		}
	}

	private void checkForKleinerTeppich() {
		if (isKleinerTeppichActive()) {
			if (!isKleinerTeppichLightOn) {
				System.out.println("set Licht kleiner Teppich -> ON");
				isKleinerTeppichLightOn = true;
			}
		} else {
			if (isKleinerTeppichLightOn) {
				System.out.println("set Licht kleiner Teppich -> OFF");
				isKleinerTeppichLightOn = false;
			}
		}
	}

	public boolean isKleinerTeppichActive() {
		for (Messwert messwert : lastMesswerte) {
			if (messwert.getTeppichIdentifier().getTeppichType() == TeppichType.KLEINER_TEPPICH) {
				return true;
			}
		}
		return false;
	}

	public boolean isGrosserTeppichActive() {
		for (Messwert messwert : lastMesswerte) {
			if (messwert.getTeppichIdentifier().getTeppichType() == TeppichType.GROSSER_TEPPICH) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int counter = 0;
		MesswerteManager manager = new MesswerteManager();
		String fileName = "D:\\dev\\uml_workspace\\TeppichSzenario\\raw_test_clean.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				Messwert m = new Messwert(line);
				System.out.println("add Messwert " + ++counter);
				manager.addNewMesswert(m);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}