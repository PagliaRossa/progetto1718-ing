package it.uniba.analysis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.analysis.Analysis;
import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.analysis.MembersAnalysis;
import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Mention;

public class AnalysisTest {
	
	@Test
	@DisplayName("Analysis test")
	void Analysis() {
		Analysis analysis = new Analysis();
		assertEquals(new ArrayList<>(),analysis.getMembers());
		MembersAnalysis members = new MembersAnalysis();
		assertTrue(members.membersList("res/file/test.zip"));
		assertFalse(members.membersList("ciao.zip"));
		ChannelsAnalysis channels = new ChannelsAnalysis();
		assertTrue(channels.channelsList("res/file/test.zip"));
		assertFalse(channels.channelsList("ciao.zip"));
		assertTrue(channels.membersChannel("bernerslee","res/file/test.zip"));
		assertFalse(channels.membersChannel("ciao","res/file/test.zip"));
		assertTrue(channels.membersSortedByChannel("res/file/test.zip"));
		assertFalse(channels.membersSortedByChannel("ciao.zip"));
		MentionsAnalysis mentions = new MentionsAnalysis();
		assertEquals(new ArrayList<Mention>(),mentions.getMentions());
		assertTrue(mentions.mentionsList("res/file/test.zip"));
		assertFalse(mentions.mentionsList("res/file/tes3t.zip"));
		assertTrue(mentions.mentionsListChannel("bernerslee","res/file/test.zip"));
		assertFalse(mentions.mentionsListChannel("bernersle","res/file/test.zip"));
		assertFalse(mentions.mentionsListChannel("bernerslee","res/file/tes3t.zip"));
	}

}
