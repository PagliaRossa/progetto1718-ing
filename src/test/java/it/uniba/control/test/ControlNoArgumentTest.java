package it.uniba.control.test;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlNoArgumentTest {
	
	@Test
	@DisplayName("Test not a good command Control") 
	void badCommand(){
		final Controller control = new Controller(new String[] {"prova"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments membersList Control") 
	void badMembers(){
		final Controller control = new Controller(new String[] {"membersList"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments channelsList Control") 
	void badChannels(){
		final Controller control = new Controller(new String[] {"channelsList"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments membersChannel Control") 
	void badMembersChannel(){
		final Controller control = new Controller(new String[] {"membersChannel"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments membersSortedByChannel Control") 
	void badMembersSorted(){
		final Controller control = new Controller(new String[] {"membersSortedByChannel"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments mentionsList Control") 
	void badMentions(){
		final Controller control = new Controller(new String[] {"mentionsList"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments mentionsListChannel Control") 
	void badMentionsChannel(){
		final Controller control = new Controller(new String[] {"mentionsListChannel"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments mentionsListFrom Control") 
	void badMentionsFrom(){
		final Controller control = new Controller(new String[] {"mentionsListFrom"});
		assertFalse(control.showRequest());
	}
	
	@Test
	@DisplayName("Test few arguments mentionsListTo Control") 
	void badMentionsTo(){
		final Controller control = new Controller(new String[] {"mentionsListTo"});
		assertFalse(control.showRequest());
	}

}
