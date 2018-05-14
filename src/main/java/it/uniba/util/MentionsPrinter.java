package it.uniba.util;

import java.util.List;
import it.uniba.data.Mention;

public class MentionsPrinter implements Printer {
	
	@Override
	public String print(final List<?> list) {
		String str = "";
		Mention mention;
		str += "List of mentions :\n\n";
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			str += "From " + mention.getFrom() + " to " + mention.getTo() + "\n";
		}
		return str;
	}
	
	public String printFrom(List<?> list,final String member) {
		String str = "";
		Mention mention;
		str += "List of mentions :\n\n";
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mention.getFrom().equals(member)) {
				str += "From " + mention.getFrom() + " to " + mention.getTo() + "\n";
			}
		}
		if (str.equals("")) {
			return str;
		} else {
			return str = "Can't find mentions from this member";
		}
	}
	
	public String printTo(List<?> list,final String member) {
		String str = "";
		Mention mention;
		str += "List of mentions :\n\n";
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mention.getTo().equals(member)) {
				str += "From " + mention.getFrom() + " to " + mention.getTo() + "\n";
			}
		}
		if (str.equals("")) {
			return str;
		} else {
			return str = "Can't find mentions to this member";
		}
	}

}
