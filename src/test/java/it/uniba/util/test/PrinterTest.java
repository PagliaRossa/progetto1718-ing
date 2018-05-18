package it.uniba.util.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;
import it.uniba.data.Member;
import it.uniba.data.Mention;
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.MembersPrinter;
import it.uniba.util.MentionsPrinter;

public class PrinterTest {
	
	@Test
	@DisplayName("Test members print")
	void PrintMember() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("0","Donato");
		members.add(member);
		MembersPrinter printer = new MembersPrinter();
		String test = "This is users list :\n\nDonato\n";
		assertEquals(test,printer.print(members));
		assertNotEquals("ciao",printer.print(members));
	}
	
	@Test
	@DisplayName("Test channels print")
	void PrintChannels() {
		List<Channel> channels = new ArrayList<>();
		List<String> membersArray = new ArrayList<>();
		membersArray.add("0");
		membersArray.add("1");
		membersArray.add("2");
		List<Member> members = new ArrayList<>();
		members.add(new Member("0","Donato"));
		members.add(new Member("1","Giacomo"));
		members.add(new Member("2","Marco"));
		Channel channel = new Channel("0","Test",membersArray);
		channels.add(channel);
		ChannelsPrinter printer = new ChannelsPrinter();
		String test = "This is channels list :\n\nTest\n";
		assertEquals(test,printer.print(channels));
		assertNotEquals("ciao",printer.print(channels));
		ChannelsAnalysis testing = new ChannelsAnalysis();
		testing.setChannels(channels);
		testing.setMembers(members);
		assertEquals("Members of Test :\n\nDonato\nGiacomo\nMarco\n",printer.memberInChannelPrint(channel,testing));
		assertEquals("Test :\n\n- Donato\n- Giacomo\n- Marco\n\n",printer.membersSortedByChannelPrint(testing));
	}
	
	@Test
	@DisplayName("Test mentions print")
	void PrintMentions() {
		List<Mention> mentions = new ArrayList<>();
		Mention mention = new Mention("From","To");
		mentions.add(mention);
		MentionsPrinter printer = new MentionsPrinter();
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.print(mentions));
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printFrom(mentions, "From"));
		assertEquals("Can't find mentions for this member",printer.printFrom(mentions,"luigi"));
		assertEquals("Can't find mentions for this member",printer.printTo(mentions, "gianni"));
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printTo(mentions, "To"));
	}
	
	@Test
	@DisplayName("Test help")
	void Help() {
		assertNotEquals("",new it.uniba.util.HelpPrinter().toString());
	}
}
