package it.uniba.analysis;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.uniba.analysis.Zip;

public class Analysis {
	
	private Vector<User> Users;
	private String lastWorkspace;
	private Vector<Channel> Channels;
	
	Vector<User> getUsers() {return this.Users;}
	String getLastWorkspace() {return this.lastWorkspace;}
	Vector<Channel> Channels() {return this.Channels;}
	
	public void usersList(String input) {
		Zip zip = new Zip();
		if (input.substring(10) != getLastWorkspace()) {
			String json = zip.setUsersFile(input.substring(10));
			Users = new Vector<User>();
			this.lastWorkspace = input.substring(10);
			JSONParser parser = new JSONParser();
			try {
				JSONArray array = (JSONArray) parser.parse(json);
				for(int i=0;i < array.size();i++) {
					JSONObject obj = (JSONObject) array.get(i);
					User utente = new User((String) obj.get("id"),(String) obj.get("real_name"));
					Users.addElement(utente);
				}
				System.out.println(printUsers());
			}catch(ParseException p) {
				System.out.println("JSON not valid");
			}
		}
	}
	
	public void channelsList(String input) {
		Zip zip = new Zip();
		if (input.substring(12) != getLastWorkspace()) {
			String json = zip.setChannelFile(input.substring(12));
			Channels = new Vector<Channel>();
			this.lastWorkspace = input.substring(12);
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
				}
				System.out.println(printChannels());
			}catch(ParseException p) {
				System.out.println("JSON not valid");
			}
		}
	}
	
	private String printUsers() {
		String str = new String();
		str += "This is users list :\n\n";
		for(int i=0;i<Users.size();i++) {
			str += Users.get(i).getName() + "\n";
		}
		return str;
	}
	
	private String printChannels() {
		String str = new String();
		return str;
	}
	
	public void help() {
		String help = new String();
		
		help += "These are all available command for sna4slack\n\n";
		help += "usersList zipUrl                 Show users list in selected workspace with zipUrl\n";
		help += "channelsList zipUrl               Show channel list in selected workspace with zipUrl\n";
		help += "sna4slack                         Show this help interface";
		
		System.out.println(help);
	}
}

