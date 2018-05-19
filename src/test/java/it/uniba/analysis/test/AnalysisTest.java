package it.uniba.analysis.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.uniba.analysis.Analysis;
import it.uniba.data.Member;

@SuppressWarnings("PMD.TooManyStaticImports")
public class AnalysisTest {
	
	@Test
	@DisplayName("Test empty members in Analysis")
	void emptyMembers() {
		final Analysis analysis = new Analysis();
		assertEquals(new ArrayList<>(),analysis.getMembers());
	}
	
	@Test
	@DisplayName("Test if member is in members in Analysis that fail")
	void isInMembersFail() {
		final Analysis analysis = new Analysis();
		assertFalse(analysis.isInList("beppe"));
	}
	
	@Test
	@DisplayName("Test if member is in members in Analysis")
	void isInMemberPass() {
		final Analysis analysis = new Analysis();
		final List<Member> members = new ArrayList<>();
		members.add(new Member("1","Gino"));
		members.add(new Member("2","beppe"));
		analysis.setMembers(members);
		assertTrue(analysis.isInList("beppe"));
	}

}
