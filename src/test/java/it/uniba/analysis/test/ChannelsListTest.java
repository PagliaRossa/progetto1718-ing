package it.uniba.analysis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.ChannelsAnalysis;
import it.uniba.data.Channel;

@SuppressWarnings("PMD.TooManyStaticImports")
public class ChannelsListTest {
	
	@Test
	@DisplayName("Test empty channels in ChannelsAnalysis")
	void emptyChannels() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertEquals(new ArrayList<Channel>(),channels.getChannels());
	}
	
	@Test
	@DisplayName("Test empty members in channel")
	void emptyMembersInChannel() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		final Channel channel = new Channel("0","bernerslee",new ArrayList<String>());
		assertEquals(new ArrayList<String>(),channels.getChannelMembers(channel));
	}
	
	@Test
	@DisplayName("Test a good workspace for channelsList")
	void goodWorkspaceChannelsList() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertTrue(channels.channelsList("res/file/test.zip")); //Test true with a normal workspace
	}
	
	@Test
	@DisplayName("Test a channel not found")
	void channelNotFound() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertNull(channels.getChannel("bang"));
	}
	
	@Test
	@DisplayName("Test a channel different from created one")
	void channelIsDifferent() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		final Channel channel = new Channel("0","bernerslee",new ArrayList<String>());
		channels.channelsList("res/file/test.zip");
		assertNotEquals(channel,channels.getChannel("bernerslee"));
	}
	
	@Test
	@DisplayName("Test a not found workspace channelsList")
	void notFoundWorkspaceChannelsList() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.channelsList("ciao.zip")); //Test false with a bad workspace
	}
	
	@Test
	@DisplayName("Test a bad workspace channelsList")
	void badWorkspaceChannelsList() {
		final ChannelsAnalysis channels = new ChannelsAnalysis();
		assertFalse(channels.channelsList("res/file/test3.zip")); //Test false with a normal workspace , bad json
	}
	
}
