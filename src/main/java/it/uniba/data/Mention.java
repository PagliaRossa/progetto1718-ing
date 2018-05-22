package it.uniba.data;

/**
 * Define a pojo class Mention.
 */
public final class Mention {

	/**
	 * Member that mention a member.
	 */
	private String fromMember;
	/**
	 * Member that receive a mention from a member.
	 */
	private String toMember;

	/**
	 * Costructor that create a new Mention object with memberFrom and memberTo as fromMember and toMember.
	 * @param memberFrom Set fromMember as memberFrom
	 * @param memberTo Set toMember as memberTo
	 */
	public Mention(final String memberFrom, final String memberTo) {
		fromMember = memberFrom;
		toMember = memberTo;
	}

	/**
	 * Get fromMember of Mention.
	 * @return fromMember - Return fromMember
	 */
	public String getFrom() {
		return fromMember;
	}

	/**
	 * Get toMember of Mention.
	 * @return toMember - Return toMember
	 */
	public String getTo() {
		return toMember;
	}

	/**
	 * Set fromMember of Mention.
	 * @param newFrom Set fromMember as newFrom
	 */
	public void setFrom(final String newFrom) {
		fromMember = newFrom;
	}

	/**
	 * Set toMember of Mention.
	 * @param newTo Set toMember as newTo
	 */
	public void setTo(final String newTo) {
		toMember = newTo;
	}

}
