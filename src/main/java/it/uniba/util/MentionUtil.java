package it.uniba.util;

import java.util.List;

import it.uniba.data.Counter;
import it.uniba.data.Mention;

public final class MentionUtil {

	public String getMentionFrom(final Mention mention) {
		return mention.getFrom();
	}

	public void setMentionFrom(final Mention mention, final String fromMember) {
		mention.setFrom(fromMember);
	}

	public void setMentionTo(final Mention mention, final String toMember) {
		mention.setTo(toMember);
	}

	public String getMentionTo(final Mention mention) {
		return mention.getTo();
	}

	public boolean mentionContain(final String mention, final String contain) {
		return mention.contains(contain);
	}

	public boolean mentionStartWith(final String mention, final String start) {
		return mention.startsWith(start);
	}

	public boolean compareFrom(final String from1, final String from2) {
		return from1.equals(from2);
	}

	public boolean compareTo(final String toMember1, final String toMember2) {
		return toMember1.equals(toMember2);
	}

	public int conversationsSize(final List<String> conversations) {
		return conversations.size();
	}

	public String getConversationsJSON(final List<String> conversations, final int index) {
		return conversations.get(index);
	}

	public Counter newCounter(final int index, final int occurenceNumber) {
		return new Counter(index, occurenceNumber);
	}

	public void countIncreaser(final Counter counter) {
		counter.setOccurenceNumber(counter.getOccurenceNumber() + 1);
	}

	public int getWeight(final Counter counter) {
		return counter.getOccurenceNumber();
	}
}
