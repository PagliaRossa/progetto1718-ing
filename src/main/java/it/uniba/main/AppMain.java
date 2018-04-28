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
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		Analysis request = new Analysis();
		System.out.println("Welcome in sna4slack , insert command into next line");
		while(true) {
			String command = scanner.nextLine();
			if (command.startsWith("usersList"))
				request.usersList(command);
			if (command.startsWith("channelsList"))
				request.channelsList(command);
			if (command.equals("sna4slack"))
				request.help();
			if (command.equals("exit"))
				break;
			if ((!command.equals("sna4slack") && (!command.equals("exit"))) && (!command.startsWith("usersList")) && (!command.startsWith("channelsList")))
				System.out.println("Wrong command , use sna4slack command for help !");
		}
	}

}
