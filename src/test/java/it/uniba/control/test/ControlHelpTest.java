package it.uniba.control.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.control.Controller;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ControlHelpTest {

	@Test
	@DisplayName("Test sna4slack help Control") 
	void goodHelp(){
		final Controller control = new Controller(new String[] {"sna4slack"});
		assertTrue(control.showRequest());
	}
	
	@Test
	@DisplayName("Test lot of arguments membersList Control") 
	void badHelp(){
		final Controller control = new Controller(new String[] {"sna4slack","noneed"});
		assertFalse(control.showRequest());
	}
}
