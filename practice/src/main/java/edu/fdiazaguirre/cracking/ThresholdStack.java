package edu.fdiazaguirre.cracking;

import java.util.ArrayList;
import java.util.List;

public class ThresholdStack implements Stack {

	private int threshold;
	private List<StackImpl> stacks = new ArrayList<StackImpl>();
	
	public ThresholdStack(int stackCapacity) {
		this.threshold = stackCapacity;
	}
	
	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
