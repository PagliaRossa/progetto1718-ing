package it.uniba.data;

public final class Counter {

	private int index;
	private int occurenceNumber;

	public Counter(final int indexNew, final int occurence) {
		index = indexNew;
		occurenceNumber = occurence;
	}

	public int getIndex() {
		return index;
	}

	public int getOccurenceNumber() {
		return this.occurenceNumber;
	}

	public void setIndex(final int indexNew) {
		index = indexNew;
	}

	public void setOccurenceNumber(final int occurence) {
		occurenceNumber = occurence;
	}
}
