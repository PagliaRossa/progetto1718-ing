package it.uniba.util;

import java.util.List;

/**
 * Interface that print a list.
 */
public interface Printer {

	/**
	 * Abstract method for print a list.
	 * @param list List of object
	 * @return String - List of object as String
	 */
	String print(List<?> list);

}
