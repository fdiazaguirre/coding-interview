package edu.fdiazaguirre.interviews.finance;

import static org.junit.Assert.*;

import org.junit.Test;

public class UglyTest {

	@Test
	public void shouldRemoveGetAndInsertUnderscoreBetweenWords() {
		assertEquals("Account_Name", Ugly.uglifier("getAccountName"));
		assertEquals("Long_Account_Name", Ugly.uglifier("getLongAccountName"));
		assertEquals("Trader_ID", Ugly.uglifier("getTraderID"));
		assertEquals("SWIFT_Something", Ugly.uglifier("getSWIFTSomething"));
	}

}
