package org.pneditor.petrinet.adapters.Liam;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;

public class PetriNetAdapter extends PetriNetInterface{
	
	private PetriNet pn;
	
	public PetriNetAdapter() {
		this.pn = new PetriNet();
	}
	
	@Override
	public AbstractPlace addPlace() {
		Place p = this.pn.CreatePlace();
		PlaceAdapter res = new PlaceAdapter("",p);
		return res;
	}

	@Override
	public AbstractTransition addTransition() {
		Transition t = this.pn.CreateTransition();
		TransitionAdapter res = new TransitionAdapter("",t);
		return res;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		
		try {
			int counter = this.pn.getNbArcs();
			Place p = ((PlaceAdapter)source).getPlace();
			Transition t = ((TransitionAdapter)destination).getTransition();
			IncomingArc a = this.pn.CreateIncommingArc(1, p, t);
			IncomingArcAdapter res = new IncomingArcAdapter(a,destination);
			int counter2 = this.pn.getNbArcs();
			if (counter == counter2) {
				throw new DoubleArcException("Arc déjà existant");
			}
			return res;	
		}
		catch (DoubleArcException e) {
			throw new UnimplementedCaseException("An arc is already create between this source and destination");
		}
		catch (Exception e2) {
			try {
				int counter = this.pn.getNbArcs();
				Place p = ((PlaceAdapter)destination).getPlace();
				Transition t = ((TransitionAdapter)source).getTransition();
				OutgoingArc a = this.pn.CreateOutgoingArc(1, t, p);
				OutgoingArcAdapter res = new OutgoingArcAdapter(a,source);
				int counter2 = this.pn.getNbArcs();
				if (counter == counter2) {
					throw new DoubleArcException("Arc déjà existant");
				}
				return res;
			}
			catch (DoubleArcException e) {
				throw new UnimplementedCaseException("An arc is already create between this source and destination");
			}
			catch (Exception eGlobal) {
				System.out.println("\n \n ATTENTION CA BUG \n \n");
				throw new UnimplementedCaseException("Je sais pas ca bug");
			}
		}

	}
	
	
	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		 try {
			int counter = this.pn.getNbArcs();
			Place p = ((PlaceAdapter)place).getPlace();
			Transition t = ((TransitionAdapter)transition).getTransition();
			IncomingArc a = this.pn.CreateZeroArc(p, t);
			IncomingArcAdapter res = new IncomingArcAdapter(a,transition);
			int counter2 = this.pn.getNbArcs();
			if (counter == counter2) {
				throw new DoubleArcException("Arc doublé");
			}
			return res;		
		 }
		 catch (DoubleArcException e) {
			 throw new UnimplementedCaseException("An arc is already create between this source and destination");
		 }
		 catch (Exception e2) {
			 throw new UnimplementedCaseException("Je sais pas ca bug inhibitory"); 
		 }
		
	}
	
	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		 try {
			int counter = this.pn.getNbArcs();
			Place p = ((PlaceAdapter)place).getPlace();
			Transition t = ((TransitionAdapter)transition).getTransition();
			IncomingArc a = this.pn.CreateEmptyArc(p, t);
			IncomingArcAdapter res = new IncomingArcAdapter(a,transition);
			int counter2 = this.pn.getNbArcs();
			if (counter == counter2) {
				throw new DoubleArcException("");
			}
			return res;		
		 }
		 catch (DoubleArcException e) {
			 throw new UnimplementedCaseException("An arc is already create between this source and destination");
		 }
		 catch (Exception e2) {
			 throw new UnimplementedCaseException("Je sais pas ca bug reset"); 
		 }
			
	}
	

	@Override
	public void removePlace(AbstractPlace place) {
		try {
			Place p = ((PlaceAdapter)place).getPlace();
			this.pn.DelPlace(p);
		}
		catch (Exception e) {
			System.out.println("Attention erreur, remove place");
		}
		
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		try {
			Transition t = ((TransitionAdapter)transition).getTransition();
			this.pn.DelTransition(t);
		}
		catch (Exception e) {
			System.out.println("Attention erreur, remove transition");
		}
		
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		try {
			Arc a = ((IncomingArcAdapter)arc).getArc();
			this.pn.DelArc(a);
		}
		catch (Exception e) {
			try {
				Arc a = ((OutgoingArcAdapter)arc).getArc();
				this.pn.DelArc(a);
			}
			catch (Exception e2) {
				System.out.println("Attention erreur, remove arc");
			}
		}
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		try {
			Transition t = ((TransitionAdapter)transition).getTransition();
			return this.pn.isFireable(t);
		}
		catch (Exception e) {
			System.out.println("Attention erreur, is Enabled");
			return false;
		}
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		try {
			Transition t = ((TransitionAdapter)transition).getTransition();
			this.pn.Fire(t);
		}
		catch (Exception e) {
			System.out.println("Attention erreur, fire");

		}
	}


}
