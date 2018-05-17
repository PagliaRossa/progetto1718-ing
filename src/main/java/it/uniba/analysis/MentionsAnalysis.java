package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Mention;
import it.uniba.util.JSON;
import it.uniba.util.Zip;

public class MentionsAnalysis extends Analysis {
	
	private final List<Mention> mentions = new ArrayList<>();
	
	public List<Mention> getMentions() {
		return mentions;
	}
	
	private String getMentionFrom(final Mention mention) {
		return mention.getFrom();
	}
	
	private void setMentionFrom(final Mention mention,final String FromMember) {
		mention.setFrom(FromMember);
	}
	
	private void setMentionTo(final Mention mention,final String ToMember) {
		mention.setTo(ToMember);
	}
	
	private String getMentionTo(final Mention mention) {
		return mention.getTo();
	}
	
	private boolean mentionContain(final String mention,final String contain) {
		return mention.contains(contain);
	}
	
	private boolean mentionStartWith(final String mention,final String start) {
		return mention.startsWith(start);
	}
	
	private boolean compareFrom(final String From1,final String From2) {
		return From1.equals(From2);
	}
	
	private boolean compareTo(final String ToMember1,final String toMember2) {
		return ToMember1.equals(toMember2);
	}
	
	private int conversationsSize(final List<String> conversations) {
		return conversations.size();
	}
	
	private String getConversationsJSON(final List<String> conversations,final int index) {
		return conversations.get(index);
	}
	
	private void removeWrongMentions() {
		for (int i = 0; i < mentions.size(); i++) {
			if (getMentionFrom(mentions.get(i)) == null || getMentionTo(mentions.get(i)) == null){
				mentions.remove(i);
				i--;
			} else if (mentionContain(getMentionTo(mentions.get(i)),"|")) {
				mentions.remove(i);
				i--;
			} else if (mentionContain(getMentionFrom(mentions.get(i)),getMentionTo(mentions.get(i)))) {
				mentions.remove(i);
				i--;
			} else if (mentionContain(getMentionTo(mentions.get(i)),"://")) {
				mentions.remove(i);
				i--;
			} else if (mentionStartWith(getMentionTo(mentions.get(i)),"cha")) {
				mentions.remove(i);
				i--;
			} else if (mentionContain(getMentionTo(mentions.get(i)),"everyone")) {
				mentions.remove(i);
				i--;
			}
		}
	}
	
	private void removeOccurence() {
		for(int i = 0; i < mentions.size(); i++) {
			for(int j = i+1; j < mentions.size(); j++) {
				if(compareFrom(getMentionFrom(mentions.get(i)),getMentionFrom(mentions.get(j))) && compareTo(getMentionTo(mentions.get(i)),getMentionTo(mentions.get(j)))) {
					mentions.remove(j);
					i--;
					if (i < 0) {
						i = 0;
					}
				}
			}
		}
	}
	
	public boolean isEmpty() {
		return mentions.isEmpty();
	}
	
	public void setNameFromTo() {
		removeOccurence();
		Mention mention;
		for (int i = 0 ; i < mentions.size(); i++) {
			mention = mentions.get(i);
			setMentionFrom(mention,getMemberName(getMentionFrom(mention)));
			setMentionTo(mention,getMemberName(getMentionTo(mention)));
			mentions.set(i,mention);
		}
	}
	
	
	public boolean mentionsList(final String input) {
		try {
			final Zip zip = new Zip();
			final JSON setter = new JSON();
			final List<String> conversations = zip.setConversationFile(input);
			for (int i = 0; i < conversationsSize(conversations); i++) {
				final String json = zip.getJSONFromFile(input,getConversationsJSON(conversations,i));
				mentions.addAll(setter.setMentions(json));
			}
			removeWrongMentions();
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}
	
	public boolean mentionsListChannel(final String channel,final String path) {
		final ChannelsAnalysis analysis = new ChannelsAnalysis();
		if (analysis.channelsList(path)) {
			if (analysis.channelExist(channel)) {
				try {
					final Zip zip = new Zip();
					final JSON setter = new JSON();
					final List<String> conversations = zip.setConversationFile(channel,path);
					for (int i = 0; i < conversationsSize(conversations); i++) {
						final String json = zip.getJSONFromFile(path,getConversationsJSON(conversations,i));
						mentions.addAll(setter.setMentions(json));
					}
					removeWrongMentions();
					return true;
				} catch (ParseException p) {
					System.out.println("JSON not valid!");
				} catch (IOException i) {
					System.out.println("File not found or invalid");
				}
			} else {
				System.out.println("Channel not found");
				return false;
			}
		}
		return false;
	}

}
