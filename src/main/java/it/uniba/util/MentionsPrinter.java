package it.uniba.util;

import java.util.List;

import it.uniba.data.Counter;
import it.uniba.data.Mention;

/**
 * Printer of Mentions which implements Printer interface.
 */
public final class MentionsPrinter implements Printer {

	/**
	 * Static string list mentions.
	 */
	private static String listMentions = "List of mentions :\n\n";
	/**
	 * Static string from.
	 */
	private static String fromMember = "From ";
	/**
	 * Static string to.
	 */
	private static String toMember = " to ";

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

	/**
	 * Print mentions from a Member.
	 * @param list List of mentions
	 * @param member Specified member
	 * @return String - List of mentions from specified member
	 */
	public String printFrom(final List<?> list, final String member) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareFrom(util.getMentionFrom(mention), member)) {
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

	/**
	 * Print mentions to a Member.
	 * @param list List of Mentions
	 * @param member Specified Member
	 * @return String - List of mentions to specified member as string
	 */
	public String printTo(final List<?> list, final String member) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer();
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareTo(util.getMentionTo(mention), member)) {
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

	/**
	 * Print Weighed mentions.
	 * @param list List of Mentions
	 * @param occurence List of occurence
	 * @return String - List of mentions weighed as string
	 */
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

	/**
	 * Print mentions weighed from a member.
	 * @param list List of Mentions
	 * @param member Specified Member
	 * @param occurence List of occurence
	 * @return String - List of mentions weighed from a specified member as string
	 */
	public String printFromWeighed(final List<Mention> list, final String member, final List<Counter> occurence) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer(33);
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareFrom(util.getMentionFrom(mention), member)) {
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

	/**
	 * Print mentions weighed to member over a specified integer.
	 * @param list List of Mentions
	 * @param member Specified Member
	 * @param occur List of occurence
	 * @param over Integer which define weight
	 * @return String - List of mentions weighed to specified member over over
	 */
	public String printToWeighed(final List<?> list, final String member, final List<Counter> occur, final int over) {
		final MentionUtil util = new MentionUtil();
		final StringBuffer buf = new StringBuffer();
		Mention mention;
		final String str = listMentions;
		buf.append(str);
		for (int i = 0; i < list.size(); i++) {
			mention = (Mention) list.get(i);
			if (util.compareTo(util.getMentionTo(mention), member) && util.getWeight(occur.get(i)) > over) {
				buf.append(fromMember);
				buf.append(util.getMentionFrom(mention));
				buf.append(toMember);
				buf.append(util.getMentionTo(mention));
				buf.append(' ');
				buf.append(util.getWeight(occur.get(i)));
				buf.append('\n');
			}
		}
		if (buf.toString().equals(str)) {
			return "Can't find mentions for this member over specified number !";
		} else {
			return buf.toString();
		}
	}
}
