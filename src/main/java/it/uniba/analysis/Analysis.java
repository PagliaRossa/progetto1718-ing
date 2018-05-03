package it.uniba.analysis;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Analysis {

	private Vector<User> members;
	private Vector<Channel> channels;

	final Vector<User> getUsers() {
		return this.members;
		}

	final Vector<Channel> getChannels() {
		return this.channels;
		}

	public boolean membersList(final String input) {
		Zip zip = new Zip();
		String json = zip.setUsersFile(input);
		members = new Vector<User>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(json);
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				User utente = new User((String) obj.get("id"), (String) obj.get("real_name"));
				members.addElement(utente);
			}
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid");
		}
		return false;
	}

	public boolean channelsList(final String input) {
		Zip zip = new Zip();
		String json = zip.setChannelFile(input);
		channels = new Vector<Channel>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(json);
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				Channel channel = new Channel();
				channel.setId((String) obj.get("id"));
				channel.setName((String) obj.get("name"));
				JSONArray array2 = (JSONArray) obj.get("members");
				Vector<String> members = new Vector<String>(); 
				for (int j = 0; j < array2.size(); j++) {
					members.add((String) array2.get(j));
				}
				channel.setMembers(members);
				channels.add(channel);
			}
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid");
			return false;
		}
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
				System.out.println(printUserInChannel(input));
			}
		}
	}
	
	public void usersSortedByChannel(final String input) {
		if (membersList(input)) {
			channelsList(input);
			System.out.println(printUsersSortedByChannel());
		}
			
	}

	public String printUsers() {
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

	private String printUserInChannel(final String input) {
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
	
	private String printUsersSortedByChannel() {
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

	public void help() {
		String help = new String();

		help += "These are all available command for sna4slack\n\n";
		help += "usersList zipUrl                        Show users list in selected workspace with zipUrl\n";
		help += "channelsList zipUrl                     Show channel list in selected workspace with zipUrl\n";
		help += "membersChannel channelName zipUrl       Show member list in selected channel in selected workspace with zipUrl\n";
		help += "usersSortedByChannel zipUrl             Show users sortedy by channel in selected workspace with zipUrl\n";
		help += "sna4slack                               Show this help interface\n";

		System.out.println(help);
	}
}

