package it.uniba.data.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Mention;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MentionTest {

	Field getField(final Class<? extends Mention> mention,final String name) throws NoSuchFieldException, SecurityException {
		return mention.getDeclaredField(name);
	}
	
	void setAccessible(final Field field) {
		field.setAccessible(true);
	}
	
	String get(final Field field,final Mention mention) throws IllegalArgumentException, IllegalAccessException {
		return (String) field.get(mention);
	}
	
	@Test
	@DisplayName("Test setFrom mention")
	void setFrom() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Mention mention = new Mention("From","To");
		mention.setFrom("me");
		final Field field = getField(mention.getClass(),"fromMember");
		setAccessible(field);
		assertEquals(get(field,mention),"me");
	}
	
	@Test
	@DisplayName("Test setTo mention")
	void setTo() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Mention mention = new Mention("From","To");
		mention.setTo("you");
		final Field field = getField(mention.getClass(),"toMember");
		setAccessible(field);
		assertEquals(get(field,mention),"you");
	}
}
