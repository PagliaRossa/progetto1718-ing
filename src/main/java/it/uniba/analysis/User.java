package it.uniba.analysis;

class User {
	
	private String id;
	private String name;
	
	User(String id,String name){
		this.id = id;
		this.name = name;
	}
	void setId(String id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	String getId() { return this.id;}
	String getName() { return this.name;}
	
}
