package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedFromTest {
	
	@Test
	@DisplayName("Test good workspace mentionsListFromWeighed")
	void goodFromWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","ulisse1996","res/file/test.zip"});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListFromWeighed")
	void goodWorkspaceBadUserFromWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","uliss1996","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListFromWeighed")
	void badFromWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","ulisse1996","res/file/tst.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListFromWeighed")
	void goodFromChannelWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","ulisse1996","bernerslee","res/file/test.zip"});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListFromWeighed")
	void goodWorkspaceBadUserFromChannelWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","uliss1996","bernerslee","res/file/test.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListFromWeighed")
	void badFromChannelWeighed() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed","ulisse1996","bernerslee","res/file/tst.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad arguments mentionsListFromWeighed")
	void noArguments() {
		final Controller request = new Controller(new String[] {"mentionsListFromWeighed"});
		assertFalse(request.showRequest());
	}
}
