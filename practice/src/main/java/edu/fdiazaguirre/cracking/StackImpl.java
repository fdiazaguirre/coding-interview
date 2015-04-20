package edu.fdiazaguirre.cracking;

import java.util.ArrayList;
import java.util.List;

public class StackImpl implements Stack{

	private List elements = new ArrayList();
	
	@Override
	public void push(Object newElement) {
		this.elements.add(newElement);
	}

	@Override
	public Object pop() {
		if (!isEmpty()) {
			return this.elements.get(elements.size());
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.elements.size() < 1;
	}

}
