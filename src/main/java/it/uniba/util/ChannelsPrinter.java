package it.uniba.util;

import java.util.List;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;

public class ChannelsPrinter implements Printer {

	@Override
	public String print(final List<?> channels) {
		String str = "";
		str += "This is channels list :\n\n";
		for (int i = 0; i < channels.size(); i++) {
			str += ((Channel) channels.get(i)).getName() + "\n";
		}
		return str;
	}
	
	public String memberInChannelPrint(Channel channel,ChannelsAnalysis analysis,String name) {
		String str = "Members of " + name + " :\n\n";
		for (int i = 0; i < channel.membersSize(); i++) {
			str += analysis.getMemberName(channel.getMember(i)) + "\n";
		}
		return str;
	}
	
	public String membersSortedByChannelPrint(ChannelsAnalysis analysis) {
		String str = "";
		List<Channel> channels = analysis.getChannels();
		for (int i = 0; i < channels.size(); i++) {
			str += channels.get(i).getName() + " :\n\n";
			List<String> members = channels.get(i).getMembers();
			for (int j = 0; j < members.size(); j++) {
				str += "- " + analysis.getMemberName(members.get(j)) + "\n";
			}
			str += "\n";
		}
		return str;
	}

}
