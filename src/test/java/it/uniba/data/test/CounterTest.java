package it.uniba.data.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Counter;

@SuppressWarnings("PMD.TooManyStaticImports")
public class CounterTest {

	Field getField(final Class<? extends Counter> counter,final String name) throws NoSuchFieldException, SecurityException {
		return counter.getDeclaredField(name);
	}
	
	void setAccessible(final Field field) {
		field.setAccessible(true);
	}
	
	int get(final Field field,final Counter counter) throws IllegalArgumentException, IllegalAccessException {
		return (int) field.get(counter);
	}
	
	@Test
	@DisplayName("Test getIndex Counter")
	void getIndex() {
		final Counter counter = new Counter(10,10);
		assertEquals(10,counter.getIndex());
	}
	
	@Test
	@DisplayName("Test getOccurence Counter")
	void getOccurence() {
		final Counter counter = new Counter(10,10);
		assertEquals(10,counter.getOccurenceNumber());
	}
	
	@Test
	@DisplayName("Test Counter")
	void setIndex() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Counter counter = new Counter(10,10);
		counter.setIndex(11);
		final Field field = getField(counter.getClass(),"index");
		setAccessible(field);
		assertEquals(get(field,counter),11);
	}
	
	@Test
	@DisplayName("Test Counter")
	void setOccurence() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Counter counter = new Counter(10,10);
		counter.setOccurenceNumber(11);
		final Field field = getField(counter.getClass(),"occurenceNumber");
		setAccessible(field);
		assertEquals(get(field,counter),11);
	}
}
