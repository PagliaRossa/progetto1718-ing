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
	
	public boolean compareMention(final Mention a) {
		if (a.getFrom().equals(from) && a.getTo().equals(to)) {
			return true;
		} else {
			return false;
		}
	}

}
