package it.uniba.control;


import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

final class MentionsToRequest {

	private static String needArguments = "Command incomplete , use sna4slack for help";
	private static String memberNotFound = "Member not Found";
	private static final int SECONDARGUMENT = 1;
	private static final int THIRDARGUMENT = 2;
	private static final int FOURTHARGUMENT = 3;
	private static final int FIFTHARGUMENT = 4;

	boolean showMentionsListTo(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == FOURTHARGUMENT) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(THIRDARGUMENT, command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(THIRDARGUMENT, command));
				if (members.isInList(util.getCommand(SECONDARGUMENT, command))) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),
							util.getCommand(SECONDARGUMENT, command)));
					return true;
				} else {
					System.out.println(memberNotFound);
				}
			}
		} else if (command.length == FIFTHARGUMENT) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(THIRDARGUMENT, command),
					util.getCommand(FOURTHARGUMENT, command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(FOURTHARGUMENT, command));
				if (members.isInList(util.getCommand(SECONDARGUMENT, command))) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),
							util.getCommand(SECONDARGUMENT, command)));
					return true;
				} else {
					System.out.println(memberNotFound);
				}
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}

}
