package it.uniba.analysis;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import it.uniba.util.JSONReader;
import it.uniba.util.ZipReader;
/**
 * 
 * Subclass of Analysis.
 * Analyzes Members of zipFile.
 *
 */
public class MembersAnalysis extends Analysis {

	/**
	 * List of Members in zipPath.
	 * @param input Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean membersList(final String input) {
		try {
			final ZipReader zip = new ZipReader();
			final String json = zip.setUsersFile(input);
			final JSONReader setter = new JSONReader();
			setMembers(setter.setMembers(json));
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}

}
