package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Channel;
import it.uniba.util.JSONReader;
import it.uniba.util.ZipReader;
/**
 * 
 * Subclass of Analysis.
 * Analyzes Channel of zipFile.
 *
 */
public class ChannelsAnalysis extends Analysis {

	private List<Channel> channels = new ArrayList<>();

	/**
	 * Get Name of Channel in zipFile.
	 * @param channel Channel Analyzed
	 * @return channel.getName - Name of Specific Channel
	 */
	public String getChannelName(final Channel channel) {
		return channel.getName();
	}

	/**
	 * Get List of Channel.
	 * @return channels - List of Channels
	 */
	public List<Channel> getChannels() {
		return channels;
	}

	/**
	 * Get Member of Channel in zipFile.
	 * @param channel Channel Analyzed
	 * @return List of Strings that Contains all Channel Members
	 */
	public List<String> getChannelMembers(final Channel channel) {
		return channel.getMembers();
	}

	/**
	 * Get Size of Channel Members.
	 * @param channel Channel Analyzed
	 * @return Integer of Size of Channel Members
	 */
	public int getChannelMembersSize(final Channel channel) {
		return channel.membersSize();
	}

	/**
	 * Get Specific Member of Channel in zipFile.
	 * @param channel Channel Analyzed
	 * @param index Index of Specific Member
	 * @return String of Name of Member (using ID)
	 */
	public String getMemberInChannel(final Channel channel, final int index) {
		return channel.getMember(index);
	}

	/**
	 * Set List of all Channels.
	 * @param channelsNew List of all Channels
	 */
	public void setChannels(final List<Channel> channelsNew) {
		channels = channelsNew;
	}

	/**
	 * Control if Channel Exists.
	 * @param channel Name of channel
	 * @return Boolean of of accomplished (or not) Control
	 */
	public boolean channelExist(final String channel) {
		boolean found = false;
		for (int i = 0; i < channels.size(); i++) {
			if (compareName(getChannelName(channels.get(i)), channel)) {
				found = true;
				break;
			}
		}
		return found;
	}

	/**
	 * Get Specific Channel in zipFile.
	 * @param index ID of Specific Channel
	 * @return Channel Required
	 */
	public Channel getChannel(final int index) {
		return channels.get(index);
	}

	/**
	 * Search Specific Channel from zipFile, using Channel Name.
	 * @param name Name of Channel
	 * @return Channel Required
	 */
	public Channel getChannel(final String name) {
		Channel channel = null;
		for (int i = 0; i < channels.size(); i++) {
			if (compareName(getChannelName(channels.get(i)), name)) {
				channel = channels.get(i);
				break;
			}
		}
		return channel;
	}

	/**
	 * Size of Members in Channel.
	 * @return Integer of Size of Member in Channel
	 */
	public int channelsSize() {
		return channels.size();
	}

	/**
	 * Search the Channel List in zipFile.
	 * @param input Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean channelsList(final String input) {
		try {
			final ZipReader zip = new ZipReader();
			final String json = zip.setChannelsFile(input);
			final JSONReader setter = new JSONReader();
			channels = setter.setChannels(json);
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}

	/**
	 * List of Members in Specific Channel in zipFile.
	 * @param channel Name of Channel
	 * @param path Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean membersChannel(final String channel, final String path) {
		final MembersAnalysis members = new MembersAnalysis();
		if (members.membersList(path)) {
			setMembers(members.getMembers());
			if (channelsList(path)) {
				if (channelExist(channel)) {
					return true;
				} else {
					System.out.println("Channel not found");
				}
			}
		}
		return false;
	}

	/**
	 * List of all Members in their Channels
	 * @param input Path of zipFile
	 * @return Boolean of Accomplished (or not) Operation
	 */
	public boolean membersSortedByChannel(final String input) {
		final MembersAnalysis members = new MembersAnalysis();
		if (members.membersList(input)) {
			setMembers(members.getMembers());
			if (channelsList(input)) {
				return true;
			}
		}
		return false;
	}

}
