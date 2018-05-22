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

/**
 * Get specific field from a json.
 */
public final class JSONReader {

	/**
	 * Get an array size.
	 * @param array Specific array
	 * @return Integer - Size of array
	 */
	private int getArraySize(final JSONArray array) {
		return array.size();
	}

	/**
	 * Get a json object from a json array.
	 * @param array Specific Array
	 * @param index Index of object
	 * @return object - Specific object at index in array
	 */
	private JSONObject getJSONObject(final JSONArray array, final int index) {
		return (JSONObject) array.get(index);
	}

	/**
	 * Get json object that equals resource.
	 * @param obj Specific input object
	 * @param resource Specific name of resource
	 * @return obj - Object with specific resource name
	 */
	private JSONObject getJSONObject(final JSONObject obj, final String resource) {
		return (JSONObject) obj.get(resource);
	}

	/**
	 * Get json object as String.
	 * @param array Specific json array
	 * @param index Specific index
	 * @return String - specific object in array at index as String
	 */
	private String getJSONObjectString(final JSONArray array, final int index) {
		return (String) array.get(index);
	}

	/**
	 * Check if object contain a specific key.
	 * @param obj Specific Object
	 * @param keyMatch Specific key
	 * @return boolean - True or False if obj contains or not contains key 
	 */
	private boolean containsKey(final JSONObject obj, final String keyMatch) {
		return obj.containsKey(keyMatch);
	}

	/**
	 * Get specific attribute.
	 * @param obj Specific object
	 * @param attribute Attribute name
	 * @return String - Attribute as String in object
	 */
	private String getAttribute(final JSONObject obj, final String attribute) {
		return (String) obj.get(attribute);
	}

	/**
	 * Check if attribute is null.
	 * @param attribute String of specific attribute
	 * @return boolean - True or false if attribute is or isn't null
	 */
	private boolean attributeNull(final String attribute) {
		return "".equals(attribute);
	}

	/**
	 * Get jsonArray in json object.
	 * @param obj Specific Object
	 * @param resource Name of Array
	 * @return Array - Return array with same name in object
	 */
	private JSONArray getJSONArray(final JSONObject obj, final String resource) {
		return (JSONArray) obj.get(resource);
	}

	/**
	 * Get Size of string.
	 * @param text String
	 * @return Integer - Size of String
	 */
	private int getTextSize(final String text) {
		return text.length();
	}

	/**
	 * Check if String contain chars.
	 * @param text String
	 * @param contains String of chars
	 * @return boolean - True or false if contains or not contains chars
	 */
	private boolean containsChars(final String text, final String contains) {
		return text.contains(contains);
	}

	/**
	 * Get char at index in String.
	 * @param text String
	 * @param index Index of char
	 * @return char - Char at index
	 */
	private char charAt(final String text, final int index) {
		return text.charAt(index);
	}

	/**
	 * Get sub String of String.
	 * @param text String
	 * @param start Start index
	 * @param end End index
	 * @return String - Return sub string from start to end
	 */
	private String sub(final String text, final int start, final int end) {
		return text.substring(start, end);
	}

	/**
	 * Check if Object contain value.
	 * @param obj Specific Object
	 * @param attribute Name of Attribute
	 * @return boolean - True or false if object contains or not contains attribute
	 */
	private boolean containsValue(final JSONObject obj, final String attribute) {
		return obj.containsValue(attribute);
	}

	/**
	 * Create a new Member Object.
	 * @param identificator Identificator of Member
	 * @param name Name of Member
	 * @return Member - New Member object
	 */
	private Member newMember(final String identificator, final String name) {
		return new Member(identificator, name);
	}

	/**
	 * Create a new Mention Object.
	 * @param fromMember fromMember of Mention
	 * @param toMember toMember of Mentions
	 * @return Mention - New Mention Object
	 */
	private Mention newMention(final String fromMember, final String toMember) {
		return new Mention(fromMember, toMember);
	}

	/**
	 * Create a new Channel object.
	 * @param identificator Identificator of Channel
	 * @param name Name of channel
	 * @param members Members of Channels
	 * @return Channel - New Channel Object
	 */
	private Channel newChannel(final String identificator, final String name, final List<String> members) {
		return new Channel(identificator, name, members);
	}

	/**
	 * Create a new list of Members.
	 * @return List - New list of Members
	 */
	private List<String> newMembers() {
		return new ArrayList<String>();
	}

	/**
	 * Set members list from a json.
	 * @param json Specific json
	 * @return List - List of members
	 * @throws ParseException If json is invalid , throw ParseException
	 */
	public List<Member> setMembers(final String json) throws ParseException {
		final List<Member> members = new ArrayList<>();
		final JSONParser parser = new JSONParser();
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < getArraySize(array); i++) {
			final JSONObject obj = getJSONObject(array, i);
			final JSONObject profile = getJSONObject(obj, "profile");
			boolean displayNameExist = false;
			if (containsKey(profile, "display_name")) {
				displayNameExist = true;
			}
			String choosen = "";
			String displayName = "";
			final String name = getAttribute(obj, "name");
			if (displayNameExist) {
				displayName = getAttribute(profile, "display_name");
			}
			final String realName = getAttribute(obj, "real_name");
			if (displayNameExist && !attributeNull(displayName)) {
				choosen = displayName;
			} else if (attributeNull(realName)) {
				choosen = name;
			} else {
				choosen = realName;
			}
			members.add(newMember(getAttribute(obj, "id"), choosen));
		}
		return members;
	}

	/**
	 * Set channels List from json.
	 * @param json Specific Json
	 * @return List - List of channels
	 * @throws ParseException If json is invalid , throw ParseException
	 */
	public List<Channel> setChannels(final String json) throws ParseException {
		final List<Channel> channels = new ArrayList<Channel>();
		List<String> members;
		members = new ArrayList<>();
		final JSONParser parser = new JSONParser();
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int i = 0; i < getArraySize(array); i++) {
			final JSONObject obj = getJSONObject(array, i);
			final JSONArray array2 = getJSONArray(obj, "members");
			for (int j = 0; j < getArraySize(array2); j++) {
				members.add((String) getJSONObjectString(array2, j));
			}
			channels.add(newChannel(getAttribute(obj, "id"), getAttribute(obj, "name"), members));
			members = newMembers();
		}
		return channels;
	}

	/**
	 * Set mentions list from json.
	 * @param json Specific json
	 * @return List - List of mentions
	 * @throws ParseException If json not valid , throw ParseException
	 */
	public List<Mention> setMentions(final String json) throws ParseException {
		final List<Mention> mentions = new ArrayList<>();
		final JSONParser parser = new JSONParser();
		final JSONArray array = (JSONArray) parser.parse(json);
		for (int j = 0; j < getArraySize(array); j++) {
			final JSONObject obj = getJSONObject(array, j);
			final String text = getAttribute(obj, "text");
			if (!containsValue(obj, "subtype") && containsChars(text, "<@")) {
					int begin = 0;
					int end = 0;
					for (int k = 0; k < getTextSize(text); k++) {
						if (charAt(text, k) == '<') {
							begin = k;
						}
						if (charAt(text, k) == '>') {
							end = k;
							mentions.add(newMention(getAttribute(obj, "user"), sub(text, begin + 2, end)));
						}
					}
				}
			}
		return mentions;
	}
}
