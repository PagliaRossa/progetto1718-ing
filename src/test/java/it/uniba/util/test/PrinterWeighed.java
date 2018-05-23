package it.uniba.util.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Counter;
import it.uniba.data.Mention;
import it.uniba.util.MentionsPrinter;

public class PrinterWeighed {
	
	@Test
	@DisplayName("Test no mentions weighed")
	void noMention() {
		final List<Mention> mentions = new ArrayList<>();
		final List<Counter> occurence = new ArrayList<>();
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("Can't find mentions !",printer.printWeighed(mentions, occurence));
	}
	
	@Test
	@DisplayName("Test no mentionsFrom weighed")
	void noMentionFrom() {
		final List<Mention> mentions = new ArrayList<>();
		final List<Counter> occurence = new ArrayList<>();
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("Can't find mentions for this member",printer.printFromWeighed(mentions,"ulisse1996", occurence));
	}
	
	@Test
	@DisplayName("Test no mentionsFrom weighed")
	void noMentionTo() {
		final List<Mention> mentions = new ArrayList<>();
		final List<Counter> occurence = new ArrayList<>();
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("Can't find mentions for this member!",printer.printToWeighed(mentions,"ulisse1996", occurence));
	}

}
