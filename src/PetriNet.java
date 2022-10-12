package src;

public class PetriNet{
  private ArrayList<Place> places;
  private ArrayList<Transition> transitions;
  private ArrayList<Arc> arcs;

  public PetriNet(){
    this.places = new ArrayList<Place>();
    this.transitions = new ArrayList<Transition>();
    this.arcs = new ArrayList<Arc>();
  }

  
}
