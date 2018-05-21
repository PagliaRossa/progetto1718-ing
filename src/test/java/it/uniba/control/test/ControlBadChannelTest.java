package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlBadChannelTest {
	
	static String workspace = "res/file/test.zip";
	
	@Test
	@DisplayName("Test bad channel membersChannel Control") 
	void badMembers() {
		final Controller control = new Controller(new String[] {"membersChannel","berne",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel mentionsListChannel Control")
	void badMentions() {
		final Controller control = new Controller(new String[] {"mentionsListChannel","berneslee",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel mentionsListFrom Control")
	void badMentionsFrom() {
		final Controller control = new Controller(new String[] {"mentionsListFrom","wrongme","wrongchannel",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel mentionsListTo Control")
	void badMentionsTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo","wrongme","wrongchannel",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad channel mentionsListWeighed Control")
	void badMentionsChannelWeighed() {
		final Controller control = new Controller(new String[] {"mentionsListChannelWeighed","wrn",workspace});
		assertFalse(control.showRequest());
	}
}
