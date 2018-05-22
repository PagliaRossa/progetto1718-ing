package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Channel;
import it.uniba.util.JSONReader;
import it.uniba.util.ZipReader;

public final class ChannelsAnalysis extends Analysis {

	private List<Channel> channels = new ArrayList<>();

	public String getChannelName(final Channel channel) {
		return channel.getName();
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public List<String> getChannelMembers(final Channel channel) {
		return channel.getMembers();
	}

	public int getChannelMembersSize(final Channel channel) {
		return channel.membersSize();
	}

	public String getMemberInChannel(final Channel channel, final int index) {
		return channel.getMember(index);
	}

	public void setChannels(final List<Channel> channelsNew) {
		channels = channelsNew;
	}

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

	public Channel getChannel(final int index) {
		return channels.get(index);
	}

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

	public int channelsSize() {
		return channels.size();
	}

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
