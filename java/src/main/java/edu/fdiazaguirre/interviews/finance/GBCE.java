package edu.fdiazaguirre.interviews.finance;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CPU intensive object.
 * 
 * @author fdiazaguirre
 *
 */
public class GBCE {

	private TradeLog logger = TradeLog.getInstance();

	/**
	 * a) i. Given any price as input, calculate the dividend yield
	 */
	public Float calculateDividendYield(Stock s, float price) {
		if (StockType.COMMON.equals(s.getType())) {
			return s.getLastDividend() / price;
		}
		
		if (StockType.PREFERRED.equals(s.getType())) {
			return s.getFixedDividend() * s.getParValue() / price;
		}
			
		return null;
	}

	/**
	 * a) ii. Given any price as input, calculate the P/E Ratio
	 */
	public Float calculatePERatio(Stock s, float price) {
		if (StockType.COMMON.equals(s.getType())) {
			return price / s.getLastDividend();
		}
		
		if (StockType.PREFERRED.equals(s.getType())) {
			return price / s.getFixedDividend();
		}
		return null;
	}

	/**
	 * a) iii. Calculate Volume Weighted Stock Price based on trades in past 5
	 * minutes.
	 */
	public Float calculateVolumeWeightedStockPrice() {
		LinkedList<Record> tradeLog = logger.getLatest();
		// fail-fast
		if (tradeLog.size() < 1) { return null;}
		
		float sumTradedPrice = 0f;
		int shares = 0;
		for (Record record : tradeLog) {
			shares += record.getQuantity();
			sumTradedPrice += record.getPrice() * record.getQuantity();
		}
		
		return sumTradedPrice / shares;
	}

	/**
	 * b) Calculate the GBCE All Share Index using the geometric mean of the
	 * Volume Weighted Stock Price for all stocks
	 * 
	 * Assuming p = record.getPrice() * record.getQuantity()
	 * √p1p2p3 ... pn
	 */
	public Float calculateGBCEAllShareIndex() {
		CopyOnWriteArrayList<Record> all = logger.getAll();
		// fail-fast
		if (all.size() < 1) { return null;}

		float productTradedPrice = 0f;
		int shares = 0;
		for (Record record : all) {
			shares += record.getQuantity();
			productTradedPrice *= record.getPrice() * record.getQuantity();
		}
		
		return (float) Math.pow(productTradedPrice, 1.0 / shares);
	}

	public void trade(long timestamp, Stock s, char operation, int quantity, float price) {
		logger.log(timestamp, s, operation, quantity, price);
	}
}
