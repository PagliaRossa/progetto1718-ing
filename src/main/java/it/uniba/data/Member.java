package it.uniba.data;

public class Member {
	
	private String id;
	private String name;
	
	public void setId(final String idNew) {
		id = idNew;
	}
	
	public void setName(final String nameNew) {
		name = nameNew;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void clear() {
		id = null;
		name = null;
	}

}
