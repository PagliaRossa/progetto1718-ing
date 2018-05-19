package it.uniba.util;

import java.util.List;

import it.uniba.data.Counter;
import it.uniba.data.Mention;

public class MentionUtil {
	
	public String getMentionFrom(final Mention mention) {
		return mention.getFrom();
	}
	
	public void setMentionFrom(final Mention mention,final String FromMember) {
		mention.setFrom(FromMember);
	}
	
	public void setMentionTo(final Mention mention,final String ToMember) {
		mention.setTo(ToMember);
	}
	
	public String getMentionTo(final Mention mention) {
		return mention.getTo();
	}
	
	public boolean mentionContain(final String mention,final String contain) {
		return mention.contains(contain);
	}
	
	public boolean mentionStartWith(final String mention,final String start) {
		return mention.startsWith(start);
	}
	
	public boolean compareFrom(final String From1,final String From2) {
		return From1.equals(From2);
	}
	
	public boolean compareTo(final String ToMember1,final String toMember2) {
		return ToMember1.equals(toMember2);
	}
	
	public int conversationsSize(final List<String> conversations) {
		return conversations.size();
	}
	
	public String getConversationsJSON(final List<String> conversations,final int index) {
		return conversations.get(index);
	}
	
	public Counter newCounter(final int index,final int occurenceNumber) {
		return new Counter(index,occurenceNumber);
	}
	
	public void countIncreaser(final Counter counter) {
		counter.setOccurenceNumber(counter.getOccurenceNumber()+1);
	}

}
