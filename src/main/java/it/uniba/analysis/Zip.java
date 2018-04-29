package it.uniba.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

class Zip {
	
	@SuppressWarnings("deprecation")
	String setUsersFile(String input) {
		String json = new String();
		String zipUrl = input.substring(10);
		try {
			ZipFile zip = new ZipFile(zipUrl);
			InputStream source = zip.getInputStream(zip.getEntry("users.json"));
			json = IOUtils.toString(source);
			zip.close();
		}catch(IOException e) {
			System.out.println("File not found");
		}
		return json;
	}
	
	@SuppressWarnings("deprecation")
	String setChannelFile(String input) {
		String json = new String();
		String zipUrl = input.substring(13);
		try {
			ZipFile zip = new ZipFile(zipUrl);
			InputStream source = zip.getInputStream(zip.getEntry("channels.json"));
			json = IOUtils.toString(source);
			zip.close();
		}catch(IOException e) {
			System.out.println("File not found");
		}
		return json;
	}
}
