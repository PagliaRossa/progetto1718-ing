package it.uniba.util;

/**
 * Utils for Controller class.
 */
public final class ControllerUtil {

	/**
	 * Get string of commands at index.
	 * @param index Index of commands
	 * @param commands Array of Strings
	 * @return String - Return requested string
	 */
	public String getCommand(final int index, final String...commands) {
		return commands[index];
	}

	/**
	 * Compare two Strings and return true or false if they are same.
	 * @param first First String
	 * @param second Second String
	 * @return boolean - true or false if same
	 */
	public boolean compareCommand(final String first, final String second) {
		return first.equals(second);
	}
}
