package it.uniba.util;

import java.util.List;

import it.uniba.data.Member;

public class MembersPrinter {

	public String print(final List<?> members) {
		String str = "";
		str += "This is users list :\n\n";
		for (int i = 0; i < members.size(); i++) {
			str += ((Member) members.get(i)).getName();
			str += "\n";
		}
		return str;
	}
	
}
