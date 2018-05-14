package it.uniba.util;

import java.util.List;
import it.uniba.data.Mention;

public class MentionsPrinter implements Printer {
	
	@Override
	public String print(final List<?> list) {
		StringBuffer buf = new StringBuffer();
		Mention mention;
		buf.append("List of mentions :\n\n");
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			buf.append("From ");
			buf.append(mention.getFrom());
			buf.append(" to ");
			buf.append(mention.getTo());
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public String printFrom(List<?> list,final String member) {
		StringBuffer buf = new StringBuffer();
		Mention mention;
		String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mention.getFrom().equals(member)) {
				buf.append("From ");
				buf.append(mention.getFrom());
				buf.append(" to ");
				buf.append(mention.getTo());
				buf.append("\n");
			}
		}
		if (!(buf.length() == str.length())) {
			return buf.toString() ;
		} else {
			return "Can't find mentions from this member";
		}
	}
	
	public String printTo(List<?> list,final String member) {
		StringBuffer buf = new StringBuffer();
		Mention mention;
		String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mention.getTo().equals(member)) {
				buf.append("From ");
				buf.append(mention.getFrom());
				buf.append(" to ");
				buf.append(mention.getTo());
				buf.append("\n");
			}
		}
		if (!(buf.length() == str.length())) {
			return buf.toString() ;
		} else {
			return "Can't find mentions from this member";
		}
	}

}
