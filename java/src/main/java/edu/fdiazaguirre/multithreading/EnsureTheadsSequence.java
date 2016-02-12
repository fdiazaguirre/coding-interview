package edu.fdiazaguirre.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class EnsureTheadsSequence {

	public static void main(String[] args) throws InterruptedException {
		// Using previous.join approach.
		 Thread t1 = new SequentialThread("t1", null);
		 Thread t2 = new SequentialThread("t2", t1);
		 Thread t3 = new SequentialThread("t3", t2);
		
		 t1.start();
		 t2.start();
		 t3.start();

		// Using SingleThreadExecutor.
		Executor exec = Executors.newSingleThreadExecutor();
		// Runnable task1 = new Runnable(){
		// @Override
		// public void run() {
		// System.out.println("t1");
		// }};
		// Runnable task2 = new Runnable() {
		// @Override
		// public void run() {
		// System.out.println("t2");
		// }
		// };
		// Runnable task3 = new Runnable(){
		// @Override
		// public void run() {
		// System.out.println("t3");
		// }
		// };

		// The execution order.
		// exec.execute(task1);
		// exec.execute(task2);
		// exec.execute(task3);

		// Using
		final CountDownLatch latch = new CountDownLatch(3);

		Thread decrementThread1 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		Thread decrementThread2 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		Thread decrementThread3 = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		decrementThread1.start();
		decrementThread2.start();
		decrementThread3.start();
		
		latch.await();
		
		decrementThread1.join();
		decrementThread2.join();
		decrementThread3.join();
		
		System.out.println("DONE: " + latch.getCount());
	}

}
