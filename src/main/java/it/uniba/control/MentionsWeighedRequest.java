package it.uniba.control;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Counter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

class MentionsWeighedRequest {
	static private String memberNotFound = "Member not Found";	
	static private String needArguments = "Command incomplete , use sna4slack for help";
	
	boolean showMentionsListWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 1) {
			System.out.println(needArguments);
		} else {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(1,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(1,command));
				request.setMembers(members.getMembers());
				final List<Counter> occurence = request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.printWeighed(request.getMentions(),occurence));
				return true;
			}
		}
		return false;
	}
	
	boolean showMentionsListChannelWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(1,command),util.getCommand(2,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(2,command));
				request.setMembers(members.getMembers());
				final List<Counter> occurence = request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.printWeighed(request.getMentions(),occurence));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}

	boolean showMentionsListFromWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(2,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(2,command));
				if (members.isInList(util.getCommand(1,command))) {
					request.setMembers(members.getMembers());
					final List<Counter> occurence = request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFromWeighed(request.getMentions(),util.getCommand(1,command),occurence));
					return true;
				} else {
					System.out.println(memberNotFound);
				}
			}
		} else if (command.length == 4) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(2,command),util.getCommand(3,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(3,command));
				if (members.isInList(util.getCommand(1,command))){
					request.setMembers(members.getMembers());
					final List<Counter> occurence = request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFromWeighed(request.getMentions(),util.getCommand(1,command), occurence));
					return true;
					}
				} else {
					System.out.println(memberNotFound);
				}
			} else {
				System.out.println(needArguments);
			}
		return false;
	}

	boolean showMentionsListToWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 4) {
			int over = Integer.parseUnsignedInt(util.getCommand(2, command));
			try {
				if (over >= 0) {
					final MentionsAnalysis request = new MentionsAnalysis();
					if (request.mentionsList(util.getCommand(3,command))) {
						final MembersAnalysis members = new MembersAnalysis();
						members.membersList(util.getCommand(3,command));
						if (members.isInList(util.getCommand(1,command))) {
							request.setMembers(members.getMembers());
							List<Counter> occurence = request.setNameFromTo();
							final MentionsPrinter printer = new MentionsPrinter();
							System.out.println(printer.printToWeighed(request.getMentions(),util.getCommand(1,command),occurence,over));
							return true;
						} else {
							System.out.println(memberNotFound);
						}
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Number not valid!");
			}
		} else if (command.length == 5) {
			int over = Integer.parseUnsignedInt(util.getCommand(3, command));
			try {
				if (over >= 0) {
					final MentionsAnalysis request = new MentionsAnalysis();
					if (request.mentionsListChannel(util.getCommand(2,command),util.getCommand(4,command))) {
						final MembersAnalysis members = new MembersAnalysis();
						members.membersList(util.getCommand(4,command));
						if (members.isInList(util.getCommand(1,command))) {
							request.setMembers(members.getMembers());
							List<Counter> occurence = request.setNameFromTo();
							final MentionsPrinter printer = new MentionsPrinter();
							System.out.println(printer.printToWeighed(request.getMentions(),util.getCommand(1,command),occurence,over));
							return true;
						} else {
							System.out.println(memberNotFound);
						}
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Number not valid");
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
}
