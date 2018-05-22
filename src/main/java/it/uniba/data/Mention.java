package it.uniba.data;

public final class Mention {

	private String fromMember;
	private String toMember;

	public Mention(final String memberFrom, final String memberTo) {
		fromMember = memberFrom;
		toMember = memberTo;
	}

	public String getFrom() {
		return fromMember;
	}

	public String getTo() {
		return toMember;
	}

	public void setFrom(final String newFrom) {
		fromMember = newFrom;
	}

	public void setTo(final String newTo) {
		toMember = newTo;
	}

}
