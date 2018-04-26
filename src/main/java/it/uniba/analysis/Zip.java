package it.uniba.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

class Zip {
	
	@SuppressWarnings("deprecation")
	String setUsersFile(String zipUrl) {
		String json = new String();
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
}
