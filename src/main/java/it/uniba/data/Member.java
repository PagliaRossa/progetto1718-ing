package it.uniba.data;

public class Member {
	
	private String identificator;
	private String name;
	
	public void setId(final String idNew) {
		identificator = idNew;
	}
	
	public void setName(final String nameNew) {
		name = nameNew;
	}
	
	public String getId() {
		return identificator;
	}
	
	public String getName() {
		return name;
	}
}
