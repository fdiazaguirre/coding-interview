package edu.fdiazaguirre.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
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

		//System.out.println(Runtime.getRuntime().availableProcessors());
		// Using SingleThreadExecutor to force execution order.
		ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		Runnable task1 = new Runnable(){
			@Override
			public void run() {
				System.out.println("task1");
		}};
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
			 System.out.println("task2");
		}
		};
		Runnable task3 = new Runnable(){
			@Override
			public void run() {
				System.out.println("task3");
		 }
		};

		// Cannot guarantee the execution order.
		es.execute(task1);
		es.execute(task2);
		es.execute(task3);
		es.shutdown();
		
		// Using
		final CountDownLatch latch = new CountDownLatch(3);

		Thread decrementThread1 = new Thread("decrementThread1") {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		Thread decrementThread2 = new Thread("decrementThread2") {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}
		};
		Thread decrementThread3 = new Thread("decrementThread3") {
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
