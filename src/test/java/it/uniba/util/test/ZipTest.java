package it.uniba.util.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.util.ZipReader;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ZipTest {
	
	static String goodWorkspace = "res/file/test.zip";
	static String fail = "fail";
	
	@Test
	@DisplayName("Test a good users file zip")
	void goodUsers() {
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(zip.setUsersFile(goodWorkspace));
		} catch (IOException i) {
			System.out.print(fail);
		}
	}
	
	@Test
	@DisplayName("Test a good channels filezip")
	void goodChannels() {
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(zip.setChannelsFile(goodWorkspace));
		} catch (IOException i) {
			System.out.print(fail);
		}
	}
	
	@Test
	@DisplayName("Test a good conversations list in channel zip")
	void goodConversationsGoodChannel() {
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(zip.setConversationFile("bernerslee",goodWorkspace));
		} catch (IOException i) {
			System.out.print(fail);
		}
	}
	
	@Test
	@DisplayName("Test a good conversations list zip")
	void goodConversations() {
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(zip.setConversationFile(goodWorkspace));
		} catch (IOException i) {
			System.out.print(fail);
		}
	}
	
	@Test
	@DisplayName("Test a good json file zip")
	void goodJSON() {
		final ZipReader zip = new ZipReader();
		try {
			assertNotNull(zip.getJSONFromFile(goodWorkspace,"bernerslee/2018-03-13.json"));
		} catch (IOException i) {
			System.out.print(fail);
		}
	}
	
	@Test
	@DisplayName("Test ioexceptio for users zip")
	void exceptionUsers() {
		final ZipReader zip = new ZipReader();
		assertThrows(IOException.class,() -> {zip.setUsersFile("res/file/test2.zip");});
	}
	
	@Test
	@DisplayName("Test ioexception for channels zip")
	void exceptionChannels() {
		final ZipReader zip = new ZipReader();
		assertThrows(IOException.class,() -> {zip.setChannelsFile("res/file/test2.zip");});
	}
	
	@Test
	@DisplayName("Test ioexception for conversations zip")
	void exceptionConversations() {
		final ZipReader zip = new ZipReader();
		assertThrows(IOException.class,() -> {zip.setConversationFile("ciao.zip");});
	}

}
