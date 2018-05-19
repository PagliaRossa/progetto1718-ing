package it.uniba.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class ZipReader {
	
	private Enumeration<? extends ZipEntry> getEntries(final ZipFile zip) {
		return zip.entries();
	}
	
	private boolean hasMoreElements(final Enumeration<? extends ZipEntry> entries) {
		return entries.hasMoreElements();
	}
	
	private ZipEntry nextElement(final Enumeration<? extends ZipEntry> entries) {
		return entries.nextElement();
	}
	
	private boolean isDirectory(final ZipEntry entry) {
		return entry.isDirectory();
	}
	
	private String getName(final ZipEntry entry) {
		return entry.getName();
	}
	
	private boolean compareNames(final String name,final String toCompare) {
		return toCompare.equals(name);
	}
	
	private boolean containName(final String name,final String containName) {
		return name.contains(containName);
	}
	
	public String setUsersFile(final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(input);
		if (zip.getEntry("users.json") == null) {
			zip.close();
			throw new IOException();
		} else {
			final InputStream source = zip.getInputStream(zip.getEntry("users.json"));
			json = IOUtils.toString(source,"UTF-8");
			zip.close();
		}
		return json;
	}
	
	public String setChannelsFile(final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(input);
		if (zip.getEntry("channels.json") == null) {
			zip.close();
			throw new IOException();
		} else {
			final InputStream source = zip.getInputStream(zip.getEntry("channels.json"));
			json = IOUtils.toString(source,"UTF-8");
			zip.close();
		}
		return json;
	}
	
	public List<String> setConversationFile(final String input) throws IOException {
		final List<String> conversations = new ArrayList<>();
		final ZipFile zip = new ZipFile(input);
		final Enumeration<? extends ZipEntry> entries = getEntries(zip);
		while (hasMoreElements(entries)) {
			final ZipEntry control = nextElement(entries);
			if (!isDirectory(control) && !compareNames(getName(control),"users.json") && !compareNames(getName(control),"channels.json") 
					&& !compareNames(getName(control),"integration_logs.json")) {
				conversations.add(getName(control));
			}
		}
		zip.close();
		return conversations;
	}
	
	public List<String> setConversationFile(final String channel,final String path) throws IOException {
		final List<String> conversations = new ArrayList<>();
		final ZipFile zip = new ZipFile(path);
		final Enumeration<? extends ZipEntry> entries = getEntries(zip);
		while (hasMoreElements(entries)) {
			final ZipEntry control = nextElement(entries);
			if (!isDirectory(control) && containName(getName(control),channel)) {
					conversations.add(getName(control));
			}
		}
		zip.close();
		return conversations;
	}
	
	public String getJSONFromFile(final String path,final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(path);
		final InputStream source = zip.getInputStream(zip.getEntry(input));
		json = IOUtils.toString(source,"UTF-8");
		zip.close();
		return json;
	}

}
