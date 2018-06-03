package it.uniba.util;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.data.Member;

/**
 * Printer of Members.
 */
public final class MembersPrinter implements Printer {

	/**
	 * Override print method from interface Printer.
	 * @param members List of members
	 * @return String - List of members as string
	 */
	public String print(final List<?> members) {
		final MembersAnalysis analysis = new MembersAnalysis();
		final StringBuffer buf = new StringBuffer(26);
		buf.append("This is users list :\n\n");
		for (int i = 0; i < members.size(); i++) {
			buf.append(analysis.getMemberName((Member) members.get(i)));
			buf.append('\n');
		}
		return buf.toString();
	}

}
