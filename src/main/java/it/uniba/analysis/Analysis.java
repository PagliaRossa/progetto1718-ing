package it.uniba.analysis;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import it.uniba.data.*;

public class Analysis {

	private List<User> members;
	private List<Channel> channels;
	private List<Mention> mentions;

	final List<User> getUsers() {
		return this.members;
		}

	final List<Channel> getChannels() {
		return this.channels;
		}
	
	final List<Mention> getMentions() {
		return this.mentions;
	}

	public boolean membersList(final String input) {
		Zip zip = new Zip();
		String json = zip.setUsersFile(input);
		if (!json.isEmpty()) {
			members = new ArrayList<User>();
			JSONParser parser = new JSONParser();
			try {
				JSONArray array = (JSONArray) parser.parse(json);
				for (int i = 0; i < array.size(); i++) {
					JSONObject obj = (JSONObject) array.get(i);
					User utente = new User((String) obj.get("id"), (String) obj.get("real_name"));
					members.add(utente);
				}
				return true;
			} catch (ParseException p) {
				System.out.println("JSON not valid");
			}
		}
		return false;
	}

	public boolean channelsList(final String input) {
		Zip zip = new Zip();
		String json = zip.setChannelFile(input);
		if (!json.isEmpty()) {
			channels = new ArrayList<Channel>();
			JSONParser parser = new JSONParser();
			try {
				JSONArray array = (JSONArray) parser.parse(json);
				for (int i = 0; i < array.size(); i++) {
					JSONObject obj = (JSONObject) array.get(i);
					Channel channel = new Channel();
					channel.setId((String) obj.get("id"));
					channel.setName((String) obj.get("name"));
					JSONArray array2 = (JSONArray) obj.get("members");
					List<String> members = new ArrayList<String>(); 
					for (int j = 0; j < array2.size(); j++) {
						members.add((String) array2.get(j));
					}
					channel.setMembers(members);
					channels.add(channel);
				}
				return true;
			} catch (ParseException p) {
				System.out.println("JSON not valid");
			}
		}
		return false;
	}

