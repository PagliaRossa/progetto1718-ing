package it.uniba.main;

import it.uniba.analysis.Analysis;
import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Channel;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.Help;
import it.uniba.util.MembersPrinter;
import it.uniba.util.MentionsPrinter;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 * 
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

	/**
	 * Private constructor. Change if needed.
	 */
	private AppMain() {

	}

	/**
	 * This is the main entry of the application.
	 *
	 * @param command
	 *            The command-line arguments.
	 */
	public static void main(final String[] command) {
		Analysis request;
		if (!(command.length == 0)) {
			if (command[0].equals("membersList")) {
				if (command.length != 1) {
					request = new MembersAnalysis();
					if (((MembersAnalysis) request).membersList(command[1])) {
						MembersPrinter printer = new MembersPrinter();
						System.out.println(printer.print(request.getMembers()));
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("channelsList")) {
				if (command.length != 1) {
					request = new ChannelsAnalysis();
					if (((ChannelsAnalysis) request).channelsList(command[1])) {
						ChannelsPrinter printer = new ChannelsPrinter();
						System.out.println(printer.print(((ChannelsAnalysis)request).getChannels()));
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("membersChannel")) {
				if (command.length == 3) {
					request = new ChannelsAnalysis();
					if (((ChannelsAnalysis) request).membersChannel(command[1],command[2])) {
						ChannelsPrinter printer = new ChannelsPrinter();
						Channel channel = ((ChannelsAnalysis)request).getChannel(command[1]);
						System.out.println(printer.memberInChannelPrint(channel,(ChannelsAnalysis)request));
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("membersSortedByChannel")) {
				if (command.length != 1) {
					request = new ChannelsAnalysis();
					if (((ChannelsAnalysis)request).membersSortedByChannel(command[1])) {
						ChannelsPrinter printer = new ChannelsPrinter();
						System.out.println(printer.membersSortedByChannelPrint((ChannelsAnalysis)request));
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("mentionsList")) {
				if (command.length == 1) {
					System.out.println("Command incomplete , use sna4slack for help");
				} else {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis) request).mentionsList(command[1])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[1]);
							request.setMembers(members.getMembers());
							((MentionsAnalysis) request).setNameFromTo();
							MentionsPrinter printer = new MentionsPrinter();
							System.out.println(printer.print(((MentionsAnalysis)request).getMentions()));
						} else {
							System.out.println("Can't find mentions");
						}
					}
				}
			}
			
			if (command[0].equals("mentionsListChannel")) {
				if (command.length == 3) {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis) request).mentionsListChannel(command[1],command[2])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[2]);
							request.setMembers(members.getMembers());
							((MentionsAnalysis) request).setNameFromTo();
							MentionsPrinter printer = new MentionsPrinter();
							System.out.println(printer.print(((MentionsAnalysis) request).getMentions()));
						} else {
							System.out.println("Can't find mentions");
						}
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("mentionsListFrom")) {
				if (command.length == 3) {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis)request).mentionsList(command[2])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[2]);
							if (members.isInList(command[1])) {
								request.setMembers(members.getMembers());
								((MentionsAnalysis) request).setNameFromTo();
								MentionsPrinter printer = new MentionsPrinter();
								System.out.println(printer.printFrom(((MentionsAnalysis)request).getMentions(),command[1]));
							} else {
								System.out.println("Member not found");
							}
						} else {
							System.out.println("Can't find mentions");
						}
					}
				} else if (command.length == 4) {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis)request).mentionsListChannel(command[2],command[3])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[3]);
							if (members.isInList(command[1])){
								request.setMembers(members.getMembers());
								((MentionsAnalysis) request).setNameFromTo();
								MentionsPrinter printer = new MentionsPrinter();
								System.out.println(printer.printFrom(((MentionsAnalysis)request).getMentions(),command[1]));
							} else {
								System.out.println("Member not found");
							}
						} else {
							System.out.println("Can't find mentions");
						}
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("mentionsListTo")) {
				if (command.length == 3) {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis)request).mentionsList(command[2])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[2]);
							if (members.isInList(command[1])) {
								request.setMembers(members.getMembers());
								((MentionsAnalysis) request).setNameFromTo();
								MentionsPrinter printer = new MentionsPrinter();
								System.out.println(printer.printTo(((MentionsAnalysis)request).getMentions(),command[1]));
							} else {
								System.out.println("Member not found");
							}
						} else {
							System.out.println("Can't find mentions");
						}
					}
				} else if (command.length == 4) {
					request = new MentionsAnalysis();
					if (((MentionsAnalysis)request).mentionsListChannel(command[2],command[3])) {
						if (!((MentionsAnalysis) request).isEmpty()) {
							MembersAnalysis members = new MembersAnalysis();
							members.membersList(command[3]);
							if (members.isInList(command[1])) {
								request.setMembers(members.getMembers());
								((MentionsAnalysis) request).setNameFromTo();
								MentionsPrinter printer = new MentionsPrinter();
								System.out.println(printer.printTo(((MentionsAnalysis)request).getMentions(),command[1]));
							} else {
								System.out.println("Member not found");
							}
						} else {
							System.out.println("Can't find mentions");
						}
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			
			if (command[0].equals("sna4slack")) {
				if (command.length == 1) {
					Help help = new Help();
					System.out.println(help);
				} else {
					System.out.println("No need for more argument , just use sna4slack for help");
				}
			}
			
			if (!command[0].equals("membersList") && !command[0].equals("channelsList")
					&& !command[0].equals("membersChannel") && !command[0].equals("membersSortedByChannel")
					&& !command[0].equals("sna4slack") && !command[0].equals("mentionsList") && !command[0].equals("mentionsListChannel")
					&& !command[0].equals("mentionsListFrom") && !command[0].equals("mentionsListTo")) {
						System.out.println("Wrong command, use sna4slack command for help");
				}
			
		} else {
			System.out.println("Needs arguments , use sna4slack for help");
		}
	}
}