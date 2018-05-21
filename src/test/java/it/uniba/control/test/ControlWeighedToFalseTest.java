package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedToFalseTest {
	
	@Test
	@DisplayName("Test bad arguments mentionsListToWeighed")
	void noArguments() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListToWeighed")
	void badUser() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","us","3","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user good channel mentionsListToWeighed")
	void badUserChannel() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","us","bernerslee","3","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListToWeighed")
	void badNumber() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","us","-1","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user good channel mentionsListToWeighed")
	void badNumberChannel() {
		final Controller request = new Controller(new String[] {"mentionsListToWeighed","us","bernerslee","-3","res/file/test.zip"});
		assertFalse(request.showRequest());
	}

}
