package it.uniba.data;

public class Counter {
	
	private int index;
	private int occurenceNumber;
	
	public Counter(final int indexNew,final int occurenceNumberNew) {
		index = indexNew;
		occurenceNumber = occurenceNumberNew;
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
	
	public void setOccurenceNumber(final int occurenceNumberNew) {
		occurenceNumber = occurenceNumberNew;
	}
}
