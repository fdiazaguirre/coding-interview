package edu.fdiazaguirre.cracking;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Singleton and threadSafe
 *
 */
public class IdGenerator {
    private AtomicInteger id = new AtomicInteger();
    private int delta = 13;
    private static IdGenerator instance = null;
    
    private IdGenerator(){};
    
    public static IdGenerator getInstance(){
    	if(instance == null){
    		instance = new IdGenerator();
    	}
    	return instance;
    }
    
    public int getId() {
        return id.addAndGet(delta) ;
    }
}
