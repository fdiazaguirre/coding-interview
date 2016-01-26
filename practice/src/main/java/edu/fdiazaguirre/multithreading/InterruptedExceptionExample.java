package edu.fdiazaguirre.multithreading;

import java.util.concurrent.BlockingQueue;

public class InterruptedExceptionExample {

	public Object getNextTask(BlockingQueue<Object> queue) {
		boolean interrupted = false;
		try {
			while (true) {
				//return queue.take();
				throw new InterruptedException();
			}
		} catch (InterruptedException e) {
			interrupted = true;
		} finally {
			if (interrupted) {
				Thread.currentThread().interrupt();
			}
		}
		return null;
	}
}
