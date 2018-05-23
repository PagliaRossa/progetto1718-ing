package it.uniba.control;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Counter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

final class MentionsToWeighedRequest {

	private static String needArguments = "Command incomplete , use sna4slack for help";
	private static String memberNotFound = "Member not Found";
	private static final int SECONDARGUMENT = 1;
	private static final int THIRDARGUMENT = 2;
	private static final int FOURTHARGUMENT = 3;
	private static final int FIFTHARGUMENT = 4;
	private static final int SIXTHARGUMENT = 5;

	boolean showMentionsListToWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == FIFTHARGUMENT) {
			final int over = checkNumber(command);
			if (over >= 0) {
				final MentionsAnalysis request = new MentionsAnalysis();
				if (request.mentionsList(util.getCommand(FOURTHARGUMENT, command))) {
					final List<Counter> occurence = checkMember(request, command);
					if (occurence != null) {
						final MentionsPrinter printer = new MentionsPrinter();
						System.out.println(printer.printToWeighed(request.getMentions(),
								util.getCommand(SECONDARGUMENT, command), occurence, over));
						return true;
					}
				}
			} else {
				System.out.println("Number not valid!");
			}
		} else if (command.length == SIXTHARGUMENT) {
			final int over = checkNumberChannel(command);
			if (over >= 0) {
				final MentionsAnalysis request = new MentionsAnalysis();
				if (request.mentionsListChannel(util.getCommand(THIRDARGUMENT, command),
						util.getCommand(FIFTHARGUMENT, command))) {
					final List<Counter> occurence = checkMemberChannel(request, command);
					if (occurence != null) {
						final MentionsPrinter printer = new MentionsPrinter();
						System.out.println(printer.printToWeighed(request.getMentions(),
								util.getCommand(SECONDARGUMENT, command), occurence, over));
						return true;
					}
				}
			} else {
				System.out.println("Number not valid!");
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}

	private List<Counter> checkMember(final MentionsAnalysis request, final String...command) {
		List<Counter> occurence = null;
		final MembersAnalysis members = new MembersAnalysis();
		final ControllerUtil util = new ControllerUtil();
		members.membersList(util.getCommand(FOURTHARGUMENT, command));
		if (members.isInList(util.getCommand(SECONDARGUMENT, command))) {
			request.setMembers(members.getMembers());
			occurence = request.setNameFromTo();
		} else {
			System.out.println(memberNotFound);
		}
		return occurence;
	}

	private List<Counter> checkMemberChannel(final MentionsAnalysis request, final String...command) {
		List<Counter> occurence = null;
		final MembersAnalysis members = new MembersAnalysis();
		final ControllerUtil util = new ControllerUtil();
		members.membersList(util.getCommand(FIFTHARGUMENT, command));
		if (members.isInList(util.getCommand(SECONDARGUMENT, command))) {
			request.setMembers(members.getMembers());
			occurence = request.setNameFromTo();
		} else {
			System.out.println(memberNotFound);
		}
		return occurence;
	}

	private int checkNumber(final String...command) {
		final ControllerUtil util = new ControllerUtil();
		try {
			return Integer.parseInt(util.getCommand(THIRDARGUMENT, command));
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private int checkNumberChannel(final String...command) {
		final ControllerUtil util = new ControllerUtil();
		try {
			return Integer.parseInt(util.getCommand(FOURTHARGUMENT, command));
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
