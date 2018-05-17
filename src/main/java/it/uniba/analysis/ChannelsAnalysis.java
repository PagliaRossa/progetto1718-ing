package it.uniba.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import it.uniba.data.Channel;
import it.uniba.util.JSON;
import it.uniba.util.Zip;

public class ChannelsAnalysis extends Analysis {
	
	private List<Channel> channels = new ArrayList<>();
	
	private String getChannelName(final Channel channel) {
		return channel.getName();
	}
	
	public List<Channel> getChannels() {
		return channels;
	}
	
	public void setChannels(final List<Channel> channelsNew) {
		channels = channelsNew;
	}
	
	public boolean channelExist(final String channel) {
		boolean found = false;
		for (int i = 0; i < channels.size(); i++) {
			if (compareName(getChannelName(channels.get(i)),channel)) {
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
		for (int i = 0; i < channels.size() ; i++) {
			if (compareName(getChannelName(channels.get(i)),name)) {
				channel = channels.get(i);
				break;
			}
		}
		return channel;
	}
	
	public boolean channelsList(final String input) {
		try {
			final Zip zip = new Zip();
			final String json = zip.setChannelsFile(input);
			final JSON setter = new JSON();
			channels = setter.setChannels(json);
			return true;
		} catch (ParseException p) {
			System.out.println("JSON not valid!");
		} catch (IOException i) {
			System.out.println("File not found or invalid");
		}
		return false;
	}
	
	public boolean membersChannel(final String channel,final String path) {
		final MembersAnalysis members = new MembersAnalysis();
		if (members.membersList(path)) {
			this.members = members.getMembers();
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
			this.members = members.getMembers();
			if (channelsList(input)) {
				return true;
			}
		}
		return false;
	}

}
