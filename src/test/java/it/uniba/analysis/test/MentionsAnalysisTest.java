package it.uniba.analysis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.MentionsAnalysis;
import it.uniba.data.Mention;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MentionsAnalysisTest {
	
	static String goodWorkspace = "res/file/test.zip";
	static String notFoundWorkspace = "test.zip";
	static String goodChannel = "bernerslee";
	static String badChannel = "imbad";
	
	@Test
	@DisplayName("Test empty mentions MentionsAnalysis")
	void emptyMentions() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertEquals(new ArrayList<Mention>(),mentions.getMentions());
	}
	
	@Test
	@DisplayName("Test a good workspace MentionsAnalysis")
	void good() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertTrue(mentions.mentionsList(goodWorkspace));
	}
	
	@Test
	@DisplayName("Test setNameFromTo MentionsAnalysis")
	void setNameFromTo() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		mentions.mentionsList(goodWorkspace);
		assertNotNull(mentions.setNameFromTo());
	}
	
	@Test
	@DisplayName("Test not found workspace MentionsAnalysis")
	void notFound() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertFalse(mentions.mentionsList(notFoundWorkspace));
	}
	
	@Test
	@DisplayName("Test parse json error MentionsAnalysis")
	void parseJSONError() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertFalse(mentions.mentionsList("res/file/test-wrongJSON.zip"));
	}
	
	@Test
	@DisplayName("Test a good workspace with a good channel MentionsAnalysis")
	void goodWorkspaceGoodChannel() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertTrue(mentions.mentionsListChannel(goodChannel,goodWorkspace));
	}
	
	@Test
	@DisplayName("Test a good workspace with a bad channel MentionsAnalysis")
	void goodWorkspaceBadChannel() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertFalse(mentions.mentionsListChannel(badChannel,goodWorkspace));
	}
	
	@Test
	@DisplayName("Test a bad workspace with a bad channel MentionsAnalysis")
	void badWorkspaceBadChannel() {
		final MentionsAnalysis mentions = new MentionsAnalysis();
		assertFalse(mentions.mentionsListChannel(goodChannel,notFoundWorkspace));
	}
}
