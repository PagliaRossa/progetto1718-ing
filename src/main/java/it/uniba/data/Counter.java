package it.uniba.data;

public class Counter {
	
	private int index;
	private int occurenceNumber;
	
	Counter() {
		occurenceNumber = 1;
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
