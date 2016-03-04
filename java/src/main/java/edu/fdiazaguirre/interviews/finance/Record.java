package edu.fdiazaguirre.interviews.finance;

public class Record {

	private final long timestamp;
	private final Stock stock;
	private final char operation;
	private final int quantity;
	private final float price;

	public Record(long timestamp, Stock stock, char operation, int quantity, float price) {
		// fail-fast
		isValid(operation);
		this.timestamp = timestamp;
		this.stock = stock;
		this.operation = Character.toUpperCase(operation);
		this.quantity = quantity;
		this.price = price;
	}

	static void isValid(char operation) {
		if (!(Character.toUpperCase(operation) == 'B' || Character.toUpperCase(operation) == 'S')) {
			throw new RuntimeException("Operantion must be either 'B' for buy or 'S' for sell");
		}
	}

	public long getTimestamp() {
		return timestamp;
	}

	public Stock getStock() {
		return stock;
	}

	public char getOperation() {
		return operation;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}

}
