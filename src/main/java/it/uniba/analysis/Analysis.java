package it.uniba.analysis;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.uniba.analysis.Zip;

public class Analysis {
	
	private Vector<User> Users;
	private Vector<Channel> Channels;
	
	Vector<User> getUsers() {return this.Users;}
	Vector<Channel> Channels() {return this.Channels;}
	
	public boolean usersList(String input) {
		Zip zip = new Zip();
		String json = zip.setUsersFile(input.substring(10));
		Users = new Vector<User>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(json);
			for(int i=0;i < array.size();i++) {
				JSONObject obj = (JSONObject) array.get(i);
				User utente = new User((String) obj.get("id"),(String) obj.get("real_name"));
				Users.addElement(utente);
			}
			return true;
		}catch(ParseException p) {
			System.out.println("JSON not valid");
			return false;
		}
	}
	
	public boolean channelsList(String input) {
		Zip zip = new Zip();
		String json = zip.setChannelFile(input.substring(13));
		Channels = new Vector<Channel>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(json);
			for(int i=0;i<array.size();i++) {
				JSONObject obj = (JSONObject) array.get(i);
				Channel channel = new Channel();
				channel.setId((String) obj.get("id"));
				channel.setName((String) obj.get("name"));
				JSONArray array2 =(JSONArray) obj.get("members");
				Vector<String> members = new Vector<String>(); 
				for(int j=0;j<array2.size();j++) {
					members.add((String) obj.get(j));
				}
				channel.setMembers(members);
				Channels.add(channel);
			}
			return true;
		}catch(ParseException p) {
			System.out.println("JSON not valid");
			return false;
		}
	}
	
	public void membersChannel(String input) {
		String sub = input.substring(15);
		String split[] = sub.split(" ");
		String zipurl = split[0];
		zipurl = zipurl.substring(0,zipurl.length()-1);
		if (usersList(zipurl) == true) {
			channelsList(zipurl);
			boolean flag = false;
			for(int i=0;i<Channels.size();i++) {
				if (Channels.get(i).getName() == split[1])
				flag = true;
			}
			if (flag == false) {
				System.out.println("Channel not found");
			}else printUserInChannel(split[1]);
		}
	}
	
	public String printUsers() {
		String str = new String();
		str += "This is users list :\n\n";
		for(int i=0;i<Users.size();i++) {
			str += Users.get(i).getName() + "\n";
		}
		return str;
	}
	
	public String printChannels() {
		String str = new String();
		str += "This is channels list :\n\n";
		for(int i=0;i<Channels.size();i++) {
			str += Channels.get(i).getName() + "\n";
		}
		return str;
	}
	
	public String printUserInChannel(String input) {
		String str = new String();
		int index = -1;
		for(int i=0;i<Channels.size();i++) {
			if (Channels.get(i).getName() == input) {
				index = i;
				str += "These are members of" + input + "\n\n";
			}
		}
		for(int i=0;i<Channels.get(index).getMembers().size();i++) {
			for(int j=0;j<Users.size();j++) {
				if (Users.get(j).getId() == Channels.get(index).getMembers().get(i))
					str += 	Users.get(j).getName();
			}
		}
		return str;
	}
	
	public void help() {
		String help = new String();
		
		help += "These are all available command for sna4slack\n\n";
		help += "usersList zipUrl                     Show users list in selected workspace with zipUrl\n";
		help += "channelsList zipUrl                  Show channel list in selected workspace with zipUrl\n";
		help += "membersChannel zipUrl channelName     Show member list in selected channel\n";
		help += "sna4slack                            Show this help interface";
		
		System.out.println(help);
	}
}

