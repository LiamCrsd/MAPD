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
	 //On est dans le cas fireable donc les exceptions ne peuvent pas arriver 
	 try {
		t.fire();
	} catch (NegativeNumberException e) {
		// Cas impossible
	}
 }

 public Place CreatePlace(){
     Place p = new Place();
     this.places.add(p);
     return p;
   }

 public Place CreatePlace(int nbToken) {
   try {
     Place p = new Place(nbToken);
     this.places.add(p);
     return p;
    }
    catch (NegativeNumberException e){
    	System.out.println("\n /!\\ Une place doit avoir un nombre de jetons supérieur à 0\n");
    	return null;
    }

 }

 public Transition CreateTransition() {
   Transition t = new Transition();
   this.transitions.add(t);
   return t;
 }

 public IncomingArc CreateIncommingArc(int weight, Place p) {
	 IncomingArc a;
	 try {
		 a = new IncomingArc(weight, p);
		 this.arcs.add(a);
		 return a;
	 } catch (NegativeNumberException e) {
		 System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
	 }
	 return null;
  }

 public IncomingArc CreateIncommingArc(int weight, Place p, Transition t) {
	 IncomingArc a;
	 try {
		 a = new IncomingArc(weight, p);
		 this.arcs.add(a);
		 t.addArcIn(a);
		 return a;
	 } catch (NegativeNumberException e) {
		 System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");;
	 }
	 return null;
  }
 
 public IncomingArc CreateZeroArc(Place p) {
    IncomingArc a;
	try {
		a = new ZeroArc(p);
		this.arcs.add(a);
	    return a;
	} catch (NegativeNumberException e) {
		System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
	}
    return null;
  }

 public IncomingArc CreateZeroArc(Place p, Transition t) {
	    IncomingArc a;
		try {
			a = new ZeroArc(p);
			this.arcs.add(a);
			t.addArcIn(a);
		    return a;
		} catch (NegativeNumberException e) {
			System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
		}
	    return null;
	  }

 public IncomingArc CreateEmptyArc(Place p) {
    IncomingArc a;
	try {
		a = new EmptyArc(p);
	    this.arcs.add(a);
	    return a;
	} catch (NegativeNumberException e) {
		System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
	}
	return null;
  }

 public IncomingArc CreateEmptyArc(Place p, Transition t) {
	    IncomingArc a;
		try {
			a = new EmptyArc(p);
		    this.arcs.add(a);
		    t.addArcIn(a);
		    return a;
		} catch (NegativeNumberException e) {
			System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
		}
		return null;
	  }
 
 public OutgoingArc CreateOutgoingArc(int w,Place p) {
	  OutgoingArc a;
	  try {
		  a = new OutgoingArc(w,p);
		  this.arcs.add(a);
		  return a;
	  } catch (NegativeNumberException e) {
		  System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
	  }
	  return null;
  }

 public OutgoingArc CreateOutgoingArc(int w,Transition t,Place p) {
	  OutgoingArc a;
	  try {
		  a = new OutgoingArc(w,p);
		  this.arcs.add(a);
		  t.addArcOut(a);
		  return a;
	  } catch (NegativeNumberException e) {
		  System.out.println("\n /!\\ Un arc doit avoir un poids supérieur ou égal à 0\n");
	  }
	  return null;
 }
 
 public void affichage() {
	 System.out.println("Réseau de Petri");
	 System.out.println("  " + this.places.size() + " places");
	 System.out.println("  " + this.transitions.size() + " transitions");
	 System.out.println("  " + this.arcs.size() + " arcs");
	 int i = 1;
	 System.out.println("Liste des places :");
	 for(Place p : this.places) {
		 System.out.println("  " + i + " : place avec " + p.getNbToken() + " jetons.");
		 i++;
	 }
	 i = 1;
	 System.out.println("Liste des transitions :");
	 for(Transition t : this.transitions) {
		 System.out.println("  " + i + " : transition avec " + t.getNbArcIn() + " arc entrant et " + t.getNbArcOut() + " arc sortant.");
		 i++;
	 }
	 i = 1;
	 System.out.println("Liste des arcs :");
	 for(Arc a : this.arcs) {
		 if (a.isIncoming() == false) {
			 System.out.println("  " + i + " : arc simple poids " + a.getWeight() + " (transiton vers place)");
		 } 
		 else {
			 System.out.println("  "+ i + " : arc simple poids " + a.getWeight() + " (place vers transition, fireable : " + a.getPlace().isFireable(a.getWeight())+")");
		 }
		 i++;
	 }
 }
}
