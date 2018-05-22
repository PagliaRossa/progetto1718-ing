package it.uniba.data;

import java.util.ArrayList;
import java.util.List;

public final class Channel {

	private String identificator;
	private String name;
	private List<String> members = new ArrayList<>();

	public Channel(final String identificator2, final String name2, final List<String> members2) {
		identificator = identificator2;
		name = name2;
		members = members2;
	}

	public void setId(final String idNew) {
		identificator = idNew;
	}

	public void setName(final String nameNew) {
		name = nameNew;
	}

	public void setMembers(final List<String> membersNew) {
		members = membersNew;
	}

	public String getId() {
		return identificator;
	}

	public String getName() {
		return name;
	}

	public String getMember(final int index) {
		return members.get(index);
	}

	public List<String> getMembers() {
		return members;
	}

	public int membersSize() {
		return members.size();
	}

	public boolean isEmpty() {
		return members.isEmpty();
	}

	public boolean isInChannel(final String identificatorNew) {
		return members.contains(identificatorNew);
	}

}
