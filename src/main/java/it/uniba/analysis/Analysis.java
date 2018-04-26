package it.uniba.analysis;

public class Analysis {
	
	public void help() {
		String help = new String();
		
		help += "These are all available command for sna4slack\n\n";
		help += "usersList  zipUrl                 Show users list in selected workspace with zipUrl";
		help += "sna4slack                         Show this help interface";
		
		System.out.println(help);
	}
}
