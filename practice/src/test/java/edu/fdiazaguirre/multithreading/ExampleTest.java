package edu.fdiazzaguirre.multithreading;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import edu.fdiazaguirre.multithreading.InterruptedExceptionExample;

public class ExampleTest {

	@Test
	public void test() {
		InterruptedExceptionExample e = new InterruptedExceptionExample();
		
		assertNull(e.getNextTask(new ArrayBlockingQueue(5)));
	}

}
