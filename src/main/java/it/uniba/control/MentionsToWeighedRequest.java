package it.uniba.control;

import java.util.List;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Counter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MentionsPrinter;

public class MentionsToWeighedRequest {
	
	static private String needArguments = "Command incomplete , use sna4slack for help";
	static private String memberNotFound = "Member not Found";
	
	boolean showMentionsListToWeighed(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 4) {
			final int over = Integer.parseInt(util.getCommand(2, command));
			if (over >= 0) {
				final MentionsAnalysis request = new MentionsAnalysis();
				if (request.mentionsList(util.getCommand(3,command))) {
					final List<Counter> occurence = checkMember(request,command);
					if (occurence != null) {
						final MentionsPrinter printer = new MentionsPrinter();
						System.out.println(printer.printToWeighed(request.getMentions(),util.getCommand(1,command),occurence,over));
						return true;
					}
				}
			} else {
				System.out.println("Number not valid!");
			}
		} else if (command.length == 5) {
			final int over = Integer.parseInt(util.getCommand(3, command));
			if (over >= 0) {
				final MentionsAnalysis request = new MentionsAnalysis();
				if (request.mentionsListChannel(util.getCommand(2,command),util.getCommand(4,command))) {
					final List<Counter> occurence = checkMemberChannel(request,command);
					if (occurence != null) {
						final MentionsPrinter printer = new MentionsPrinter();
						System.out.println(printer.printToWeighed(request.getMentions(),util.getCommand(1,command),occurence,over));
						return true;
					}
				}
			} else {
				System.out.println("Number not valid");
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
	
	private List<Counter> checkMember(final MentionsAnalysis request,final String...command) {
		List<Counter> occurence = null;
		final MembersAnalysis members = new MembersAnalysis();
		final ControllerUtil util = new ControllerUtil();
		members.membersList(util.getCommand(3,command));
		if (members.isInList(util.getCommand(1,command))) {
			request.setMembers(members.getMembers());
			occurence = request.setNameFromTo();
		} else {
			System.out.println(memberNotFound);
		}
		return occurence;
	}
	
	private List<Counter> checkMemberChannel(final MentionsAnalysis request,final String...command) {
		List<Counter> occurence = null;
		final MembersAnalysis members = new MembersAnalysis();
		final ControllerUtil util = new ControllerUtil();
		members.membersList(util.getCommand(4,command));
		if (members.isInList(util.getCommand(1,command))) {
			request.setMembers(members.getMembers());
			occurence = request.setNameFromTo();
		} else {
			System.out.println(memberNotFound);
		}
		return occurence;
	}

}
