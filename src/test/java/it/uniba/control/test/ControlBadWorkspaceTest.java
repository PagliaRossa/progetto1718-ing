package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlBadWorkspaceTest {

	@Test
	@DisplayName("Test bad workspace membersList Control") 
	void badMembers() {
		final Controller control = new Controller(new String[] {"membersList","bad.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace channelsList Control") 
	void badChannels() {
		final Controller control = new Controller(new String[] {"channelsList","cio.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsList Control") 
	void badMentions() {
		final Controller control = new Controller(new String[] {"mentionsList","test3.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListChannel Control") 
	void badMentionsChannel() {
		final Controller control = new Controller(new String[] {"mentionsListChannel","imbad.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListFrom Control") 
	void badMentionsFrom() {
		final Controller control = new Controller(new String[] {"mentionsListFrom","me","te3st.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace mentionsListTo Control") 
	void badMentionsTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo","me","t3est.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace membersChannel Control") 
	void badMembersChannel() {
		final Controller control = new Controller(new String[] {"membersChannel","bernerslee","test.zip"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test bad workspace membersSortedByChannel Control")
	void badSorted() {
		final Controller control = new Controller(new String[] {"membersSortedByChannel","ciao"});
		assertFalse(control.showRequest());
	}
}
