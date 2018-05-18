package it.uniba.control;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Channel;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.ControllerUtil;
import it.uniba.util.HelpPrinter;
import it.uniba.util.MembersPrinter;
import it.uniba.util.MentionsPrinter;

public class Controller {
	
	private final String command[];
	static private String needArguments = "Command incomplete , use sna4slack for help";
	static private String memberNotFound = "Member not Found";
	
	public Controller(final String... commands) {
		command = commands.clone();
	}
	
	public boolean showRequest() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0,command),"membersList")) {
			return showMembersList();
		} else if (util.compareCommand(util.getCommand(0,command),"channelsList")) {
			return showChannelsList();
		} else if (util.compareCommand(util.getCommand(0,command),"membersChannel")) {
			return showMembersChannel();
		} else if (util.compareCommand(util.getCommand(0,command),"membersSortedByChannel")) {
			return showMembersSortedByChannel();
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsList")) {
			return showMentionsList();
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListChannel")) {
			return showMentionsListChannel();
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListFrom")) {
			return showMentionsListFrom();
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListTo")) {
			return showMentionsListTo();
		} else if (util.compareCommand(util.getCommand(0,command),"sna4slack")) {
			return showHelp();
		} else {
			System.out.println("Wrong command, use sna4slack command for help");
		}
		return false;
	}
	
	private boolean showMembersList() {
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
	
	private boolean showChannelsList() {
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
	
	private boolean showMembersChannel() {
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
	
	private boolean showMembersSortedByChannel() {
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
	
	private boolean showMentionsList() {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 1) {
			System.out.println(needArguments);
		} else {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(1,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(1,command));
				request.setMembers(members.getMembers());
				request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.print(request.getMentions()));
				return true;
			}
		}
		return false;
	}
	
	private boolean showMentionsListChannel() {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(util.getCommand(1,command),util.getCommand(2,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(2,command));
				request.setMembers(members.getMembers());
				request.setNameFromTo();
				final MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.print(request.getMentions()));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
	
	private boolean showMentionsListFrom() {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(2,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(2,command));
				if (members.isInList(util.getCommand(1,command))) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFrom(request.getMentions(),util.getCommand(1,command)));
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
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFrom(request.getMentions(),util.getCommand(1,command)));
					return true;
				} else {
					System.out.println(memberNotFound);
				}
			} else {
				System.out.println(needArguments);
			}
		}
		return false;
	}
	
	private boolean showMentionsListTo() {
		final ControllerUtil util = new ControllerUtil();
		if (command.length == 3) {
			final MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(util.getCommand(2,command))) {
				final MembersAnalysis members = new MembersAnalysis();
				members.membersList(util.getCommand(2,command));
				if (members.isInList(util.getCommand(1,command))) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),util.getCommand(1,command)));
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
					request.setNameFromTo();
					final MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),util.getCommand(1,command)));
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
	
	private boolean showHelp() {
		if (command.length == 1) {
			final HelpPrinter help = new HelpPrinter();
			System.out.println(help);
			return true;
		} else {
			System.out.println("No need for more argument , just use sna4slack for help");
		}
		return false;
	}
}
