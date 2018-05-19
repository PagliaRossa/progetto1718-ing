package it.uniba.control;

import it.uniba.analysis.MembersAnalysis;
import it.uniba.util.ControllerUtil;
import it.uniba.util.MembersPrinter;

class MembersRequest {
	
	static private String needArguments = "Command incomplete , use sna4slack for help";
	
	boolean showMembersList(final String... command) {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 2) {
			final MembersAnalysis request = new MembersAnalysis();
			if (request.membersList(util.getCommand(1,command))) {
				final MembersPrinter printer = new MembersPrinter();
				System.out.println(printer.print(request.getMembers()));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}

}
