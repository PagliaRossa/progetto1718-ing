package it.uniba.data;

public class Mention {
	
	private String from;
	private String to;
	
	Mention(String from_,String to_) {
		this.from = from_;
		this.to = to_;
	}
	
	void setFrom(String from_) {
		this.from = from_;
	}
	
	void setTo(String to_) {
		this.to = to_;
	}
	
	String getFrom() {
		return this.from;
	}
	
	String getTo() {
		return this.to;
	}

}
