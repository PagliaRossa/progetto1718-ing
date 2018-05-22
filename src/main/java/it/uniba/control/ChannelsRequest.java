package it.uniba.control;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.ControllerUtil;

final class ChannelsRequest {

	private static String needArguments = "Command incomplete , use sna4slack for help";
	private static final int SECONDARGUMENT = 1;
	private static final int THIRDARGUMENT = 2;
	private static final int FOURTHARGUMENT = 3;

	boolean showChannelsList(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == THIRDARGUMENT) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.channelsList(util.getCommand(SECONDARGUMENT, command))) {
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
		if (command.length == FOURTHARGUMENT) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersChannel(util.getCommand(SECONDARGUMENT, command),
					util.getCommand(THIRDARGUMENT, command))) {
				final ChannelsPrinter printer = new ChannelsPrinter();
				final Channel channel = request.getChannel(util.getCommand(SECONDARGUMENT, command));
				System.out.println(printer.memberInChannelPrint(channel, request));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}

	boolean showMembersSortedByChannel(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == THIRDARGUMENT) {
			final ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersSortedByChannel(util.getCommand(SECONDARGUMENT, command))) {
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
