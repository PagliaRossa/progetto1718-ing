package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedToFalseTest {
	
	static String command = "mentionsListToWeighed";
	static String goodworkspace = "res/file/test.zip";
	
	@Test
	@DisplayName("Test bad arguments mentionsListToWeighed")
	void noArguments() {
		final Controller request = new Controller(new String[] {command});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListToWeighed")
	void badUser() {
		final Controller request = new Controller(new String[] {command,"us",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user good channel mentionsListToWeighed")
	void badUserChannel() {
		final Controller request = new Controller(new String[] {command,"us","bernerslee",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListToWeighed")
	void badNumber() {
		final Controller request = new Controller(new String[] {command,"us",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user good channel mentionsListToWeighed")
	void badNumberChannel() {
		final Controller request = new Controller(new String[] {command,"us","bernerslee",goodworkspace});
		assertFalse(request.showRequest());
	}

}
