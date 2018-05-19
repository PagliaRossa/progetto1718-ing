package it.uniba.control.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlGoodWorkspaceTest {
	
	static String workspace = "res/file/test.zip";
	static String member = "ulisse1996";
	static String channel = "bernerslee";
	
	@Test
	@DisplayName("Test good workspace membersList Control") 
	void goodMembersList() {
		final Controller control = new Controller(new String[] {"membersList",workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace channelsList Control") 
	void goodChannelsList() {
		final Controller control = new Controller(new String[] {"channelsList",workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace good channel membersChannel Control")
	void goodChannelMembers() {
		final Controller control = new Controller(new String[] {"membersChannel",channel,workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace membersSortedByChannel Control")
	void goodSorted() {
		final Controller control = new Controller(new String[] {"membersSortedByChannel",workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsList Control")
	void goodMentions() {
		final Controller control = new Controller(new String[] {"mentionsList",workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListChannel Control")
	void goodMentionsChannel() {
		final Controller control = new Controller(new String[] {"mentionsListChannel",channel,workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListFrom Control")
	void goodMentionsFrom() {
		final Controller control = new Controller(new String[] {"mentionsListFrom",member,workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace good channel mentionsListFrom Control")
	void goodMentionFromChannel() {
		final Controller control = new Controller(new String[] {"mentionsListFrom",member,channel,workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace mentionsListTo Control")
	void goodMentionsTo() {
		final Controller control = new Controller(new String[] {"mentionsListTo",member,workspace});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test good workspace good channel mentionsListTo Control")
	void goodMentionsToChannel() {
		final Controller control = new Controller(new String[] {"mentionsListTo",member,channel,workspace});
		assertTrue(control.showRequest());
	}
}
