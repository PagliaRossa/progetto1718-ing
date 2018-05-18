package it.uniba.analysis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.analysis.Analysis;
import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Channel;
import it.uniba.data.Member;
import it.uniba.data.Mention;

public class AnalysisTest {
	
	@Test
	@DisplayName("Analysis test")
	void Analysis() {
		Analysis analysis = new Analysis();
		assertEquals(new ArrayList<>(),analysis.getMembers());
		assertFalse(analysis.isInList("beppe"));
		List<Member> members_ = new ArrayList<>();
		members_.add(new Member("1","Gino"));
		members_.add(new Member("2","beppe"));
		analysis.setMembers(members_);
		assertTrue(analysis.isInList("beppe"));
		MembersAnalysis members = new MembersAnalysis();
		assertTrue(members.membersList("res/file/test.zip")); //Test true with a normal workspace
		assertFalse(members.membersList("ciao.zip")); //Test false with a bad workspace
		assertFalse(members.membersList("res/file/test3.zip")); //Test false with a normal workspace , bad json
		ChannelsAnalysis channels = new ChannelsAnalysis();
		Channel channel = new Channel("0","bernerslee",new ArrayList<String>());
		assertEquals(new ArrayList<Channel>(),channels.getChannels());
		assertEquals(new ArrayList<String>(),channels.getChannelMembers(channel));
		assertTrue(channels.channelsList("res/file/test.zip")); //Test true with a normal workspace
		assertNotEquals(channel,channels.getChannel("bernerslee"));
		assertFalse(channels.channelsList("ciao.zip")); //Test false with a bad workspace
		assertFalse(channels.channelsList("res/file/test3.zip")); //Test false with a normal workspace , bad json
		assertTrue(channels.membersChannel("bernerslee","res/file/test.zip"));
		assertFalse(channels.membersChannel("ciao","res/file/test.zip"));
		assertTrue(channels.membersSortedByChannel("res/file/test.zip"));
		assertFalse(channels.membersSortedByChannel("ciao.zip"));
		MentionsAnalysis mentions = new MentionsAnalysis();
		assertEquals(new ArrayList<Mention>(),mentions.getMentions());
		assertTrue(mentions.mentionsList("res/file/test.zip"));
		assertFalse(mentions.mentionsList("res/file/tes3t.zip"));
		assertFalse(mentions.mentionsList("res/file/test3.zip"));
		assertTrue(mentions.mentionsListChannel("bernerslee","res/file/test.zip"));
		assertFalse(mentions.mentionsListChannel("bernersle","res/file/test.zip"));
		assertFalse(mentions.mentionsListChannel("bernerslee","res/file/tes3t.zip"));
	}

}
