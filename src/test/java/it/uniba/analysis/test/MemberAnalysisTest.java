package it.uniba.analysis.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.uniba.analysis.MembersAnalysis;

@SuppressWarnings("PMD.TooManyStaticImports")
public class MemberAnalysisTest {
	
	@Test
	@DisplayName("Test MembersAnalysis")
	void membersAnalysis() {
		final MembersAnalysis members = new MembersAnalysis();
		assertTrue(members.membersList("res/file/test.zip")); //Test true with a normal workspace
	}
	
	@Test
	@DisplayName("Test a not found workspace membersList")
	void notFoundWorkspace() {
		final MembersAnalysis members = new MembersAnalysis();
		assertFalse(members.membersList("ciao.zip")); //Test false with a bad workspace
	}
	
	@Test
	@DisplayName("Test a parse error membersList")
	void parseError() {
		final MembersAnalysis members = new MembersAnalysis();
		assertFalse(members.membersList("res/file/test-wrongUsers.zip")); //Test false with a normal workspace , bad json)
	}
}
