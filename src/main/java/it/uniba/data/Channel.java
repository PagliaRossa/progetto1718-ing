package it.uniba.data;

import java.util.List;

public class Channel {

	private String id;
	private String name;
	private List<String> members;

	public void setId(final String idNew) {
		this.id = idNew;
	}

	public void setName(final String nameNew) {
		this.name = nameNew;
	}

	public void setMembers(final List<String> membersNew) {
		this.members = membersNew;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public List<String> getMembers() {
		return this.members;
	}

}
