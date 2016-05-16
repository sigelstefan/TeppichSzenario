package de.wim.smarthome;

public class TeppichIdentifier {
	
	private byte[] bytes = new byte[3];
	
	public TeppichIdentifier( byte val1, byte val2, byte val3) {
		bytes[0] = val1;
		bytes[1] = val2;
		bytes[2] = val3;
	}
	
	public String getStringId() {
		return "" + bytes[0] + bytes[1] + bytes[2];
	}
}