package edu.fdiazaguirre.multithreading.initialization;

import sun.misc.Resource;

/**
 * Use {@code ResourceFactory} instead.
 */
@Deprecated()
public class SafeLazyInitialization {
	private static Resource resource;

	public synchronized static Resource getInstance() {
		if (resource == null) {
			resource = new ResourceImpl();
		}
		return resource;
	}
}
