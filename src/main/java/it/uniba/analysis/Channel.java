package it.uniba.analysis;

import it.uniba.analysis.User;
import java.util.Vector;

class Channel {
	
	private String id;
	private String name;
	private Vector<User>members;
	
	void setId(String id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setMembers(Vector<User> members) {
		this.members = members;
	}
	String getId() { return this.id;}
	String getName() { return this.name;}
	Vector<User> getMembers() { return this.members;}
	
}
