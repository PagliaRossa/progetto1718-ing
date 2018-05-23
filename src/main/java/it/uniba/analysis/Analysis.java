package it.uniba.analysis;

import java.util.ArrayList;
import java.util.List;

import it.uniba.data.Member;
/**
 * 
 * Analyze all Input Typed by User.
 *
 */
public class Analysis {
	/**
	 * Constructor List of Member.
	 */
	private List<Member> members = new ArrayList<>();
	/**
	 * Get Member from zipFile.
	 * @return members - Member in zipFile
	 */
	public List<Member> getMembers() {
		return members;
	}
	/**
	 * Get Member ID from zipFile.
	 * @param member Member in zipFile
	 * @return ID of Member
	 */
	protected String getMemberId(final Member member) {
		return member.getId();
	}

	/**
	 * Get Member from zipFile.
	 * @param member Member in zipFile
	 * @return Name of Member
	 */
	public String getMemberName(final Member member) {
		return member.getName();
	}

	/**
	 * Compare two identificator.
	 * @param identificator1 First String
	 * @param identificator2 Second String
	 * @return boolean
	 */
	protected boolean compareId(final String identificator1, final String identificator2) {
		return identificator1.equals(identificator2);
	}

	/**
	 * Compare two names.
	 * @param name1 First String
	 * @param name2 Second String
	 * @return boolean
	 */
	protected boolean compareName(final String name1, final String name2) {
		return name1.equals(name2);
	}

	/**
	 * Search Specific Member from zipFile, using ID.
	 * @param identificator String' s ID of Member
	 * @return String of specific Member
	 */
	public String getMemberName(final String identificator) {
		String str = "";
		for (int i = 0; i < members.size(); i++) {
			if (compareId(getMemberId(members.get(i)), identificator)) {
				str = getMemberName(members.get(i));
				break;
			}
		}
		return str;
	}

	/**
	 * Control if Member is in List.
	 * @param name Name of Specific Member
	 * @return found - Boolean of accomplished (or not) Control
	 */
	public boolean isInList(final String name) {
		boolean found = false;
		for (int i = 0; i < members.size(); i++) {
			if (compareName(getMemberName(members.get(i)), name)) {
				found = true;
				break;
			}
		}
		return found;
	}

	/**
	 * Set Member from zipFile.
	 * @param membersNew Member in zipFile
	 * 
	 */
	public void setMembers(final List<Member> membersNew) {
		this.members = membersNew;
	}
}
