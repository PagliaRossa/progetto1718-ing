package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighedFromTest {
	
	static private String mentionsFrom = "mentionsListFromWeighed";
	static private String member = "ulisse1996";
	static private String goodworkspace = "res/file/test.zip";
	
	@Test
	@DisplayName("Test good workspace mentionsListFromWeighed")
	void goodFromWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,member,goodworkspace});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace bad user mentionsListFromWeighed")
	void goodWorkspaceBadUserFromWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,"ysls",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListFromWeighed")
	void badFromWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,member,"res/file/tst.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace for channel mentionsListFromWeighed")
	void goodFromChannelWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,member,"bernerslee",goodworkspace});
		assertTrue(request.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace bad user for channel mentionsListFromWeighed")
	void goodWorkspaceBadUserFromChannelWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,"uylis","bernerslee",goodworkspace});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace for channel mentionsListFromWeighed")
	void badFromChannelWeighed() {
		final Controller request = new Controller(new String[] {mentionsFrom,member,"bernerslee","res/file/tst.zip"});
		assertFalse(request.showRequest());
	}
	
	@Test
	@DisplayName("Test bad arguments mentionsListFromWeighed")
	void noArguments() {
		final Controller request = new Controller(new String[] {mentionsFrom});
		assertFalse(request.showRequest());
	}
}
