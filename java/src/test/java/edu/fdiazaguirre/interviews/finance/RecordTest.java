package edu.fdiazaguirre.interviews.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.mockito.Mock;
import java.util.Calendar;

import org.junit.Test;

public class RecordTest {

	@Mock
	Stock stock;
	
	@Test
	public void shouldCreateRecordWhenSellingOrBuying() {
		Calendar calendar = Calendar.getInstance();
		Record b = new Record(calendar.getTimeInMillis(), stock, 'B', 1, 10.3f);
		Record s = new Record(calendar.getTimeInMillis(), stock, 'S', 1, 10.3f);
		
		assertEquals(b.getOperation(), 'B');
		assertEquals(s.getOperation(), 'S');
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowExceptionForInvalidOperations() {
		Calendar calendar = Calendar.getInstance();
		Record b = new Record(calendar.getTimeInMillis(), stock, 'C', 1, 10.3f);
		
		fail("Should be throw a RuntimeException");
	}

}
