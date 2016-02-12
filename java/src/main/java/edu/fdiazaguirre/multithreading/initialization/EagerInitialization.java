package edu.fdiazaguirre.multithreading.initialization;

import sun.misc.Resource;

public class EagerInitialization {

	private static Resource resource = new ResourceImpl();
	
	public static Resource getResource() {
		return resource;
	}
}
