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
	
	private int getArraySize(final JSONArray array) {
		return array.size();
	}
	
	private JSONObject getJSONObject(final JSONArray array,final int index) {
		return (JSONObject) array.get(index);
	}
	
	private JSONObject getJSONObject(final JSONObject obj,final String resource) {
		return (JSONObject) obj.get(resource);
	}
	
	private String getJSONObjectString(final JSONArray array,final int index) {
		return (String) array.get(index);
	}
	
	private boolean containsKey(final JSONObject obj,final String keyMatch) {
		return obj.containsKey(keyMatch);
	}
	
	private String getAttribute(final JSONObject obj,final String attribute) {
		return (String) obj.get(attribute);
	}
	
	private boolean attributeNull(final String attribute) {
		return "".equals(attribute);
	}
	
	private JSONArray getJSONArray(final JSONObject obj,final String resource) {
		return (JSONArray) obj.get(resource);
	}
	
	private int getTextSize(final String text) {
		return text.length();
	}
	
	private boolean containsChars(final String text,final String contains) {
		return text.contains(contains);
	}
	
	private char charAt(final String text,final int index) {
		return text.charAt(index);
	}
	
	private String sub(final String text,final int start,final int end) {
		return text.substring(start, end);
	}
	
	private boolean containsValue(final JSONObject obj,final String attribute) {
		return obj.containsValue(attribute);
	}
	
	public List<Member> setMembers(final String json) throws ParseException {
		final List<Member> members = new ArrayList<>();
		Member member;
		final JSONParser parser = new JSONParser();
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < getArraySize(array); i++) {
			final JSONObject obj = getJSONObject(array,i);
			final JSONObject profile = getJSONObject(obj,"profile");
			String displayName = null;
			boolean displayNameExist = false;
			if (containsKey(profile,"display_name")) {
				displayName = getAttribute(profile,"display_name");
				displayNameExist = true;
			}
			String name;
			if (displayNameExist && !(attributeNull(displayName))) {
				name = displayName;
			} else if (attributeNull("real_name")) {
				name = getAttribute(obj,"name");
			} else {
				name = getAttribute(obj,"real_name");
			}
			member = new Member(getAttribute(obj,"id"),name);
			members.add(member);
			
		}
		return members;
	}
	
	public List<Channel> setChannels(final String json) throws ParseException {
		final List<Channel> channels = new ArrayList<Channel>();
		List<String> members;
		Channel channel;
		final JSONParser parser = new JSONParser();
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < getArraySize(array); i++) {
			channel = new Channel();
			members = new ArrayList<>();
			final JSONObject obj = getJSONObject(array,i);
			channel.setId(getAttribute(obj,"id"));
			channel.setName(getAttribute(obj,"name"));
			final JSONArray array2 = getJSONArray(obj,"members"); 
			for (int j = 0; j < getArraySize(array2); j++) {
				members.add((String) getJSONObjectString(array2,j));
			}
			channel.setMembers(members);
			channels.add(channel);
		}
		return channels;
	}
	
	public List<Mention> setMentions(final String json) throws ParseException {
		final List<Mention> mentions = new ArrayList<>();
		final JSONParser parser = new JSONParser();
		Mention mention;
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int j = 0; j < getArraySize(array); j++) {
			final JSONObject obj = getJSONObject(array,j);
			final String text = getAttribute(obj,"text");
			if (!containsValue(obj,"subtype") && containsChars(text,"<@")) {
					int begin = 0;
					int end = 0;
					for (int k = 0; k < getTextSize(text); k++) {
						if (charAt(text,k) == '<') {
							begin = k;
						}
						if (charAt(text,k) == '>') {
							end = k;
							mention = new Mention(getAttribute(obj,"user"),sub(text,begin+2,end));
							mentions.add(mention);
						}
					}
				}
			}
		return mentions;
	}
}
