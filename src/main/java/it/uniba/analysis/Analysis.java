package it.uniba.analysis;

import java.util.ArrayList;
import java.util.List;

import it.uniba.data.Member;

public class Analysis {

	protected List<Member> members = new ArrayList<>();
	
	public List<Member> getMembers() {
		return members;
	}
	
	public String getMemberId(final Member member) {
		return member.getId();
	}
	
	public String getMemberName(final Member member) {
		return member.getName();
	}
	
	public String getMemberName(final String identificator) {
		String str = "";
		for (int i = 0; i < members.size(); i++) {
			if (getMemberId(members.get(i)) == identificator) {
				str = getMemberName(members.get(i));
				break;
			}
		}
		return str;
	}
	
	public boolean isInList(final String name) {
		boolean found = false;
		for (int i = 0; i < members.size(); i++) {
			if (getMemberId(members.get(i)) == name) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public void setMembers(final List<Member> members) {
		this.members = members;
	}
}
