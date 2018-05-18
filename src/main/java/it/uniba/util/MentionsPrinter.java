package it.uniba.util;

import java.util.List;

import it.uniba.data.Mention;

public class MentionsPrinter implements Printer {
	
	@Override
	public String print(final List<?> list) {
		MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		buf.append("List of mentions :\n\n");
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			buf.append("From ");
			buf.append(util.getMentionFrom(mention));
			buf.append(" to ");
			buf.append(util.getMentionTo(mention));
			buf.append('\n');
		}
		return buf.toString();
	}
	
	public String printFrom(final List<?> list,final String member) {
		MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareFrom(util.getMentionFrom(mention),member)) {
				buf.append("From ");
				buf.append(util.getMentionFrom(mention));
				buf.append(" to ");
				buf.append(util.getMentionTo(mention));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions for this member";
		} else {
			return buf.toString();
		}
	}
	
	public String printTo(final List<?> list,final String member) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer();
		Mention mention;
		final String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareTo(util.getMentionTo(mention),member)) {
				buf.append("From ");
				buf.append(util.getMentionFrom(mention));
				buf.append(" to ");
				buf.append(util.getMentionTo(mention));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions for this member";
		} else {
			return buf.toString();
		}
	}

}
