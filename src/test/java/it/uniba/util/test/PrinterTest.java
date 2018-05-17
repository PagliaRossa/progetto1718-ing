package it.uniba.util.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
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
import it.uniba.util.Zip;

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
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printTo(mentions, "To"));
	}
	
	@Test
	@DisplayName("Test help")
	void Help() {
		assertNotEquals("",new it.uniba.util.HelpPrinter().toString());
	}
	
	@Test
	@DisplayName("Test zip")
	void Zip() {
		Zip zip = new Zip();
		try {
			assertNotNull(zip.setUsersFile("res/file/test.zip"));
			assertNotNull(zip.setChannelsFile("res/file/test.zip"));
			assertNotNull(zip.setConversationFile("res/test/test.zip"));
			assertNotNull(zip.setConversationFile("bernerslee","res/file/test.zip"));
			assertNotNull(zip.getJSONFromFile("res/file/test.zip","bernerslee/2018-03-13.json"));
		} catch (IOException i) {
			System.out.println("fail");
		}
		assertThrows(IOException.class,() -> {zip.setUsersFile("ciao.zip");});
		assertThrows(IOException.class,() -> {zip.setChannelsFile("ciao.zip");});
		assertThrows(IOException.class,() -> {zip.setConversationFile("ciao.zip");});
		assertThrows(IOException.class,() -> {zip.getJSONFromFile("ciao.zip","ciao");});
		assertThrows(IOException.class,() -> {zip.setConversationFile("prova","ciao.zip");});
	}
}
