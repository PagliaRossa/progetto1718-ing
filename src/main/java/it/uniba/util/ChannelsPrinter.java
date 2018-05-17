package it.uniba.util;

import java.util.List;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;

public class ChannelsPrinter implements Printer {

	@SuppressWarnings("unchecked")
	@Override
	public String print(final List<?> channels) {
		final ChannelsAnalysis analysis = new ChannelsAnalysis();
		analysis.setChannels((List<Channel>)channels);
		final StringBuffer buf = new StringBuffer(60);
		buf.append("This is channels list :\n\n");
		for (int i = 0; i < channels.size(); i++) {
			buf.append(analysis.getChannelName((Channel)channels.get(i)));
			buf.append('\n');
		}
		return buf.toString();
	}
	
	public String memberInChannelPrint(final Channel channel,final ChannelsAnalysis analysis){
		final StringBuffer buf = new StringBuffer(60);
		buf.append("Members of ").append(channel.getName()).append(" :\n\n");
		for (int i = 0; i < channel.membersSize(); i++) {
			buf.append(analysis.getMemberName(channel.getMember(i)));
			buf.append('\n');
		}
		return buf.toString();
	}
	
	public String membersSortedByChannelPrint(final ChannelsAnalysis analysis) {
		final StringBuffer buf = new StringBuffer();
		for (int i = 0; i < analysis.channelsSize(); i++) {
			buf.append(analysis.getChannelName(analysis.getChannel(i)));
			buf.append(" :\n\n");
			for (int j = 0; j < analysis.getChannelMembersSize(analysis.getChannel(i)); j++) {
				buf.append("- ");
				buf.append(analysis.getMemberName(analysis.getMemberInChannel(analysis.getChannel(i),j)));
				buf.append('\n');
			}
			buf.append('\n');
		}
		return buf.toString();
	}

}
