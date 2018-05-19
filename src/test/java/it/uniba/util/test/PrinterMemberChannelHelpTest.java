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
import it.uniba.util.ChannelsPrinter;
import it.uniba.util.MembersPrinter;

@SuppressWarnings("PMD.TooManyStaticImports")
public class PrinterMemberChannelHelpTest {
	
	static String user = "Donato";
	
	@Test
	@DisplayName("Test members print")
	void printMembers() {
		final List<Member> members = new ArrayList<>();
		final Member member = new Member("0",user);
		members.add(member);
		final MembersPrinter printer = new MembersPrinter();
		final String test = "This is users list :\n\nDonato\n";
		assertEquals(test,printer.print(members));
	}
	
	@Test
	@DisplayName("Test members print fail")
	void printMembersFail() {
		final List<Member> members = new ArrayList<>();
		final MembersPrinter printer = new MembersPrinter();
		assertNotEquals("ciao",printer.print(members));
	}
	
	@Test
	@DisplayName("Test channels print")
	void printChannels() {
		final List<Channel> channels = new ArrayList<>();
		final List<String> membersArray = new ArrayList<>();
		membersArray.add("0");
		membersArray.add("1");
		membersArray.add("2");
		final List<Member> members = new ArrayList<>();
		members.add(new Member("0",user));
		members.add(new Member("1","Giacomo"));
		members.add(new Member("2","Marco"));
		final Channel channel = new Channel("0","Test",membersArray);
		channels.add(channel);
		final ChannelsPrinter printer = new ChannelsPrinter();
		final String test = "This is channels list :\n\nTest\n";
		assertEquals(test,printer.print(channels));
	}
	
	@Test
	@DisplayName("Test channels fail print")
	void printChannelsFail() {
		final List<Channel> channels = new ArrayList<>();
		final ChannelsPrinter printer = new ChannelsPrinter();
		assertNotEquals("ciao",printer.print(channels));
	}
	
	@Test
	@DisplayName("Test membersChannel print")
	void printMembersChannel() {
		final List<Channel> channels = new ArrayList<>();
		final List<String> membersArray = new ArrayList<>();
		membersArray.add("0");
		membersArray.add("1");
		membersArray.add("2");
		final List<Member> members = new ArrayList<>();
		members.add(new Member("0",user));
		members.add(new Member("1","Giacomo"));
		members.add(new Member("2","Marco"));
		final Channel channel = new Channel("0","Test",membersArray);
		channels.add(channel);
		final ChannelsPrinter printer = new ChannelsPrinter();
		final ChannelsAnalysis testing = new ChannelsAnalysis();
		testing.setChannels(channels);
		testing.setMembers(members);
		assertEquals("Members of Test :\n\nDonato\nGiacomo\nMarco\n",printer.memberInChannelPrint(channel,testing));
	}
	
	@Test
	@DisplayName("Test channels print")
	void printSorted() {
		final List<Channel> channels = new ArrayList<>();
		final List<String> membersArray = new ArrayList<>();
		membersArray.add("0");
		membersArray.add("1");
		membersArray.add("2");
		final List<Member> members = new ArrayList<>();
		members.add(new Member("0",user));
		members.add(new Member("1","Giacomo"));
		members.add(new Member("2","Marco"));
		final Channel channel = new Channel("0","Test",membersArray);
		channels.add(channel);
		final ChannelsPrinter printer = new ChannelsPrinter();
		final ChannelsAnalysis testing = new ChannelsAnalysis();
		testing.setChannels(channels);
		testing.setMembers(members);
		assertEquals("Test :\n\n- Donato\n- Giacomo\n- Marco\n\n",printer.membersSortedByChannelPrint(testing));
	}
	
	@Test
	@DisplayName("Test help")
	void help() {
		assertNotEquals("",new it.uniba.util.HelpPrinter().toString());
	}
}
