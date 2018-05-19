package it.uniba.control;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.ControllerUtil;

class ChannelsRequest {
	
	static private String needArguments = "Command incomplete , use sna4slack for help";

	boolean showChannelsList(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 2) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.channelsList(util.getCommand(1,command))) {
				final ChannelsPrinter printer = new ChannelsPrinter();
				System.out.println(printer.print(request.getChannels()));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
	
	boolean showMembersChannel(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersChannel(util.getCommand(1,command),util.getCommand(2,command))) {
				final ChannelsPrinter printer = new ChannelsPrinter();
				final Channel channel = request.getChannel(util.getCommand(1,command));
				System.out.println(printer.memberInChannelPrint(channel,request));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
	
	boolean showMembersSortedByChannel(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 2) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersSortedByChannel(util.getCommand(1,command))) {
				final ChannelsPrinter printer = new ChannelsPrinter();
				System.out.println(printer.membersSortedByChannelPrint(request));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
}
