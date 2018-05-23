package it.uniba.main;

import java.util.Arrays;

import it.uniba.control.Controller;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 * 
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

	/**
	 * Boolean that checks if main returns true or false.
	 */
	private static boolean check;
	/**
	 * Private constructor. Change if needed.
	 */
	private AppMain() {

	}

	/**
	 * Get check.
	 * @return check - True or false
	 */
	public static boolean isCheck() {
		return check;
	}

	/**
	 * This is the main entry of the application.
	 *
	 * @param command
	 *            The command-line arguments.
	 */
	public static void main(final String[] command) {
		check = checkBoolean(command);
	}

	/**
	 * Check returning boolean of Controller showRequest.
	 * @param command command-line arguments
	 * @return boolean - true or false
	 */
	public static boolean checkBoolean(final String... command) {
		if (command.length > 0) {
			final Controller controller = new Controller(Arrays.copyOf(command, command.length));
			return controller.showRequest();
		} else {
			System.out.println("Needs arguments , use sna4slack for help");
			return false;
		}
	}

}
