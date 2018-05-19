package it.uniba.analysis.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.ChannelsAnalysis;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MemberSortedByChannelTest {

	@Test
	@DisplayName("Test a good workspace membersSortedByChannel")
	void goodWorkspaceSorted() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertTrue(channels.membersSortedByChannel("res/file/test.zip"));
	}
	
	@Test
	@DisplayName("Test a not found workspace membersSortedByChannel")
	void notFoundWorkspaceSorted() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.membersSortedByChannel("ciao.zip"));
	}
	
	@Test
	@DisplayName("Test a false after a parse error membersSortedByChannel")
	void parseErrorSorted() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.membersSortedByChannel("res/file/test-wrongChannels.zip"));
	}
}
