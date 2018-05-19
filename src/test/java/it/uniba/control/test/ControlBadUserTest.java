package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlBadUserTest {
	
	static String workspace = "res/file/test.zip";
	static String mentionsListFrom = "mentionsListFrom";
	
	@Test
	@DisplayName("Test bad user bad channel bad workspace mentionsListTo Control") 
	void tripleBadMentionsTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo","wronguser","wrongchannel","wrongzip.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user good channel mentionsListTo Control") 
	void badMentionsGoodChannelTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo","wrongme","bernerslee",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListTo Control") 
	void badMentionsTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo","me",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListTo Control") 
	void badMentionsFrom() {
		final Controller control = new Controller(new String[] {mentionsListFrom,"me",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user bad channel bad workspace mentionsListTo Control") 
	void tipleBadMentionsFrom() {
		final Controller control = new Controller(new String[] {mentionsListFrom,"wronguser","wrongchannel","wrongzip.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user bad channel mentionsListTo Control") 
	void doubleBadMentionsFrom() {
		final Controller control = new Controller(new String[] {mentionsListFrom,"wrongme","wrongchannel",workspace});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad user mentionsListTo Control") 
	void badMentionsGoodChannelFrom() {
		final Controller control = new Controller(new String[] {mentionsListFrom,"wrongme","bernerslee",workspace});
		assertFalse(control.showRequest());
	}

}
