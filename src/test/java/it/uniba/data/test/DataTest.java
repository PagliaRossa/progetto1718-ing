package it.uniba.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Channel;


public class DataTest {
	
	@Test
	@DisplayName("Test data")
	void Data() {
		Channel channel = new Channel("9","marco",new ArrayList<>());
		assertTrue(channel.isEmpty());
		assertEquals(new ArrayList<>(),channel.getMembers());
		assertFalse(channel.isInChannel("mimmo"));
		assertEquals("9",channel.getId());
	}

}
