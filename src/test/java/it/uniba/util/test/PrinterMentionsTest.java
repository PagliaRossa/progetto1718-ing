package it.uniba.util.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.data.Mention;
import it.uniba.util.MentionsPrinter;

@SuppressWarnings("PMD.tooManyStaticImports")
public class PrinterMentionsTest {
	
	static String from = "From";
	static String toMember = "To";
	
	@Test
	@DisplayName("Test mentions print")
	void printMentions() {
		final List<Mention> mentions = new ArrayList<>();
		final Mention mention = new Mention(from,toMember);
		mentions.add(mention);
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.print(mentions));
	}
	
	@Test
	@DisplayName("Test mentionsListfrom print")
	void printfrom() {
		final List<Mention> mentions = new ArrayList<>();
		final Mention mention = new Mention(from,toMember);
		mentions.add(mention);
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printFrom(mentions, from));
	}
	
	@Test
	@DisplayName("Test mentionsListfrom no mentions print")
	void noMentionsfrom() {
		final List<Mention> mentions = new ArrayList<>();
		final Mention mention = new Mention(from,toMember);
		mentions.add(mention);
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("Can't find mentions for this member",printer.printFrom(mentions,"luigi"));
	}
	
	@Test
	@DisplayName("Test mentionsListto no mentions print")
	void noMentionsto() {
		final List<Mention> mentions = new ArrayList<>();
		final Mention mention = new Mention(from,toMember);
		mentions.add(mention);
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("Can't find mentions for this member",printer.printTo(mentions, "gianni"));
	}
	
	@Test
	@DisplayName("Test mentions print")
	void printto() {
		final List<Mention> mentions = new ArrayList<>();
		final Mention mention = new Mention(from,toMember);
		mentions.add(mention);
		final MentionsPrinter printer = new MentionsPrinter();
		assertEquals("List of mentions :\n\nFrom From to To\n",printer.printTo(mentions, toMember));
	}

}
