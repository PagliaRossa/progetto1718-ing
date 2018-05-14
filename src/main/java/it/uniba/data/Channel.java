package it.uniba.data;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	
	private String id;
	private String name;
	private List<String> members = new ArrayList<>();
	
	public void setId(final String idNew) {
		id = idNew;
	}
	
	public void setName(final String nameNew) {
		name = nameNew;
	}
	
	public void setMembers(final List<String> membersNew) {
		members = membersNew;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMember(final int i) {
		return members.get(i);
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
	
	public boolean isInChannel(final String id) {
		return members.contains(id);
	}

}
