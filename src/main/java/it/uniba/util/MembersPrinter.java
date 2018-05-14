package it.uniba.util;

import java.util.List;

import it.uniba.data.Member;

public class MembersPrinter {

	public String print(final List<?> members) {
		StringBuffer buf = new StringBuffer();
		buf.append("This is users list :\n\n");
		for (int i = 0; i < members.size(); i++) {
			buf.append(((Member) members.get(i)).getName());
			buf.append("\n");
		}
		return buf.toString();
	}
	
}