	public void membersChannel(final String input,final String input2) {
		if (membersList(input2)) {
			channelsList(input2);
			boolean found = false;
			for (int i = 0; i < channels.size(); i++) {
				if (channels.get(i).getName().equals(input)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Channel not found");
			} else {
				System.out.println(printMembersInChannel(input));
			}
		}
	}
	
	public void membersSortedByChannel(final String input) {
		if (membersList(input)) {
			channelsList(input);
			System.out.println(printMembersSortedByChannel());
		}
			
	}
	
	public boolean mentionsList(final String input) {
		Zip zip = new Zip();
		List<String> conversations = zip.setConversationsFile(input);
		if (!conversations.isEmpty()) {
			mentions = new ArrayList<Mention>();
			for (int i = 0; i < conversations.size();i++) {
				String json = zip.getJsonFromFile(input,conversations.get(i));
				JSONParser parser = new JSONParser();
				try {
					JSONArray array = (JSONArray) parser.parse(json);
					for (int j = 0; j < array.size(); j++) {
						JSONObject obj = (JSONObject) array.get(j);
						String text = (String) obj.get("text");
						if (!obj.containsValue("subtype")) {
							if (text.contains("<@")) {
								int begin = 0;
								int end = 0;
								for (int k = 0; k < text.length(); k++) {
									if ((text.charAt(k) == '<'))
										begin = k;
									if (text.charAt(k) == '>') {
										end = k;
										Mention mention = new Mention((String) obj.get("user"),text.substring(begin+2,end));
										mentions.add(mention);
									}
								}
							}
						}
					}
				} catch (ParseException p) {
					System.out.println("JSON not valid");
					return false;
				}
			}
			removeWrongMentions();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean mentionsListChannel(final String channel,final String path) {
		Zip zip = new Zip();
		if (channelsList(path)) {
			boolean found = false;
			for (int i = 0; i < channels.size(); i++) {
				if (channels.get(i).getName().equals(channel)) {
					found = true;
					break;
				}
			}
			if (found) {
				List<String> conversations = zip.setConversationsFileChannel(channel,path);
				if (!conversations.isEmpty()) {
					mentions = new ArrayList<Mention>();
					for (int i = 0; i < conversations.size();i++) {
						String json = zip.getJsonFromFile(path,conversations.get(i));
						JSONParser parser = new JSONParser();
						try {
							JSONArray array = (JSONArray) parser.parse(json);
							for (int j = 0; j < array.size(); j++) {
								JSONObject obj = (JSONObject) array.get(j);
								String text = (String) obj.get("text");
								if (!obj.containsValue("subtype")) {
									if (text.contains("<@")) {
										int begin = 0;
										int end = 0;
										for (int k = 0; k < text.length(); k++) {
											if ((text.charAt(k) == '<'))
												begin = k;
											if (text.charAt(k) == '>') {
												end = k;
												Mention mention = new Mention((String) obj.get("user"),text.substring(begin+2,end));
												mentions.add(mention);
											}
										}
									}
								}
							}
						} catch (ParseException p) {
							System.out.println("JSON not valid");
							return false;
						}
					}
					removeWrongMentions();
					return true;
				} else {
					return false;
				}
			} else {
				System.out.println("Channel not found!");
			}
		}
		return false;
	}

	public String printMembers() {
		String str = new String();
		str += "This is users list :\n\n";
		for (int i = 0; i < members.size(); i++) {
			str += members.get(i).getName() + "\n";
		}
		return str;
	}

	public String printChannels() {
		String str = new String();
		str += "This is channels list :\n\n";
		for (int i = 0; i < channels.size(); i++) {
			str += channels.get(i).getName() + "\n";
		}
		return str;
	}

	private String printMembersInChannel(final String input) {
		String str = new String();
		int index = 0;
		for (int i = 0; i < channels.size(); i++) {
			if (channels.get(i).getName().equals(input)) {
				index = i;
				str += "These are members of " + input + " :\n\n";
			}
		}
		for (int i = 0; i < channels.get(index).getMembers().size(); i++) {
			for (int j = 0; j < members.size(); j++) {
				if (members.get(j).getId().equals(channels.get(index).getMembers().get(i))) {
					str += 	members.get(j).getName() + "\n";
				}
			}
		}
		return str;
	}
	
	private String printMembersSortedByChannel() {
		String str = new String();
		for (int i = 0; i < channels.size(); i++) {
			str += channels.get(i).getName() + " :\n";
			for (int j = 0; j < channels.get(i).getMembers().size(); j++) {
				for (int k = 0; k < members.size(); k++) {
					if (members.get(k).getId().equals(channels.get(i).getMembers().get(j))) {
						str += "- " + members.get(k).getName() + "\n";
					}
				}
			}
			str += "\n";
		}
		return str;
	}
	
	public String printMentionsList() {
		String str = new String();
		str += "\nList of Mentions : \n";
		for (int i = 0; i < mentions.size(); i++) {
			str += "From ";
			for (int j = 0; j < members.size(); j++) {
				if (members.get(j).getId().equals(mentions.get(i).getFrom())) {
					str += members.get(j).getName();
					break;
				}
			}
			str += " to ";
			for (int j = 0; j < members.size(); j++) {
				if (members.get(j).getId().equals(mentions.get(i).getTo())) {
					str += members.get(j).getName();
					break;
				}
			}
			str += "\n";
		}
		return str;
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
			} else if (mentions.get(i).getTo().contains("ttps")) {
				mentions.remove(i);
				i--;
			} else if (mentions.get(i).getTo().startsWith("cha")) {
				mentions.remove(i);
				i--;
			}
		}
	}

	public void help() {
		String help = new String();

		help += "These are all available command for sna4slack\n\n";
		help += "membersList zipPath                             Show members list in selected workspace with zipPath\n";
		help += "channelsList zipPath                            Show channel list in selected workspace with zipPath\n";
		help += "membersChannel channelName zipPath              Show member list in selected channel in selected workspace with zipPath\n";
		help += "membersSortedByChannel zipPath                  Show members sortedy by channel in selected workspace with zipPath\n";
		help += "mentionsList zipPath                            Show mentions list in selected workspace with zipPath\n";
		help += "mentionsListChannel channelName zipPath         Show mentions list in selected channel in selected workspace with zipPath\n";
		help += "sna4slack                                       Show this help interface\n";

		System.out.println(help);
	}
}

