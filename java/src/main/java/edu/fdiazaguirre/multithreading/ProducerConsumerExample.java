package edu.fdiazaguirre.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample {

	public static void main(String[] args) {
		BlockingQueue<String> drop = new SynchronousQueue<String>();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
