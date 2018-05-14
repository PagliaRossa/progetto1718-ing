package it.uniba.util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.uniba.data.Channel;
import it.uniba.data.Member;
import it.uniba.data.Mention;

public class JSON {
	
	public List<Member> setMembers(final String json) throws ParseException {
		List<Member> members = new ArrayList<>();
		Member member;
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			JSONObject profile = (JSONObject) obj.get("profile");
			String displayName = null;
			boolean displayNameExist = false;
			if (profile.containsKey("display_name")) {
				displayName = (String) profile.get("display_name");
				displayNameExist = true;
			}
			String name;
			if (displayNameExist && !displayName.equals("")) {
				name = displayName;
			} else if (!obj.containsKey("real_name")) {
				name = (String) obj.get("name");
			} else if (obj.get("real_name").equals("")) {
				name = (String) obj.get("name");
			} else {
				name = (String) obj.get("real_name");
			}
			member = new Member();
			member.setId((String) obj.get("id"));
			member.setName(name);
			members.add(member);
		}
		return members;
	}
	
	public List<Channel> setChannels(final String json) throws ParseException {
		List<Channel> channels = new ArrayList<Channel>();
		List<String> members;
		Channel channel;
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < array.size(); i++) {
			channel = new Channel();
			members = new ArrayList<>();
			JSONObject obj = (JSONObject) array.get(i);
			channel.setId((String) obj.get("id"));
			channel.setName((String) obj.get("name"));
			JSONArray array2 = (JSONArray) obj.get("members"); 
			for (int j = 0; j < array2.size(); j++) {
				members.add((String) array2.get(j));
			}
			channel.setMembers(members);
			channels.add(channel);
		}
		return channels;
	}
	
	public List<Mention> setMentions(final String json) throws ParseException {
		List<Mention> mentions = new ArrayList<>();
		JSONParser parser = new JSONParser();
		Mention mention;
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
							mention = new Mention((String) obj.get("user"),text.substring(begin+2,end));
							mentions.add(mention);
						}
					}
				}
			}
		}
		return mentions;
	}

}
