package it.uniba.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Channel;
import it.uniba.data.Member;
import it.uniba.data.Mention;


public class DataTest {
	
	@Test
	@DisplayName("Test data")
	void Data() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Channel channel = new Channel("9","marco",new ArrayList<>());
		assertTrue(channel.isEmpty());
		assertEquals(new ArrayList<>(),channel.getMembers());
		assertFalse(channel.isInChannel("mimmo"));
		assertEquals("9",channel.getId());
		channel.setId("0");
		Field field = channel.getClass().getDeclaredField("identificator");
		field.setAccessible(true);
		assertEquals(field.get(channel),"0");
		channel.setName("mimmo");
		field = channel.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals(field.get(channel),"mimmo");
		List<String> members = new ArrayList<>();
		members.add("mirco");
		channel.setMembers(members);
		field = channel.getClass().getDeclaredField("members");
		field.setAccessible(true);
		assertEquals(field.get(channel),members);
		Member member = new Member("0","mimmo");
		member.setId("1");
		field = member.getClass().getDeclaredField("identificator");
		field.setAccessible(true);
		assertEquals(field.get(member),"1");
		member.setName("donato");
		field = member.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals(field.get(member),"donato");
		Mention mention = new Mention("From","To");
		mention.setFrom("me");
		field = mention.getClass().getDeclaredField("fromMember");
		field.setAccessible(true);
		assertEquals(field.get(mention),"me");
		mention.setTo("you");
		field = mention.getClass().getDeclaredField("toMember");
		field.setAccessible(true);
		assertEquals(field.get(mention),"you");
	}

}
