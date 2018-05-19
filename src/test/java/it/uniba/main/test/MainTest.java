package it.uniba.main.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.main.AppMain;


@SuppressWarnings("PMD.tooManyStaticImports")
public class MainTest {
	
	@Test
	@DisplayName("Test main fail")
	void mainFail() {
		assertFalse(AppMain.checkBoolean(new String[0]));
	}
	
	@Test
	@DisplayName("Test main check true")
	void mainCheck() {
		final String[] test = {"membersList","res/file/test.zip"};
		AppMain.main(test);
		assertTrue(AppMain.check);
	}

}
