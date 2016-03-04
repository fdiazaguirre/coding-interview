package edu.fdiazaguirre.interviews.finance;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.LinkedList;

import org.junit.Test;

public class TradeLogTest {

	@Test
	public void shouldReturnOnlyRecordsInWindow() {
		Stock s = new Stock("TEA", StockType.COMMON, 100, 100, 50, 0);
		Calendar calendar = Calendar.getInstance();
		TradeLog.log(calendar.getTimeInMillis(), s, 'B', 2, 30.4f);
		TradeLog.log(calendar.getTimeInMillis(), s, 'S', 2, 31.6f);
		calendar.add(Calendar.SECOND, 35);
		TradeLog.log(calendar.getTimeInMillis(), s, 'B', 2, 32.7f);
		
		// Move time to get the cut.
		calendar.add(Calendar.SECOND, -35);
		LinkedList<Record> actual = TradeLog.getLatest(calendar.getTime());
		
		assertEquals(32.7f, actual.get(0).getPrice(), 0);
	}

}
