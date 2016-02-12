package edu.fdiazaguirre.multithreading.initialization;

import sun.misc.Resource;

/**
 * Use holder class idiom. 
 */
public class ResourceFactory {

	private static class ResourceHolder {
		public static Resource resource = new ResourceImpl();
	}
	
	public static Resource getResource() {
		return ResourceHolder.resource;
	}
}
