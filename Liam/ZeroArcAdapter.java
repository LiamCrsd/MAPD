package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractNode;

public class ZeroArcAdapter extends IncomingArcAdapter {

	public ZeroArcAdapter(ZeroArc adaptee, AbstractNode destination) {
		super(adaptee,destination);
		// TODO Auto-generated constructor stub
	}

	public boolean isReset() {
		return false;
	}
}
