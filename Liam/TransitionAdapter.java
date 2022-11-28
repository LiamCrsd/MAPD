package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractTransition;

public class TransitionAdapter extends AbstractTransition {

	private Transition adaptee;
	
	public TransitionAdapter(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	public TransitionAdapter(String label, Transition adaptee) {
		super(label);
		this.adaptee = adaptee;
	}

	public Transition getTransition() {
		return this.adaptee;
	}
	
}
