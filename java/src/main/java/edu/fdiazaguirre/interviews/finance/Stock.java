package edu.fdiazaguirre.interviews.finance;

public class Stock {

	private String symbol;
	private StockType type;
	private float price;
	private float parValue;
	private float lastDividend;
	private float fixedDividend;

	public Stock(String symbol, StockType type, float price, float parValue, float lastDividend, float fixedDividend) {
		this.symbol = symbol;
		this.type = type;
		this.price = price;
		this.parValue = parValue;
		this.lastDividend = lastDividend;
		// Only valid for PREFERRED.
		if (StockType.PREFERRED.equals(type)) {
			this.fixedDividend = fixedDividend;
		}
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	public StockType getType() {
		return this.type;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public float getParValue() {
		return this.parValue;
	}

	public float getLastDividend() {
		return this.lastDividend;
	}

	public float getFixedDividend() {
		return this.fixedDividend;
	}
}
