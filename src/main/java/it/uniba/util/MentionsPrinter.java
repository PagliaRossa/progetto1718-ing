package it.uniba.util;

import java.util.List;

import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Mention;

public class MentionsPrinter implements Printer {
	
	@Override
	public String print(final List<?> list) {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		buf.append("List of mentions :\n\n");
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			buf.append("From ");
			buf.append(mentions.getMentionFrom(mention));
			buf.append(" to ");
			buf.append(mentions.getMentionTo(mention));
			buf.append('\n');
		}
		return buf.toString();
	}
	
	public String printFrom(final List<?> list,final String member) {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mentions.compareFrom(mentions.getMentionFrom(mention),member)) {
				buf.append("From ");
				buf.append(mentions.getMentionFrom(mention));
				buf.append(" to ");
				buf.append(mentions.getMentionTo(mention));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions from this member";
		} else {
			return buf.toString();
		}
	}
	
	public String printTo(final List<?> list,final String member) {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		final StringBuffer buf = new StringBuffer();
		Mention mention;
		final String str = "List of mentions :\n\n";
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (mentions.compareTo(mentions.getMentionTo(mention),member)) {
				buf.append("From ");
				buf.append(mentions.getMentionFrom(mention));
				buf.append(" to ");
				buf.append(mentions.getMentionTo(mention));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions from this member";
		} else {
			return buf.toString();
		}
	}

}
