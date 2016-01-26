package edu.fdiazaguirre.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();
		try {
			for (String message = queue.take(); !message.equals("DONE"); message = queue
					.take()) {
				System.out.format("MESSAGE RECEIVED: %s%n", message);
				Thread.sleep(random.nextInt(5000));
			}
		} catch (InterruptedException e) {
		}
	}
}
