package it.uniba.data;

import java.util.Vector;

public class Channel {

	private String id;
	private String name;
	private Vector<String> members;

	public Channel(final String idNew, final String nameNew, final Vector<String> membersNew) {
		this.id = idNew;
		this.name = nameNew;
		this.members = membersNew;
	}

	public Channel() { }

	public void setId(final String idNew) {
		this.id = idNew;
	}

	public void setName(final String nameNew) {
		this.name = nameNew;
	}

	public void setMembers(final Vector<String> membersNew) {
		this.members = membersNew;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Vector<String> getMembers() {
		return this.members;
	}

}
