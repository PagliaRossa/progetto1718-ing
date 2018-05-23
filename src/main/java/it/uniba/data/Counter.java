package it.uniba.data;

/**
 * Define a pojo class Counter.
 */
public final class Counter {

	/**
	 * Index of mention in list.
	 */
	private int index;
	/**
	 * Occurence of specified mention.
	 */
	private int occurenceNumber;

	/**
	 * Costructor that creates a new Counter object with index and occurence.
	 * @param indexNew Set index as IndexNew
	 * @param occurence Set occurenceNumber as occurence
	 */
	public Counter(final int indexNew, final int occurence) {
		index = indexNew;
		occurenceNumber = occurence;
	}

	/**
	 * Get index of Counter.
	 * @return index - Return index of Counter
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Get occurenceNumber of Counter.
	 * @return occurenceNumber - Return occurenceNumber of Counter
	 */
	public int getOccurenceNumber() {
		return this.occurenceNumber;
	}

	/**
	 * Set index of Counter.
	 * @param indexNew New index of Counter
	 */
	public void setIndex(final int indexNew) {
		index = indexNew;
	}

	/**
	 * Set occurenceNumber of Counter.
	 * @param occurence New occurence of occurenceNumber
	 */
	public void setOccurenceNumber(final int occurence) {
		occurenceNumber = occurence;
	}
}
