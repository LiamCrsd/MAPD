//package src;

import java.util.ArrayList;

public class Transition{

  public ArrayList<IncomingArc> IncomingArcs;
  public ArrayList<OutgoingArc> OutgoingArcs;

  public Transition(){
    this.IncomingArcs = new ArrayList<IncomingArc>();
    this.OutgoingArcs = new ArrayList<OutgoingArc>();
  }

  public Transition(ArrayList<IncomingArc> incomings, ArrayList<OutgoingArc> outgoings){
    this.IncomingArcs = incomings;
    this.OutgoingArcs = outgoings;
  }

  public int getNbArcIn() {
	  return this.IncomingArcs.size();
  }
  
  public int getNbArcOut() {
	  return this.OutgoingArcs.size();
  }
  
  public IncomingArc addArcIn(IncomingArc a){
	for (IncomingArc atemp : this.IncomingArcs) {
		if (a.getPlace().equals(atemp.getPlace())) {
			return atemp;
		}
	}
    this.IncomingArcs.add(a);
    return null;
  }

  public void addArcOut(OutgoingArc a){
    this.OutgoingArcs.add(a);
  }

  public void addArc(Arc a) {
	if (a instanceof IncomingArc) {
		this.addArcIn((IncomingArc) a);
	} else {
		this.addArcOut((OutgoingArc) a);
	}
  }
  
  public boolean delArcIn(IncomingArc a){
    if (this.IncomingArcs.contains(a)){
      this.IncomingArcs.remove(a);
      return true;
    }
    return false;
  }
  public boolean delArcOut(OutgoingArc a){
    if (this.OutgoingArcs.contains(a)){
      this.OutgoingArcs.remove(a);
      return true;
    }
    return false;
  }

  public boolean isFireable(){
    int size = this.IncomingArcs.size();
    boolean var = true;
    for(int i = 0; i < size;i++){
      var = var && (this.IncomingArcs.get(i)).isFireable();
    }
    return var;
  }

  public void fire() throws NegativeNumberException{
    if (this.isFireable()){
      int sizeIncoming = this.IncomingArcs.size();
      int sizeOutgoing = this.OutgoingArcs.size();
      for (int i = 0;i < sizeIncoming; i++){
        (this.IncomingArcs.get(i)).Fire();
      }
    for (int i = 0;i < sizeOutgoing; i++){
      (this.OutgoingArcs.get(i)).Fire();
    }
    }
    else {
    	System.out.println("The transition is not fireable");
    }
  }

}
