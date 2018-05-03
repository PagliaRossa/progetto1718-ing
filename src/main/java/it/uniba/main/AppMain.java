package it.uniba.main;

import it.uniba.analysis.Analysis;

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
		Analysis request = new Analysis();
			if (command[0].equals("membersList")) {
				if (command.length != 1) {
					if (request.membersList(command[1])) {
						System.out.println(request.printMembers());
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			if (command[0].equals("channelsList")) {
				if (command.length != 1) {
					if (request.channelsList(command[1])) {
						System.out.println(request.printChannels());
					}
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			if (command[0].equals("membersChannel")) {
				if (command.length != 2) {
					request.membersChannel(command[1],command[2]);
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			if (command[0].equals("membersSortedByChannel")) {
				if (command.length != 1) {
					request.membersSortedByChannel(command[1]);
				} else {
					System.out.println("Command incomplete , use sna4slack for help");
				}
			}
			if (command[0].equals("sna4slack")) {
				if (command.length == 1) {
					request.help();
				} else {
					System.out.println("No need for more argument , just use sna4slack for help");
				}
			}
			if ((!command[0].equals("membersList") && (!command[0].equals("channelsList"))
				&& (!command[0].equals("membersChannel")) && (!command[0].equals("membersSortedByChannel"))
				&& (!command[0].equals("sna4slack"))))
					System.out.println("Wrong command, use sna4slack command for help");
		}
}