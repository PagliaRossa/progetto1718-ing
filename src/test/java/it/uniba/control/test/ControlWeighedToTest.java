package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedToTest {
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed")
	void goodToWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","ulisse1996","0","res/file/test.zip"});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed with some over out")
	void goodToWeighedOver() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","Lanubile","3","res/file/test.zip"});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListToWeighed")
	void badToWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","Lanubile","3","res/file/tet.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed")
	void goodToChannelWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","ulisse1996","bernerslee","0","res/file/test.zip"});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace bad channel mentionsListToWeighed")
	void ToWeighedbadChannelOver() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","Lanubile","bers","3","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListToWeighed")
	void badToChannelWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","Lanubile","3","res/file/tet.zip"});
		assertFalse(request.showRequest());
	}

}
