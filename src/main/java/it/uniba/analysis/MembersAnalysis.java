package it.uniba.analysis;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import it.uniba.util.JSONReader;
import it.uniba.util.ZipReader;

public class MembersAnalysis extends Analysis {
	
	public boolean membersList(final String input) {
		try {
			final ZipReader zip = new ZipReader();
			final String json = zip.setUsersFile(input);
			final JSONReader setter = new JSONReader();
			members = setter.setMembers(json);
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}
	
}
