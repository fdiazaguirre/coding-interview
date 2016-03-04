package edu.fdiazaguirre.interviews.finance;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class GBCETest {
	final GBCE exchange = new GBCE();
	final Calendar calendar = Calendar.getInstance();

	@Test
	public void testCalculateDividendYieldCommon() {
		// Given.
		Stock commonStockOption = new Stock("TEA", StockType.COMMON, 100f, 100f, 50f, 0f);

		// When.
		exchange.trade(calendar.getTimeInMillis(), commonStockOption, 'B', 50, 5000f);
		// TEA goes $10 down.
		exchange.trade(calendar.getTimeInMillis(), commonStockOption, 'B', 10, 900f);

		// Then.
		float expected = 50f / 90f;
		assertEquals(expected, exchange.calculateDividendYield(commonStockOption, 90), 0);
	}

	@Test
	public void testCalculateDividendYieldPreferred() {
		// Given.
		Stock preferredStockOption = new Stock("GIN", StockType.PREFERRED, 75f, 55f, 8f, 2f);
		
		// When.
		exchange.trade(calendar.getTimeInMillis(), preferredStockOption, 'S', 30, 2250f);
		
		// Then.
		float expected = 2f * 55f / 80f;
		// GIN goes up $5 after the last exchange.
		assertEquals(expected, exchange.calculateDividendYield(preferredStockOption, 80), 0);
	}
	

}
