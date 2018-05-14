package it.uniba.analysis;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import it.uniba.util.JSON;
import it.uniba.util.Zip;

public class MembersAnalysis extends Analysis {
	
	public boolean membersList(final String input) {
		try {
			Zip zip = new Zip();
			String json = zip.setUsersFile(input);
			JSON setter = new JSON();
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
