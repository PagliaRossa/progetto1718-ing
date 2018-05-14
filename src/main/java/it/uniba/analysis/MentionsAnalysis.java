package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Mention;
import it.uniba.util.JSON;
import it.uniba.util.Zip;

public class MentionsAnalysis extends Analysis {
	
	private List<Mention> mentions = new ArrayList<>();
	
	public List<Mention> getMentions() {
		return mentions;
	}
	
	private void removeWrongMentions() {
		for (int i = 0; i < mentions.size(); i++) {
			if (mentions.get(i).getFrom() == null || mentions.get(i).getTo() == null){
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getTo().contains("|")) {
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getFrom().contains(mentions.get(i).getTo())) {
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getTo().contains("://")) {
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getTo().startsWith("cha")) {
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getTo().contains("everyone")) {
				mentions.remove(i);
				i--;
			}
		}
	}
	
	private void removeOccurence() {
		for(int i = 0; i < mentions.size(); i++) {
			for(int j = i+1; j < mentions.size(); j++) {
				if(mentions.get(i).compareMention(mentions.get(j))){
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
			mention.setFrom(getMemberName(mention.getFrom()));
			mention.setTo(getMemberName(mention.getTo()));
			mentions.set(i,mention);
		}
	}
	
	
	public boolean mentionsList(final String input) {
		try {
			Zip zip = new Zip();
			List<String> conversations = zip.setConversationFile(input);
			for (int i = 0; i < conversations.size(); i++) {
				String json = zip.getJSONFromFile(input,conversations.get(i));
				JSON setter = new JSON();
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
		ChannelsAnalysis analysis = new ChannelsAnalysis();
		if (analysis.channelsList(path)) {
			if (analysis.channelExist(channel)) {
				try {
					Zip zip = new Zip();
					List<String> conversations = zip.setConversationFile(channel,path);
					for (int i = 0; i < conversations.size(); i++) {
						String json = zip.getJSONFromFile(path,conversations.get(i));
						JSON setter = new JSON();
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
