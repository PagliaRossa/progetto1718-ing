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

	boolean showMentionsListToWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == FOURTHARGUMENT) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(THIRDARGUMENT, command))) {
				final List<Counter> occurence = checkMember(request, command);
				if (occurence != null) {
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printToWeighed(request.getMentions(),
							util.getCommand(SECONDARGUMENT, command), occurence));
					return true;
				}
			}
		} else if (command.length == FIFTHARGUMENT) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(THIRDARGUMENT, command),
					util.getCommand(FOURTHARGUMENT, command))) {
				final List<Counter> occurence = checkMemberChannel(request, command);
				if (occurence != null) {
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printToWeighed(request.getMentions(),
							util.getCommand(SECONDARGUMENT, command), occurence));
					return true;
				}
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
		members.membersList(util.getCommand(THIRDARGUMENT, command));
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
		members.membersList(util.getCommand(FOURTHARGUMENT, command));
		if (members.isInList(util.getCommand(SECONDARGUMENT, command))) {
			request.setMembers(members.getMembers());
			occurence = request.setNameFromTo();
		} else {
			System.out.println(memberNotFound);
		}
		return occurence;
	}
}
