package it.uniba.data;

public class Mention {
	
	private String from;
	private String to;
	
	public Mention(String memberFrom,String memberTo) {
		from = memberFrom;
		to = memberTo;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setFrom(String newFrom) {
		from = newFrom;
	}
	
	public void setTo(String newTo) {
		to = newTo;
	}
	
	public boolean equals(Mention mention) {
		return (from.equals(mention.from) && to.equals(mention.to));
	}

}
