package it.uniba.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

/**
 * Retrive specified file from Zip.
 */
public final class ZipReader {

	/**
	 * Get Entries from zip.
	 * @param zip Specified zip
	 * @return enumerations - Enumerations of zip entries
	 */
	private Enumeration<? extends ZipEntry> getEntries(final ZipFile zip) {
		return zip.entries();
	}

	/**
	 * Check if there are more elements.
	 * @param entries Enumations of entries
	 * @return boolean - True or false if there are more elements
	 */
	private boolean hasMoreElements(final Enumeration<? extends ZipEntry> entries) {
		return entries.hasMoreElements();
	}

	/**
	 * Get next entry.
	 * @param entries Enumations of entries
	 * @return entry - Get next entry in enumerations
	 */
	private ZipEntry nextElement(final Enumeration<? extends ZipEntry> entries) {
		return entries.nextElement();
	}

	/**
	 * Check if entry is a directory.
	 * @param entry Specified entry
	 * @return boolean - True or false if entry is or isn't a directory
	 */
	private boolean isDirectory(final ZipEntry entry) {
		return entry.isDirectory();
	}

	/**
	 * Get name of entry.
	 * @param entry Specified entry
	 * @return String - Name of entry
	 */
	private String getName(final ZipEntry entry) {
		return entry.getName();
	}

	/**
	 * Compare two name.
	 * @param name First String name
	 * @param toCompare Second String name
	 * @return boolean - True or false if are or aren't same
	 */
	private boolean compareNames(final String name, final String toCompare) {
		return toCompare.equals(name);
	}

	/**
	 * Check if name contain a specified string.
	 * @param name Checked String
	 * @param containName String to be checked
	 * @return boolean - True or false if name contain or not containName
	 */
	private boolean containName(final String name, final String containName) {
		return name.contains(containName);
	}

	/**
	 * Set users file as json.
	 * @param input Path of zip
	 * @return String - users.json as String
	 * @throws IOException If file not found , throw IOException
	 */
	public String setUsersFile(final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(input);
		if (zip.getEntry("users.json") == null) {
			zip.close();
			throw new IOException();
		} else {
			final InputStream source = zip.getInputStream(zip.getEntry("users.json"));
			json = IOUtils.toString(source, "UTF-8");
			zip.close();
		}
		return json;
	}

	/**
	 * Set channels file as json.
	 * @param input Path of zip
	 * @return String - channels.json as String
	 * @throws IOException If a file not found , throw IOExpcetion
	 */
	public String setChannelsFile(final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(input);
		if (zip.getEntry("channels.json") == null) {
			zip.close();
			throw new IOException();
		} else {
			final InputStream source = zip.getInputStream(zip.getEntry("channels.json"));
			json = IOUtils.toString(source, "UTF-8");
			zip.close();
		}
		return json;
	}

	/**
	 * Set conversations file as List of String.
	 * @param input Path of zip
	 * @return list - List of Strings
	 * @throws IOException If a file not found , throw IOException
	 */
	public List<String> setConversationFile(final String input) throws IOException {
		final List<String> conversations = new ArrayList<>();
		final ZipFile zip = new ZipFile(input);
		final Enumeration<? extends ZipEntry> entries = getEntries(zip);
		while (hasMoreElements(entries)) {
			final ZipEntry control = nextElement(entries);
			if (!isDirectory(control) && !compareNames(getName(control), "users.json")
					&& !compareNames(getName(control), "channels.json")
					&& !compareNames(getName(control), "integration_logs.json")) {
				conversations.add(getName(control));
			}
		}
		zip.close();
		return conversations;
	}

	/**
	 * Set conversations of specified channel as List of Strings.
	 * @param channel Specified channel
	 * @param path Path of zip
	 * @return List - List of String of channel
	 * @throws IOException If a file not found , throw IOException
	 */
	public List<String> setConversationFile(final String channel, final String path) throws IOException {
		final List<String> conversations = new ArrayList<>();
		final ZipFile zip = new ZipFile(path);
		final Enumeration<? extends ZipEntry> entries = getEntries(zip);
		while (hasMoreElements(entries)) {
			final ZipEntry control = nextElement(entries);
			if (!isDirectory(control) && containName(getName(control), channel)) {
					conversations.add(getName(control));
			}
		}
		zip.close();
		return conversations;
	}

	/**
	 * Set a json conversation as String.
	 * @param path Path of Zip
	 * @param input Specified file in zip
	 * @return String - Specified json file as String
	 * @throws IOException If a file not found , throw IOException
	 */
	public String getJSONFromFile(final String path, final String input) throws IOException {
		String json = "";
		final ZipFile zip = new ZipFile(path);
		final InputStream source = zip.getInputStream(zip.getEntry(input));
		json = IOUtils.toString(source, "UTF-8");
		zip.close();
		return json;
	}
}
