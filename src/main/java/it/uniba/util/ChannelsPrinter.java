package it.uniba.util;

import java.util.List;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;

public class ChannelsPrinter implements Printer {

	@Override
	public String print(final List<?> channels) {
		StringBuffer buf = new StringBuffer();
		buf.append("This is channels list :\n\n");
		for (int i = 0; i < channels.size(); i++) {
			buf.append(((Channel) channels.get(i)).getName());
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public String memberInChannelPrint(Channel channel,ChannelsAnalysis analysis,String name) {
		StringBuffer buf = new StringBuffer();
		buf.append("Members of ");
		buf.append(name);
		buf.append(" :\n\n");
		for (int i = 0; i < channel.membersSize(); i++) {
			buf.append(analysis.getMemberName(channel.getMember(i)));
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public String membersSortedByChannelPrint(ChannelsAnalysis analysis) {
		StringBuffer buf = new StringBuffer();
		List<Channel> channels = analysis.getChannels();
		for (int i = 0; i < channels.size(); i++) {
			buf.append(channels.get(i).getName());
			buf.append(" :\n\n");
			List<String> members = channels.get(i).getMembers();
			for (int j = 0; j < members.size(); j++) {
				buf.append("- ");
				buf.append(analysis.getMemberName(members.get(j)));
				buf.append("\n");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

}
