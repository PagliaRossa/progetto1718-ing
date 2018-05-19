package it.uniba.util;

public class HelpPrinter {
	
	private final String help;
	
	public HelpPrinter() {
		final StringBuffer buff = new StringBuffer(1342);
		buff.append("These are all available command for sna4slack\n\n"
				+ "membersList zipPath                             Show members list in selected workspace with zipPath\n"
				+ "channelsList zipPath                            Show channel list in selected workspace with zipPath\n"
				+ "membersChannel channelName zipPath              Show member list in selected channel in selected workspace with zipPath\n"
				+ "membersSortedByChannel zipPath                  Show members sortedy by channel in selected workspace with zipPath\n"
				+ "mentionsList zipPath                            Show mentions list in selected workspace with zipPath\n"
				+ "mentionsListChannel channelName zipPath         Show mentions list in selected channel in selected workspace with zipPath\n"
				+ "mentionsListFrom member zipPath                 Show mentions list from selected member in selected workspace with zipPath\n"
				+ "mentionsListFrom member channel zipPath         Show mentions list from selected member in selected channel in selected workspace with zipPath\n"
				+ "mentionsListTo member zipPath                   Show mentions list to selected member in selected channel in selected workspace with zipPath\n"
				+ "mentionsListTo member channel zipPath           Show mentions list to selected member in selected channel in selected workspace with zipPath\n"
				+ "sna4slack                                       Show this help interface\n");
		help = buff.toString();
	}
	
	public String toString() {
		return help;
	}

}