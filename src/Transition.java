package src;

import java.utils.List;

public class Transition{

  private ArrayList<IncomingArc> IncomingArcs;
  private ArrayList<OutgoingArc> OutgoingArcs;

  public Transition(){
    this.IncomingArcs = new ArrayList<IncomingArc>();
    this.OutgoingArcs = new ArrayList<OutgoingArc>();
  }

  public Transition(ArrayList<IncomingArc> incomings, ArrayList<OutgoingArc> outgoing){
    this.IncomingArcs = incomings;
    this.OutgoingArcs = outgoings;
  }

  public void addArcIn(IncomingArc a){
    this.IncomingArcs.add(a);
  }

  public void addArcOut(OutgoingArc a){
    this.OutgoingArcs.add(a);
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

  public boolean isFirable(){
    int size = this.IncomingArcs.size();
    boolean var = true;
    for(int i = 0; i < size;i++){
      var = var && (this.IncomingArcs.get(i)).isFirable();
    }
    return var;
  }

  public void fire(){
    if (this.isFirable()){
      int sizeIncoming = this.IncomingArcs.size();
      int sizeOutgoing = this.OutgoingArcs.size();
      for (int i = 0;i < sizeIncoming; i++){
        (this.IncomingArcs.get(i)).fire()
      }
    }
    for (int i = 0;i < sizeOutgoing; i++){
      (this.OutgoingArcs.get(i)).fire()
    }
  }

}
