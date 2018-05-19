package it.uniba.analysis.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.ChannelsAnalysis;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MembersChannelTest {

	@Test
	@DisplayName("Test a good workspace membersChannel")
	void goodWorkspaceMembersChannel() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertTrue(channels.membersChannel("bernerslee","res/file/test.zip"));
	}
	
	@Test
	@DisplayName("Test a good workspace with a bad channel membersChannel")
	void goodWorkspaceBadChannelMemebersChannel() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.membersChannel("ciao","res/file/test.zip"));
	}
	
	@Test
	@DisplayName("Test a false after a parse error membersChannel")
	void parseErrorMembersChannel() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.membersChannel("bello", "res/file/test-wrongChannels.zip"));
	}
	
	@Test
	@DisplayName("Test a false after a parse error in membersList membersChannel")
	void parseErrorMemberListMembersChannel() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.membersChannel("bello", "res/file/test-wrongUsers.zip"));
	}
}
