package it.uniba.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Define a pojo class Channel.
 */
public final class Channel {

	/**
	 * Identificator of Channel.
	 */
	private String identificator;
	/**
	 * Name of Channel.
	 */
	private String name;
	/**
	 * List of members in Channel.
	 */
	private List<String> members = new ArrayList<>();

	/**
	 * Constructor of Channel with String identificator , String name , List of Strings members.
	 * @param identificator2 Set identificator2 as identificator of Channel
	 * @param name2 Set name2 as name of Channel
	 * @param members2 Set members2 as members of Channel
	 */
	public Channel(final String identificator2, final String name2, final List<String> members2) {
		identificator = identificator2;
		name = name2;
		members = members2;
	}

	/**
	 * Set identificator of Channel.
	 * @param idNew Set idNew as identificator of Channel
	 */
	public void setId(final String idNew) {
		identificator = idNew;
	}

	/**
	 * Set name of Channel.
	 * @param nameNew Set nameNew as name of Channel
	 */
	public void setName(final String nameNew) {
		name = nameNew;
	}

	/**
	 * Set members of Channel.
	 * @param membersNew Set membersNew as members of Channel
	 */
	public void setMembers(final List<String> membersNew) {
		members = membersNew;
	}

	/**
	 * Get identificator of Channel.
	 * @return identificator - Return identificator of channel
	 */
	public String getId() {
		return identificator;
	}

	/**
	 * Get name of Channel.
	 * @return name - Return name of channel
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get member of members in Channel.
	 * @param index Index of specified member
	 * @return member - Return specified member of members
	 */
	public String getMember(final int index) {
		return members.get(index);
	}

	/**
	 * Get members of Channel.
	 * @return members - Return members of Channel
	 */
	public List<String> getMembers() {
		return members;
	}

	/**
	 * Get size of members in Channel.
	 * @return size - Return size of members in Channel
	 */
	public int membersSize() {
		return members.size();
	}

	/**
	 * Check if members is empty.
	 * @return boolean - Return true or false if members is or isn't empty
	 */
	public boolean isEmpty() {
		return members.isEmpty();
	}

	/**
	 * Check if specified member is in members.
	 * @param identificatorNew Identificator of specified member
	 * @return boolean - Return true or false if specified member is or isn't in members
	 */
	public boolean isInChannel(final String identificatorNew) {
		return members.contains(identificatorNew);
	}

}
