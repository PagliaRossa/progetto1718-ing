package it.uniba.main;

import java.util.Scanner;
import it.uniba.analysis.*;

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
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		Analysis request = new Analysis();
		while(true) {
			System.out.println("Insert command: ");
			
			String command = scanner.nextLine();
			//if (command.startsWith("users list"))
			//	request.usersList();
			//if (command.startsWith("channel list"))
				//request.channelList();
			//if (command.startsWith("users sorted by channel"))
				//request.usersSortedByChannel();
			//if (command.startsWith("channel members"))
				//request.channelMembers(command);
			if (command.equals("sna4slack"))
				request.help();
			else System.out.println("Wrong command , use sna4slack command for help\n");
		}
	}

}
