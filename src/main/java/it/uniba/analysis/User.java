package it.uniba.analysis;

class User {

	private String id;
	private String name;

	User() { }
	void setId(final String idNew) {
		this.id = idNew;
	}

	void setName(final String nameNew) {
		this.name = nameNew;
	}

	String getId() {
		return this.id;
	}
	String getName() {
		return this.name;
	}
}
