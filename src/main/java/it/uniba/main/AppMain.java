package it.uniba.main;

import java.util.Scanner;

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
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] command) {
		Analysis request = new Analysis();
			if (command[0].equals("usersList") && (command[1] != null)) {
					if(request.usersList(command[1])) {
						System.out.println(request.printUsers());
					}
			}
			if (command[0].equals("channelsList") && (command[1] != null)) {
					if (request.channelsList(command[1])) {
						System.out.println(request.printChannels());
				}
			}
			if (command[0].equals("membersChannel")) {
				if (command[1] != null && command[2] != null) {
					request.membersChannel(command[1],command[2]);
				}
			}
			if (command[0].equals("usersSortedByChannel") && command[1] != null) {
				request.usersSortedByChannel(command[1]);
			}
			if (command[0].equals("sna4slack")) {
				request.help();
			}
			if ((!command[0].equals("usersList") && (!command[0].equals("channelsList"))
				&& (!command[0].equals("membersChannel")) && (!command[0].equals("usersSortedByChannel"))
				&& (!command[0].equals("sna4slack"))))
					System.out.println("Wrong command, use sna4slack command for help");
		}
}