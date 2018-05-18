package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

public class TestControl {
	
	@Test
	@DisplayName("Test Control") 
	void Control(){
		Controller control = new Controller(new String[] {"prova"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersList"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersList","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"membersList","ciao"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"channelsList"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"channelsList","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"channelsList","ciao"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersSortedByChannel"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersSortedByChannel","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"membersSortedByChannel","ciao"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersChannel"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersChannel","bernerslee","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"membersChannel","berne","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"membersChannel","bernerslee","test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsList"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsList","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"mentionsList","test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListChannel"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListChannel","bernerslee","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"mentionsListChannel","berneslee","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","ulisse1996","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","me","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","me","test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","wronguser","wrongchannel","wrongzip.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","wrongme","wrongchannel","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","wrongme","wrongchannel","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","wrongme","bernerslee","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListFrom","ulisse1996","bernerslee","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","ulisse1996","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","me","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","me","test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","wronguser","wrongchannel","wrongzip.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","wrongme","wrongchannel","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","wrongme","wrongchannel","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","wrongme","bernerslee","res/file/test.zip"});
		assertFalse(control.showRequest());
		control = new Controller(new String[] {"mentionsListTo","ulisse1996","bernerslee","res/file/test.zip"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"sna4slack"});
		assertTrue(control.showRequest());
		control = new Controller(new String[] {"sna4slack","noneed"});
		assertFalse(control.showRequest());
		
	}

}
