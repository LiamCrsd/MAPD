package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractNode;

public class EmptyArcAdapter extends IncomingArcAdapter {

	public EmptyArcAdapter(EmptyArc adaptee, AbstractNode destination) {
		super(adaptee,destination);
		// TODO Auto-generated constructor stub
	}

	public boolean isReset() {
		return true;
	}
}
