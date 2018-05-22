package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlWeighed {
	
	@Test
	@DisplayName("Test few arguments mentionsListWeighed")
	void badMentionsWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListWeighed"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments mentionsListWeighed")
	void badMentionsChannelWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListChannelWeighed"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test mentionsListWeighed Control")
	void badWorkspaceMentionsWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListWeighed","res/file/tet.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test mentionsListWeighed Control")
	void goodWorkspaceMentionsWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListWeighed","res/file/test.zip"});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel good workspace mentionsListWeighed Control")
	void badChannelgoodWorkspaceMentionsChannelWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListChannelWeighed","wrn","res/file/test.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel good workspace mentionsListWeighed Control")
	void goodChannelgoodWorkspaceMentionsChannelWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListChannelWeighed","bernerslee","res/file/test.zip"});
		assertTrue(control.showRequest());
	}

}
