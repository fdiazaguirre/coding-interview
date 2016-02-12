package edu.fdiazaguirre.multithreading;

public class SequentialThread extends Thread {
	private final Thread previous;
	private final String tName;

	public SequentialThread (String tName, Thread next) {
		this.previous = next;
		this.tName = tName;
	}
	
	@Override
	public void run() {
		try {
			if (previous != null) {
				previous.join();
			}
			Thread.currentThread().sleep(1000);
			System.out.println("Invoked from: " + tName);
		} catch (InterruptedException e) {
			// TODO: propagate exception!
			e.printStackTrace();
		}
	}
}
