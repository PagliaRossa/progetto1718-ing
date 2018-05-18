package it.uniba.control;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Channel;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.HelpPrinter;
import it.uniba.util.MembersPrinter;
import it.uniba.util.MentionsPrinter;

public class Controller {
	
	private String command[];
	private String needArguments = "Command incomplete , use sna4slack for help";
	
	public Controller(String[] commands) {
		command = commands;
	}
	
	public boolean showRequest() {
		
		if (command[0].equals("membersList")) {
			return showMembersList();
		} else if (command[0].equals("channelsList")) {
			return showChannelsList();
		} else if (command[0].equals("membersChannel")) {
			return showMembersChannel();
		} else if (command[0].equals("membersSortedByChannel")) {
			return showMembersSortedByChannel();
		} else if (command[0].equals("mentionsList")) {
			return showMentionsList();
		} else if (command[0].equals("mentionsListChannel")) {
			return showMentionsListChannel();
		} else if (command[0].equals("mentionsListFrom")) {
			return showMentionsListFrom();
		} else if (command[0].equals("mentionsListTo")) {
			return showMentionsListTo();
		} else if (command[0].equals("sna4slack")) {
			return showHelp();
		} else {
			System.out.println("Wrong command, use sna4slack command for help");
		}
		return false;
	}
	
	private boolean showMembersList() {
		if (command.length != 1) {
			MembersAnalysis request = new MembersAnalysis();
			if (request.membersList(command[1])) {
				MembersPrinter printer = new MembersPrinter();
				System.out.println(printer.print(request.getMembers()));
				return true;
			}
		} else {
			System.out.println(needArguments);
		}
		return false;
	}
	
	private boolean showChannelsList() {
		if (command.length != 1) {
			ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.channelsList(command[1])) {
				ChannelsPrinter printer = new ChannelsPrinter();
				System.out.println(printer.print(request.getChannels()));
				return true;
			}
		} else {
			System.out.println(this.needArguments);
		}
		return false;
	}
	
	private boolean showMembersChannel() {
		if (command.length == 3) {
			ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersChannel(command[1],command[2])) {
				ChannelsPrinter printer = new ChannelsPrinter();
				Channel channel = request.getChannel(command[1]);
				System.out.println(printer.memberInChannelPrint(channel,request));
				return true;
			}
		} else {
			System.out.println("Command incomplete , use sna4slack for help");
		}
		return false;
	}
	
	private boolean showMembersSortedByChannel() {
		if (command.length != 1) {
			ChannelsAnalysis request = new ChannelsAnalysis();
			if (request.membersSortedByChannel(command[1])) {
				ChannelsPrinter printer = new ChannelsPrinter();
				System.out.println(printer.membersSortedByChannelPrint(request));
				return true;
			}
		} else {
			System.out.println(this.needArguments);
		}
		return false;
	}
	
	private boolean showMentionsList() {
		if (command.length == 1) {
			System.out.println(this.needArguments);
		} else {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(command[1])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[1]);
				request.setMembers(members.getMembers());
				request.setNameFromTo();
				MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.print(request.getMentions()));
				return true;
			}
		}
		return false;
	}
	
	private boolean showMentionsListChannel() {
		if (command.length == 3) {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(command[1],command[2])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[2]);
				request.setMembers(members.getMembers());
				request.setNameFromTo();
				MentionsPrinter printer = new MentionsPrinter();
				System.out.println(printer.print(request.getMentions()));
				return true;
			}
		} else {
			System.out.println(this.needArguments);
		}
		return false;
	}
	
	private boolean showMentionsListFrom() {
		if (command.length == 3) {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(command[2])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[2]);
				if (members.isInList(command[1])) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFrom(request.getMentions(),command[1]));
					return true;
				} else {
					System.out.println("Member not found");
				}
			}
		} else if (command.length == 4) {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(command[2],command[3])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[3]);
				if (members.isInList(command[1])){
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printFrom(request.getMentions(),command[1]));
					return true;
				} else {
					System.out.println("Member not found");
				}
			} else {
				System.out.println(this.needArguments);
			}
		}
		return false;
	}
	
	private boolean showMentionsListTo() {
		if (command.length == 3) {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsList(command[2])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[2]);
				if (members.isInList(command[1])) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),command[1]));
					return true;
				} else {
					System.out.println("Member not found");
				}
			}
		} else if (command.length == 4) {
			MentionsAnalysis request = new MentionsAnalysis();
			if (request.mentionsListChannel(command[2],command[3])) {
				MembersAnalysis members = new MembersAnalysis();
				members.membersList(command[3]);
				if (members.isInList(command[1])) {
					request.setMembers(members.getMembers());
					request.setNameFromTo();
					MentionsPrinter printer = new MentionsPrinter();
					System.out.println(printer.printTo(request.getMentions(),command[1]));
					return true;
				} else {
					System.out.println("Member not found");
				}
			}
		} else {
			System.out.println(this.needArguments);
		}
		return false;
	}
	
	private boolean showHelp() {
		if (command.length == 1) {
			HelpPrinter help = new HelpPrinter();
			System.out.println(help);
			return true;
		} else {
			System.out.println("No need for more argument , just use sna4slack for help");
		}
		return false;
	}
}
