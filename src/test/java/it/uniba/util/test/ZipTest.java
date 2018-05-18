package it.uniba.util.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.util.ZipReader;

public class ZipTest {
	
	@Test
	@DisplayName("Test zip")
	void Zip() {
		ZipReader zip = new ZipReader();
		List<String> conversations = new ArrayList<>();
		conversations.add("micali/2018-03-12.json");
		try {
			assertNotNull(zip.setUsersFile("res/file/test.zip"));
			assertNotNull(zip.setChannelsFile("res/file/test.zip"));
			assertNotNull(zip.setConversationFile("bernerslee","res/file/test.zip"));
			assertNotNull(zip.setConversationFile("res/file/test.zip"));
			assertNotNull(zip.getJSONFromFile("res/file/test.zip","bernerslee/2018-03-13.json"));
		} catch (IOException i) {
			System.out.println("fail");
		}
		//Now test a file zip not valid
		assertThrows(IOException.class,() -> {zip.setUsersFile("res/file/test2.zip");});
		assertThrows(IOException.class,() -> {zip.setChannelsFile("res/file/test2.zip");});
		assertThrows(IOException.class,() -> {zip.setConversationFile("ciao.zip");});
	}

}
