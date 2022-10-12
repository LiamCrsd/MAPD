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
 
}
