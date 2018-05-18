package it.uniba.main;

import it.uniba.control.Controller;

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
		if (command.length > 0) {
			Controller controller = new Controller(command);
			controller.showRequest();
		} else {
			System.out.println("Needs arguments , use sna4slack for help");
		}
	}
}