package it.uniba.analysis;

import java.util.Vector;

class Channel {

	private String id;
	private String name;
	private Vector<String> members;

	Channel(final String idNew, final String nameNew, final Vector<String> membersNew) {
		this.id = idNew;
		this.name = nameNew;
		this.members = membersNew;
	}

	Channel() { }

	void setId(final String idNew) {
		this.id = idNew;
	}

	void setName(final String nameNew) {
		this.name = nameNew;
	}

	void setMembers(final Vector<String> membersNew) {
		this.members = membersNew;
	}

	String getId() {
		return this.id;
	}

	String getName() {
		return this.name;
	}

	Vector<String> getMembers() {
		return this.members;
	}

}
