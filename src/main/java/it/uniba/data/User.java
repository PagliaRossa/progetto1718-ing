package it.uniba.data;

public class User {

	private String id;
	private String name;

	public User(final String idNew, final String nameNew) {
		this.id = idNew;
		this.name = nameNew;
	}
	public void setId(final String idNew) {
		this.id = idNew;
	}

	public void setName(final String nameNew) {
		this.name = nameNew;
	}

	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
}
