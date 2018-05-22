package it.uniba.analysis;

import java.util.ArrayList;
import java.util.List;

import it.uniba.data.Member;

public class Analysis {

	private List<Member> members = new ArrayList<>();

	public final List<Member> getMembers() {
		return members;
	}

	protected final String getMemberId(final Member member) {
		return member.getId();
	}

	public final String getMemberName(final Member member) {
		return member.getName();
	}

	protected final boolean compareId(final String identificator1, final String identificator2) {
		return identificator1.equals(identificator2);
	}

	protected final boolean compareName(final String name1, final String name2) {
		return name1.equals(name2);
	}

	public final String getMemberName(final String identificator) {
		String str = "";
		for (int i = 0; i < members.size(); i++) {
			if (compareId(getMemberId(members.get(i)), identificator)) {
				str = getMemberName(members.get(i));
				break;
			}
		}
		return str;
	}

	public final boolean isInList(final String name) {
		boolean found = false;
		for (int i = 0; i < members.size(); i++) {
			if (compareName(getMemberName(members.get(i)), name)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public final void setMembers(final List<Member> membersNew) {
		this.members = membersNew;
	}
}
