package it.uniba.util;

public class ControllerUtil {

	public String getCommand(final int index , final String...commands) {
		return commands[index];
	}
	
	public boolean compareCommand(final String first,final String second) {
		return first.equals(second);
	}
}
