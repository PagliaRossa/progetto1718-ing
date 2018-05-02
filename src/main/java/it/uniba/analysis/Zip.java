package it.uniba.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

class Zip {


	@SuppressWarnings("deprecation")
	String setUsersFile(final String input) {
		String json = new String();
		try {
			ZipFile zip = new ZipFile(input);
			InputStream source = zip.getInputStream(zip.getEntry("users.json"));
			json = IOUtils.toString(source);
			zip.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return json;
	}

	@SuppressWarnings("deprecation")
	String setChannelFile(final String input) {
		String json = new String();
		try {
			ZipFile zip = new ZipFile(input);
			InputStream source = zip.getInputStream(zip.getEntry("channels.json"));
			json = IOUtils.toString(source);
			zip.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return json;
	}
}
