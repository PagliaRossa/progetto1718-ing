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

public class PrinterMembersTest {
	
	private List<Member> members = new ArrayList<>();
	private List<Channel> channels = new ArrayList<>();
	private List<Mention> mentions = new ArrayList<>();
	
	@Test
	@DisplayName("Test members print")
	void PrintMember() {
		Member member = new Member();
		member.setId("0");
		member.setName("Donato");
		members.add(member);
		MembersPrinter printer = new MembersPrinter();
		String test = "This is users list :\n\nDonato\n";
		assertEquals(test,printer.print(members));
		assertNotEquals("ciao",printer.print(members));
	}
	
	@Test
	@DisplayName("Test channels print")
	void PrintChannels() {
		Channel channel = new Channel();
		channel.setId("0");
		channel.setName("Test");
		channels.add(channel);
		ChannelsPrinter printer = new ChannelsPrinter();
		String test = "This is channels list :\n\nTest\n";
		assertEquals(test,printer.print(channels));
		assertNotEquals("ciao",printer.print(channels));
		ChannelsAnalysis testing = new ChannelsAnalysis();
		assertEquals("Members of Test :\n\n",printer.memberInChannelPrint(channel,testing));
		assertEquals("",printer.membersSortedByChannelPrint(testing));
	}
	
	@Test
	@DisplayName("Test mentions print")
	void PrintMentions() {
		Mention mention = new Mention("From","To");
		mentions.add(mention);
		MentionsPrinter printer = new MentionsPrinter();
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.print(mentions));
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printFrom(mentions, "From"));
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printTo(mentions, "To"));
	}
	
	@Test
	@DisplayName("Test help")
	void Help() {
		assertNotEquals("",new it.uniba.util.HelpPrinter().toString());
	}
}
