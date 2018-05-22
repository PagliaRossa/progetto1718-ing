package it.uniba.data;

/**
 * Define a pojo class Member.
 */
public final class Member {

	/**
	 * Identificator of Member.
	 */
	private String identificator;
	/**
	 * Name of Member.
	 */
	private String name;

	/**
	 * Costruct a new object Member with identificatorNew and nameNew as identificator and name.
	 * @param identificatorNew Set identificator as identificatorNew
	 * @param nameNew Set name as nameNew
	 */
	public Member(final String identificatorNew, final String nameNew) {
		identificator = identificatorNew;
		name = nameNew;
	}

	/**
	 * Set identificator of Member.
	 * @param idNew Set identificator as idNew
	 */
	public void setId(final String idNew) {
		identificator = idNew;
	}

	/**
	 * Set name of Member.
	 * @param nameNew Set name as nameNew
	 */
	public void setName(final String nameNew) {
		name = nameNew;
	}

	/**
	 * Get identificator of Member.
	 * @return identificator - Identificator of Member
	 */
	public String getId() {
		return identificator;
	}

	/**
	 * Get name of Member.
	 * @return name - Name of Member
	 */
	public String getName() {
		return name;
	}
}
