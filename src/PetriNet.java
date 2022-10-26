//package src;

import java.util.ArrayList;

public class PetriNet{
  private ArrayList<Place> places;
  private ArrayList<Transition> transitions;
  private ArrayList<Arc> arcs;
  private String name;


  public PetriNet(){
    this.places = new ArrayList<Place>();
    this.transitions = new ArrayList<Transition>();
    this.arcs = new ArrayList<Arc>();
  }

  public String getName() {
	  return this.name;
  }

  public int getNbPlaces() {
	  return places.size();
  }

  public int getNbArcs() {
	  return arcs.size();
  }

 public int getNbTransitions() {
	 return transitions.size();
 }

 public boolean isFireable(Transition t) {
	 return t.isFireable();
 }
 public void Fire(Transition t) {
	 t.fire();
 }

   public Place CreatePlace() throws NegativeNumberException {
     Place p = new Place();
     this.places.add(p);
     return p;
   }

 public Place CreatePlace(int nbToken) throws NegativeNumberException {
   try {
     Place p = new Place(nbToken);
     this.places.add(p);
     return p;
    }
    catch (NegativeNumberException e){
      e.printStackTrace();
    }

 }

 public Transition CreateTransition() {
   Transition t = new Transition();
   this.transitions.add(t);
   return t;
 }

 public IncomingArc CreateIncommingArc(int weight, boolean iszero, boolean isempty, Place p) {
   if (iszero && isempty) {
     //raise une Exception
   }
     else {
     if (iszero) {
       IncomingArc a = new ZeroArc(p);
     } else {
       if (isempty) {
         IncomingArc a = new EmptyArc(p);
       } else {
         IncomingArc a = new IncomingArc(weight,p)
       }
     }
    }
    this.arcs.add(a);
    return a;
  }

  public IncomingArc CreateZeroArc(Place p) {
    IncomingArc a = new ZeroArc(p);
    this.arcs.add(a);
    return a;
  }

  public IncomingArc CreateEmptyArc(Place p) {
    IncomingArc a = new EmptyArc(p);
    this.arcs.add(a);
    return a;
  }


}
