package it.uniba.analysis;

import java.util.ArrayList;
import java.util.List;

import it.uniba.data.Member;

public abstract class Analysis {

	protected List<Member> members = new ArrayList<>();
	
	public List<Member> getMembers() {
		return members;
	}
	
	public String getMemberName(final String id) {
		String str = "";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getId().equals(id)) {
				str = members.get(i).getName();
				break;
			}
		}
		return str;
	}
	
	public boolean isInList(final String name) {
		boolean found = false;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
