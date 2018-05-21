package it.uniba.control;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Counter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

public class MentionsFromWeighedRequest {
	
	static private String needArguments = "Command incomplete , use sna4slack for help";
	static private String memberNotFound = "Member not Found";
	
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
				if (members.isInList(util.getCommand(1,command))) {
					request.setMembers(members.getMembers());
					final List<Counter> occurence = request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFromWeighed(request.getMentions(),util.getCommand(1,command), occurence));
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
