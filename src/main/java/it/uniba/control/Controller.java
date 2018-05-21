package it.uniba.control;

import it.uniba.util.ControllerUtil;
import it.uniba.util.HelpPrinter;

public class Controller {
	
	private final String command[];
	
	public Controller(final String... commands) {
		command = commands.clone();
	}
	
	public boolean showRequest() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0,command),"membersList")) {
			final MembersRequest request = new MembersRequest();
			return request.showMembersList(command);
		} else {
			return channels();
		}
	}
	
	private boolean channels() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0,command),"channelsList")) {
			final ChannelsRequest request = new ChannelsRequest();
			return request.showChannelsList(command);
		} else if (util.compareCommand(util.getCommand(0,command),"membersChannel")) {
			final ChannelsRequest request = new ChannelsRequest();
			return request.showMembersChannel(command);
		} else if (util.compareCommand(util.getCommand(0,command),"membersSortedByChannel")) {
			final ChannelsRequest request = new ChannelsRequest();
			return request.showMembersSortedByChannel(command);
		} else {
			return mentions();
		}
	}
	
	private boolean mentions() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0,command),"mentionsList")) {
			final MentionsRequest request = new MentionsRequest();
			return request.showMentionsList(command);
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListChannel")) {
			final MentionsRequest request = new MentionsRequest();
			return request.showMentionsListChannel(command);
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListFrom")) {
			final MentionsFromRequest request = new MentionsFromRequest();
			return request.showMentionsListFrom(command);
		} else if (util.compareCommand(util.getCommand(0,command),"mentionsListTo")) {
			final MentionsToRequest request = new MentionsToRequest();
			return request.showMentionsListTo(command);
		} else {
			return weight();
		}
	}
	
	private boolean weight() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0, command), "mentionsListWeighed")) {
			final MentionsWeighedRequest request = new MentionsWeighedRequest();
			return request.showMentionsListWeighed(command);
		} else if (util.compareCommand(util.getCommand(0, command), "mentionsListChannelWeighed")) {
			final MentionsWeighedRequest request = new MentionsWeighedRequest();
			return request.showMentionsListChannelWeighed(command);
		} else if(util.compareCommand(util.getCommand(0, command), "mentionsListFromWeighed")) {
			final MentionsFromWeighedRequest request = new MentionsFromWeighedRequest();
			return request.showMentionsListFromWeighed(command);
		} else if (util.compareCommand(util.getCommand(0, command), "mentionsListToWeighed")) {
			final MentionsToWeighedRequest request = new MentionsToWeighedRequest();
			return request.showMentionsListToWeighed(command);
		} else {
			return help();
		}
		
	}
	
	private boolean help() {
		
		final ControllerUtil util = new ControllerUtil();
		
		if (util.compareCommand(util.getCommand(0,command),"sna4slack")) {
			return showHelp();
		} else {
			System.out.println("Wrong command, use sna4slack command for help");
		}
		return false;
	}
	
	private boolean showHelp() {
		if (command.length == 1) {
			final HelpPrinter help = new HelpPrinter();
			System.out.println(help);
			return true;
		} else {
			System.out.println("No need for more argument , just use sna4slack for help");
		}
		return false;
	}
}
