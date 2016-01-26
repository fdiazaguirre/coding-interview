package edu.fdiazaguirre.multithreading;

import java.util.concurrent.CountDownLatch;

public class SequentialRunnable implements Runnable {
	private CountDownLatch latch;
	private final int goSignal;
	
	public SequentialRunnable(CountDownLatch latch, int goSignal) {
		this.latch = latch;
		this.goSignal = goSignal;
	}
	
	@Override
	public void run() {
		String threadNumber = Integer.toString(4 - goSignal);
		System.out.println("signal: " + goSignal + "latchCount: " + latch.getCount());
		if (latch.getCount() == goSignal) {
			System.out.println(Thread.currentThread().getName() +  threadNumber);
			latch.countDown();
		}
	}

}
