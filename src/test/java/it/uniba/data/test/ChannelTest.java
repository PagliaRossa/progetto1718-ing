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

@SuppressWarnings("PMD.TooManyStaticImports")
public class ChannelTest {
	
	static String user = "Marco";
	
	Field getField(final Class<? extends Channel> channel,final String name) throws NoSuchFieldException, SecurityException {
		return channel.getDeclaredField(name);
	}
	
	void setAccessible(final Field field) {
		field.setAccessible(true);
	}
	
	String get(final Field field,final Channel channel) throws IllegalArgumentException, IllegalAccessException {
		return (String) field.get(channel);
	}
	
	@SuppressWarnings("unchecked")
	List<String> getArray(final Field field,final Channel channel) throws IllegalArgumentException, IllegalAccessException {
		return (List<String>) field.get(channel);
	}
	
	@Test
	@DisplayName("Test empty members channel")
	void empty() {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		assertTrue(channel.isEmpty());
	}
	
	@Test
	@DisplayName("Test getMembers channel")
	void getMembers() {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		assertEquals(new ArrayList<>(),channel.getMembers());
	}
	
	@Test
	@DisplayName("Test isInChannel channel")
	void failIsInChannel() {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		assertFalse(channel.isInChannel("mimmo"));
	}
	
	@Test
	@DisplayName("Test getId channel")
	void getId() {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		assertEquals("9",channel.getId());
	}
	
	@Test
	@DisplayName("Test setId channel")
	void setId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		channel.setId("0");
		final Field field = getField(channel.getClass(),"identificator");
		setAccessible(field);
		assertEquals(get(field,channel),"0");
	}
	
	@Test
	@DisplayName("Test setName channel")
	void setName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		channel.setName("mimmo");
		final Field field = getField(channel.getClass(),"name");
		setAccessible(field);
		assertEquals(get(field,channel),"mimmo");
	}
	
	@Test
	@DisplayName("Test setMembers channel")
	void setMembers() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Channel channel = new Channel("9",user,new ArrayList<>());
		final List<String> members = new ArrayList<>();
		members.add("mirco");
		channel.setMembers(members);
		final Field field = getField(channel.getClass(),"members");
		setAccessible(field);
		assertEquals(getArray(field,channel),members);
	}

}
