package it.uniba.data;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	
	private String identificator;
	private String name;
	private List<String> members = new ArrayList<>();
	
	public void setId(final String idNew) {
		identificator = idNew;
	}
	
	public void setName(final String nameNew) {
		name = nameNew;
	}
	
	public void setMembers(final List<String> membersNew) {
		members = membersNew;
	}
	
	public String getId() {
		return identificator;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMember(final int index) {
		return members.get(index);
	}
	
	public List<String> getMembers() {
		return members;
	}
	
	public int membersSize() {
		return members.size();
	}
	
	public boolean isEmpty() {
		return members.isEmpty();
	}
	
	public boolean isInChannel(final String identificator) {
		return members.contains(identificator);
	}

}
