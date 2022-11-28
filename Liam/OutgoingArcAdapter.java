package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;

public class OutgoingArcAdapter extends AbstractArc {
	
	private OutgoingArc adaptee;
	private AbstractNode source;
	
	public OutgoingArcAdapter(OutgoingArc a,AbstractNode source) {
		this.adaptee = a;
		this.source = source;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractNode getSource() {
		// TODO Auto-generated method stub
		return this.source;
	}

	@Override
	public AbstractNode getDestination() {
		Place destination = adaptee.getPlace();
		PlaceAdapter res = new PlaceAdapter("",destination);
		return res;
	}

	@Override
	public boolean isReset() {
		return false;
	}

	@Override
	public boolean isRegular() {
		return true;
	}

	@Override
	public boolean isInhibitory() {
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return adaptee.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		try {
			adaptee.modifyWeight(multiplicity);
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Arc getArc() {
		return this.adaptee;
	}

}
