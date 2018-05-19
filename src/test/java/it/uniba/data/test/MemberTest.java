package it.uniba.data.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Member;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MemberTest {

	Field getField(final Class<? extends Member> class1,final String name) throws NoSuchFieldException, SecurityException {
		return class1.getDeclaredField(name);
	}
	
	void setAccessible(final Field field) {
		field.setAccessible(true);
	}
	
	String get(final Field field,final Member member) throws IllegalArgumentException, IllegalAccessException {
		return (String) field.get(member);
	}
	
	@Test
	@DisplayName("Test member setId")
	void setId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Member member = new Member("0","mimmo");
		member.setId("1");
		final Field field = getField(member.getClass(),"identificator");
		setAccessible(field);
		assertEquals(get(field,member),"1");
	}
	
	@Test
	@DisplayName("Test member setId")
	void setName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Member member = new Member("0","mimmo");
		member.setName("donato");
		final Field field = getField(member.getClass(),"name");
		setAccessible(field);
		assertEquals(get(field,member),"donato");
	}
}
