package it.uniba.util;

import java.util.List;

import it.uniba.data.Counter;
import it.uniba.data.Mention;

/**
 * Utils for Mention analysis.
 */
public final class MentionUtil {

	/**
	 * Get fromMember from required Mention.
	 * @param mention Selected mention
	 * @return fromMember - fromMember of selected Mention
	 */
	public String getMentionFrom(final Mention mention) {
		return mention.getFrom();
	}

	/**
	 * Set fromMember to required Mention.
	 * @param mention Selected mention
	 * @param fromMember String to be setted
	 */
	public void setMentionFrom(final Mention mention, final String fromMember) {
		mention.setFrom(fromMember);
	}

	/**
	 * Set toMember from required Mention.
	 * @param mention Selected mention
	 * @param toMember String to be setted
	 */
	public void setMentionTo(final Mention mention, final String toMember) {
		mention.setTo(toMember);
	}

	/**
	 * Get toMember from required Mention.
	 * @param mention Selected mention
	 * @return toMember - toMember of selected Mention
	 */
	public String getMentionTo(final Mention mention) {
		return mention.getTo();
	}

	/**
	 * Control if mention contain selected string.
	 * @param mention Selected mention
	 * @param contain Selected String
	 * @return boolean - True or false if mention contain string
	 */
	public boolean mentionContain(final String mention, final String contain) {
		return mention.contains(contain);
	}

	/**
	 * Control if mention start with selected string.
	 * @param mention Selected mention
	 * @param start Selected String
	 * @return boolean - True or false if mention star with String
	 */
	public boolean mentionStartWith(final String mention, final String start) {
		return mention.startsWith(start);
	}

	/**
	 * Compare two fromMember.
	 * @param from1 First fromMember
	 * @param from2 Second fromMember
	 * @return boolean - True or false if same string
	 */
	public boolean compareFrom(final String from1, final String from2) {
		return from1.equals(from2);
	}

	/**
	 * Compare two fromMember.
	 * @param toMember1 First toMember
	 * @param toMember2 Second toMember
	 * @return boolean - True or false if same string
	 */
	public boolean compareTo(final String toMember1, final String toMember2) {
		return toMember1.equals(toMember2);
	}

	/**
	 * Get conversation size.
	 * @param conversations List of conversations
	 * @return size - Integer size of conversations
	 */
	public int conversationsSize(final List<String> conversations) {
		return conversations.size();
	}

	/**
	 * Get specified json String from conversations.
	 * @param conversations List of Strings
	 * @param index Index selected
	 * @return String - Requested String
	 */
	public String getConversationsJSON(final List<String> conversations, final int index) {
		return conversations.get(index);
	}

	/**
	 * Create a new Counter object.
	 * @param index Set index
	 * @param occurenceNumber Set occurenceNumber
	 * @return Counter - New Counter object
	 */
	public Counter newCounter(final int index, final int occurenceNumber) {
		return new Counter(index, occurenceNumber);
	}

	/**
	 * Increase occurence count.
	 * @param counter Specified counter
	 */
	public void countIncreaser(final Counter counter) {
		counter.setOccurenceNumber(counter.getOccurenceNumber() + 1);
	}

	/**
	 * Get occurenceNumber of specified Counter.
	 * @param counter Specified Counter
	 * @return Integer - Count of occurence
	 */
	public int getWeight(final Counter counter) {
		return counter.getOccurenceNumber();
	}
}
