package it.uniba.util;

public class Help {
	
	private String help;
	
	public Help() {
		help = "";
		help += "These are all available command for sna4slack\n\n";
		help += "membersList zipPath                             Show members list in selected workspace with zipPath\n";
		help += "channelsList zipPath                            Show channel list in selected workspace with zipPath\n";
		help += "membersChannel channelName zipPath              Show member list in selected channel in selected workspace with zipPath\n";
		help += "membersSortedByChannel zipPath                  Show members sortedy by channel in selected workspace with zipPath\n";
		help += "mentionsList zipPath                            Show mentions list in selected workspace with zipPath\n";
		help += "mentionsListChannel channelName zipPath         Show mentions list in selected channel in selected workspace with zipPath\n";
		help += "mentionsListFrom member zipPath                 Show mentions list from selected member in selected workspace with zipPath\n";
		help += "mentionsListFrom member channel zipPath         Show mentions list from selected member in selected channel in selected workspace with zipPath\n";
		help += "mentionsListTo member zipPath                   Show mentions list to selected member in selected channel in selected workspace with zipPath\n";
		help += "mentionsListTo member channel zipPath           Show mentions list to selected member in selected channel in selected workspace with zipPath\n";
		help += "sna4slack                                       Show this help interface\n";
	}
	
	public String toString() {
		return help;
	}

}
