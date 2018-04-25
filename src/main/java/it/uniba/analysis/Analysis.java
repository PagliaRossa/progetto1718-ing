package it.uniba.analysis;

public class Analysis {
	
	//TODO
	//void usersList();
	
	//TODO
	//void channelList();
	
	//TODO
	//void usersSortedByChannel();
	
	//TODO
	//void channelMembers(String channel);
	
	public void help() {
		String help = new String();
		
		help += "These are all available command for sna4slack\n\n";
		help += "usersList                               Show users list\n";
		help += "channelList                             Show channel list\n";
		help += "usersSortedByChannel                    Show users sorted by channel\n";
		help += "channelMembers channelname              Show users member of seleceted channel\n";
		help += "sna4slack                               Show this help interface";
		
		System.out.println(help);
	}

}
