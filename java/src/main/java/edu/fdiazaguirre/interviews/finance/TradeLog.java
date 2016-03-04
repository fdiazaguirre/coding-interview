package edu.fdiazaguirre.interviews.finance;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Singleton: only one source of truth for operations.
 * 
 * @author fdiazaguirre
 *
 */
public class TradeLog {

	private static TradeLog instance;
	private static StringBuilder history = new StringBuilder();
	// Thread-safe
	private static CopyOnWriteArrayList<Record> records = new CopyOnWriteArrayList<Record>();

	private TradeLog() {}

	public static TradeLog getInstance() {
		if (instance == null) {
			openMarket();
			instance = new TradeLog();
			closeMarket();
		}
		return instance;
	}

	private static void openMarket() {
		history.append("-------Market has been Opened--------");
	}
	
	private static void closeMarket() {
		history.append("-------Market has been Closed--------");
	}

	public static void log(long timestamp, Stock s, char operation, int quantity, float price) {
		final Record r = new Record(timestamp, s, operation, quantity, price);
		records.add(r);

		StringBuffer logEntry = new StringBuffer();
		logEntry.append(String.valueOf(timestamp));
		logEntry.append(s.getSymbol());
		logEntry.append(operation);
		logEntry.append(String.valueOf(quantity));
		logEntry.append(String.valueOf(price));

		history.append(logEntry.toString());
		history.append("-------------------");
	}

	/**
	 * 
	 * @param time
	 *            since when you want to track records. Default is 5 minutes.
	 * @return all the operations in that window.
	 */
	public static LinkedList<Record> getLatest(Date time) {
		// No need to use concurrent version of list, since is not shared.
		LinkedList<Record> result = new LinkedList<>();
		int index = records.size() - 1;
		Record current = records.get(index);
		while (current.getTimestamp() > time.getTime()) {
			result.add(current);
			index--;
			current = records.get(index);
		}
		return result;
	}

	public static LinkedList<Record> getLatest() {
		// gets a calendar using the default time zone and locale.
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -5);
		return getLatest(calendar.getTime());
	}
	
	public static CopyOnWriteArrayList<Record> getAll() {
		return records;
	}
}
