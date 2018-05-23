package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedToTest {
	
	static String command = "mentionsListToWeighed";
	static String goodworkspace = "res/file/test.zip";
	static String member = "Lanubile";
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed")
	void goodToWeighed() {
		final Controller request = new Controller(new String[] {command,"ulisse1996",goodworkspace});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed with some over out")
	void goodToWeighedOver() {
		final Controller request = new Controller(new String[] {command,member,goodworkspace});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListToWeighed")
	void badToWeighed() {
		final Controller request = new Controller(new String[] {command,member,"res/file/tet.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListToWeighed")
	void goodToChannelWeighed() {
		final Controller request = new Controller(new String[] {command,"ulisse1996","bernerslee",goodworkspace});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace bad channel mentionsListToWeighed")
	void toWeighedbadChannelOver() {
		final Controller request = new Controller(new String[] {command,member,"bers",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListToWeighed")
	void badToChannelWeighed() {
		final Controller request = new Controller(new String[] {command,member,"res/file/tet.zip"});
		assertFalse(request.showRequest());
	}

}
