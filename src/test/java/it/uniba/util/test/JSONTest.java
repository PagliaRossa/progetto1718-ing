package it.uniba.util.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.util.JSONReader;
import it.uniba.util.ZipReader;

@SuppressWarnings("PMD.TooManyStaticImports")
public class JSONTest {
	
	static String fail = "fail";
	
	@Test
	@DisplayName("Test setMembers json")
	void members() {
		final JSONReader json = new JSONReader();
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(json.setMembers(zip.setUsersFile("res/file/test.zip")));
		} catch (ParseException p) {
			System.out.println(fail);
		} catch (IOException i) {
			System.out.println(fail);
		}
	}
	
	@Test
	@DisplayName("Test setChannelsFile json")
	void channels() {
		final JSONReader json = new JSONReader();
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(json.setChannels(zip.setChannelsFile("res/file/test.zip")));
		} catch (ParseException p) {
			System.out.println(fail);
		} catch (IOException i) {
			System.out.println(fail);
		}
	}
	
	@Test
	@DisplayName("Test random file json")
	void randomfile() {
		final JSONReader json = new JSONReader();
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(json.setMentions(zip.getJSONFromFile("res/file/test.zip","bernerslee/2018-03-13.json")));
		} catch (ParseException p) {
			System.out.println(fail);
		} catch (IOException i) {
			System.out.println(fail);
		}
	}

}
