package it.uniba.analysis;

import java.util.Vector;

class Channel {
	
	private String id;
	private String name;
	private Vector<String>members;
	
	void setId(String id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setMembers(Vector<String> members) {
		this.members = members;
	}
	String getId() { return this.id;}
	String getName() { return this.name;}
	Vector<String> getMembers() { return this.members;}
	
}
