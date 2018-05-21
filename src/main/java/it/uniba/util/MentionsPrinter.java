package it.uniba.util;

import java.util.List;

import it.uniba.data.Counter;
import it.uniba.data.Mention;

public class MentionsPrinter implements Printer {
	
	static String listMentions = "List of mentions :\n\n";
	static String fromMember = "From ";
	static String toMember = " to ";
	
	@Override
	public String print(final List<?> list) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		buf.append(listMentions);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			buf.append(fromMember);
			buf.append(util.getMentionFrom(mention));
			buf.append(toMember);
			buf.append(util.getMentionTo(mention));
			buf.append('\n');
		}
		
		if (buf.toString().equals(listMentions)) {
			return "Can't find mentions !";
		} else {
			return buf.toString();
		}
	}
	
	public String printFrom(final List<?> list,final String member) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareFrom(util.getMentionFrom(mention),member)) {
				buf.append(fromMember);
				buf.append(util.getMentionFrom(mention));
				buf.append(toMember);
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
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareTo(util.getMentionTo(mention),member)) {
				buf.append(fromMember);
				buf.append(util.getMentionFrom(mention));
				buf.append(toMember);
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
	
	public String printWeighed(final List<?> list, final List<Counter> occurence) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		buf.append(listMentions);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			buf.append(fromMember);
			buf.append(util.getMentionFrom(mention));
			buf.append(toMember);
			buf.append(util.getMentionTo(mention));
			buf.append(' ');
			buf.append(util.getWeight(occurence.get(i)));
			buf.append('\n');
		}
		if (buf.toString().equals(listMentions)) {
			return "Can't find mentions !";
		} else {
			return buf.toString();
		}
	}

	public String printFromWeighed( final List<Mention> list, final String member, final List<Counter> occurence) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareFrom(util.getMentionFrom(mention),member)) {
				buf.append(fromMember);
				buf.append(util.getMentionFrom(mention));
				buf.append(toMember);
				buf.append(util.getMentionTo(mention));
				buf.append(' ');
				buf.append(util.getWeight(occurence.get(i)));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions for this member";
		} else {
			return buf.toString();
		}
	}
	
	public String printToWeighed(final List<?> list,final String member,List<Counter> occurence,int over) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer();
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareTo(util.getMentionTo(mention),member)) {
				if (util.getWeight(occurence.get(i)) > over) {
					buf.append(fromMember);
					buf.append(util.getMentionFrom(mention));
					buf.append(toMember);
					buf.append(util.getMentionTo(mention));
					buf.append(' ');
					buf.append(util.getWeight(occurence.get(i)));
					buf.append('\n');
				}
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions for this member over specified number !";
		} else {
			return buf.toString();
		}
	}

}
