package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
//import org.pneditor.petrinet.adapters.Liam.Arc;

public class IncomingArcAdapter extends AbstractArc{
	
	private AbstractNode destination;
	private IncomingArc adaptee;

	public IncomingArcAdapter(IncomingArc adaptee, AbstractNode destination) {
		this.adaptee = adaptee;
		this.destination = destination;
	}
	
	
	
	@Override
	public AbstractNode getSource() {
			Place source = adaptee.getPlace();
			PlaceAdapter pls = new PlaceAdapter("",source);
			return pls; //pb de casting de Place vers AbstractNode
	}

	@Override
	public AbstractNode getDestination() {
		
		return this.destination;
	}

	@Override
	public boolean isReset() {
		if (adaptee.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isRegular() {
		if (adaptee.isEmpty()) {
			return false;
		}
		if (adaptee.isZero()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isInhibitory() {
		if (adaptee.isZero()) {
			return true;
		}
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return adaptee.getWeight();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
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
