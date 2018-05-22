package it.uniba.control;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Counter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

final class MentionsWeighedRequest {
	private static String needArguments = "Command incomplete , use sna4slack for help";
	private static final int SECONDARGUMENT = 1;
	private static final int THIRDARGUMENT = 2;
	private static final int FOURTHARGUMENT = 3;

	boolean showMentionsListWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == SECONDARGUMENT) {
			System.out.println(needArguments);
		} else {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(SECONDARGUMENT, command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(SECONDARGUMENT, command));
				request.setMembers(members.getMembers());
				final List<Counter> occurence = request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.printWeighed(request.getMentions(), occurence));
				return true;
			}
		}
		return false;
	}

	boolean showMentionsListChannelWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == FOURTHARGUMENT) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(SECONDARGUMENT, command),
					util.getCommand(THIRDARGUMENT, command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(THIRDARGUMENT, command));
				request.setMembers(members.getMembers());
				final List<Counter> occurence = request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.printWeighed(request.getMentions(), occurence));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
}
