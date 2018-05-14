package it.uniba.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class Zip {
	
	public String setUsersFile(final String input) throws IOException {
		String json = "";
		ZipFile zip = new ZipFile(input);
		if (!(zip.getEntry("users.json") == null)) {
			InputStream source = zip.getInputStream(zip.getEntry("users.json"));
			json = IOUtils.toString(source,"UTF-8");
			zip.close();
		} else {
			zip.close();
			throw new IOException();
		}
		return json;
	}
	
	public String setChannelsFile(final String input) throws IOException {
		String json = "";
		ZipFile zip = new ZipFile(input);
		if (!(zip.getEntry("channels.json") == null)) {
			InputStream source = zip.getInputStream(zip.getEntry("channels.json"));
			json = IOUtils.toString(source,"UTF-8");
			zip.close();
		} else {
			zip.close();
			throw new IOException();
		}
		return json;
	}
	
	public List<String> setConversationFile(final String input) throws IOException {
		List<String> conversations = new ArrayList<>();
		ZipFile zip = new ZipFile(input);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		while (entries.hasMoreElements()) {
			ZipEntry control = entries.nextElement();
			if (!control.isDirectory()) {
				if (!control.getName().equals("users.json") && !control.getName().equals("channels.json") 
						&& !control.getName().equals("integration_logs.json")) {
					conversations.add(control.getName());
				}
			}
		}
		zip.close();
		return conversations;
	}
	
	public List<String> setConversationFile(final String channel,final String path) throws IOException {
		List<String> conversations = new ArrayList<>();
		ZipFile zip = new ZipFile(path);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		while (entries.hasMoreElements()) {
			ZipEntry control = entries.nextElement();
			if (!control.isDirectory()) {
				if (control.getName().contains(channel)) {
					conversations.add(control.getName());
				}
			}
		}
		zip.close();
		return conversations;
	}
	
	public String getJSONFromFile(final String path,final String input) throws IOException {
		String json = "";
		ZipFile zip = new ZipFile(path);
		InputStream source = zip.getInputStream(zip.getEntry(input));
		json = IOUtils.toString(source,"UTF-8");
		zip.close();
		return json;
	}

}
