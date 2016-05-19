package de.wim.smarthome;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeppichTests {

	@Test
	public void testGrosserTeppich() {
		Messwert m1 = new Messwert( "{[253,2,240,5,2,88,0,17,0,129,127,128,128,127,152,128,127]}");
		assertEquals(TeppichType.GROSSER_TEPPICH, m1.getTeppichIdentifier().getTeppichType());
	}
	
	@Test
	public void testKleinerTeppich() {
		Messwert m1 = new Messwert( "{[253,2,242,1,1,251,48,17,0,127,127,127,127,127,127,127,127]}");
		assertEquals(TeppichType.KLEINER_TEPPICH, m1.getTeppichIdentifier().getTeppichType());
	}
	
	@Test
	public void testGleichesModulGleicherTeppich() {
		fail(); //FIXME: yet to implement
	}
	
	@Test
	public void testGleichesModulUnterschTeppich() {
		fail(); //FIXME: yet to implement
	}

}
