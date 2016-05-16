package de.wim.smarthome;

public class ModulIdentifier {

	private byte[] bytes = new byte[2];

	public ModulIdentifier(byte val4, byte val5) {
		bytes[0] = val4;
		bytes[1] = val5;
	}

	public String getStringId() {
		return "" + bytes[0] + bytes[1];
	}
}
