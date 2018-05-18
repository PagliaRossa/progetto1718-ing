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
import it.uniba.data.Counter;


public class DataTest {
	
	@Test
	@DisplayName("Test channel")
	void Channel() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
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
	}
	
	@Test
	@DisplayName("Test member")
	void Member() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Member member = new Member("0","mimmo");
		member.setId("1");
		Field field = member.getClass().getDeclaredField("identificator");
		field.setAccessible(true);
		assertEquals(field.get(member),"1");
		member.setName("donato");
		field = member.getClass().getDeclaredField("name");
		field.setAccessible(true);
		assertEquals(field.get(member),"donato");
	}
	
	@Test
	@DisplayName("Test mention")
	void Mention() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Mention mention = new Mention("From","To");
		mention.setFrom("me");
		Field field = mention.getClass().getDeclaredField("fromMember");
		field.setAccessible(true);
		assertEquals(field.get(mention),"me");
		mention.setTo("you");
		field = mention.getClass().getDeclaredField("toMember");
		field.setAccessible(true);
		assertEquals(field.get(mention),"you");
	}
	
	@Test
	@DisplayName("Test Counter")
	void Counter() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Counter counter = new Counter(10,10);
		assertEquals(10,counter.getIndex());
		assertEquals(10,counter.getOccurenceNumber());
		counter.setIndex(11);
		Field field = counter.getClass().getDeclaredField("index");
		field.setAccessible(true);
		assertEquals(field.get(counter),11);
		counter.setOccurenceNumber(11);
		field = counter.getClass().getDeclaredField("occurenceNumber");
		field.setAccessible(true);
		assertEquals(field.get(counter),11);
	}

}
