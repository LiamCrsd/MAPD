//package src;

import java.util.ArrayList;

public class PetriNet{
	/**
	 * Une classe permettant de manipuler un réseau de Pétri
	 */
	
  private ArrayList<Place> places;
  private ArrayList<Transition> transitions;
  private ArrayList<Arc> arcs;

 public PetriNet(){
    this.places = new ArrayList<Place>();
    this.transitions = new ArrayList<Transition>();
    this.arcs = new ArrayList<Arc>();
  }

 public int getNbPlaces() {
	 /**
	  * Renvoie le nombre de places dans le réseau
	  * @return int le nombre de places
	  */
	  return places.size();
  }

 public int getNbArcs() {
	 /**
	  * Renvoie le nombre d'arcs dans le réseau
	  * @return int le nombre d'arcs
	  */
	  return arcs.size();
  }

 public int getNbTransitions() {
	 /**
	  * Renvoie le nombre de transitions dans le réseau
	  * @return int le nombre de transitions
	  */
	 return transitions.size();
 }

 public boolean isFireable(Transition t) {
	 /**
	  * Indique si une transition est tirable
	  * @param Transition une transition
	  * @return boolean 
	  */
	 return t.isFireable();
 }
 
 public void Fire(Transition t) {
	 /**
	  * Tire une transition
	  * @param Transition une transition
	  * @return void
	  */
	 //On est dans le cas fireable donc les exceptions ne peuvent pas arriver 
	 try {
		t.fire();
	} catch (NegativeNumberException e) {
		// Cas impossible
	}
 }

 public Place CreatePlace(){
	 /**
	  * Une méthode pour créer une place dans le réseau
	  * @param aucun
	  * @return Place la place
	  */
     Place p = new Place();
     this.places.add(p);
     return p;
   }

 public Place CreatePlace(int nbToken) {
	 /**
	  * Une méthode pour créer une place dans le réseau
	  * @param int un nombre de jetons à ajouter 
	  * @return Place la place
	  */
   try {
     Place p = new Place(nbToken);
     this.places.add(p);
     return p;
    }
    catch (NegativeNumberException e){
    	System.out.println("\n /!\\ Une place doit avoir un nombre de jetons sup�rieur � 0\n");
    	return null;
    }

 }

 public Transition CreateTransition() {
	 /**
	  * Une méthode pour créer une transition dans le réseau
	  * @param aucun
	  * @return Transition la transition créée
	  */
   Transition t = new Transition();
   this.transitions.add(t);
   return t;
 }


 public IncomingArc CreateIncommingArc(int weight, Place p, Transition t) {
	 /**
	  * Une méthode pour crééer un arc entrant et l'ajouter au réseau
	  * @param int le poids de la transition, Place la place reliée à l'arc, Transition la transition liée à l'arc
	  * @return IncomingArc l'arc créé ou null
	  */
	 IncomingArc a;
	 try {
		 a = new IncomingArc(weight, p);
		 IncomingArc atemp = t.addArcIn(a);
		 if (atemp == null) {
			 this.arcs.add(a);
			 return a;
		 }
		 else {
			 return atemp;
		 }
	 } catch (NegativeNumberException e) {
		 System.out.println("\n /!\\ Un arc doit avoir un poids sup�rieur ou �gal � 0\n");;
	 }
	 return null;
  }
 
 public IncomingArc CreateZeroArc(Place p, Transition t) {
	 /**
	  * Une méthode pour crééer un arc zéro et l'ajouter au réseau
	  * @param Place la place reliée à l'arc, Transition la transition liée à l'arc
	  * @return ZeroArc l'arc créé ou null
	  */
	    IncomingArc a;
		try {
			a = new ZeroArc(p);	
			IncomingArc atemp = t.addArcIn(a);
			if (atemp == null) {
				this.arcs.add(a);
				return a;
			}
			else {
				return atemp;
			}
		    
		} catch (NegativeNumberException e) {
			System.out.println("\n /!\\ Un arc doit avoir un poids sup�rieur ou �gal � 0\n");
		}
	    return null;
	  }


 public IncomingArc CreateEmptyArc(Place p, Transition t) {
	 /**
	  * Une méthode pour crééer un arc videur et l'ajouter au réseau
	  * @param Place la place reliée à l'arc, Transition la transition liée à l'arc
	  * @return EmptyArc l'arc créé ou null
	  */
	    IncomingArc a;
		try {
			a = new EmptyArc(p);
			IncomingArc atemp = t.addArcIn(a);
		    if (atemp == null) {
			    this.arcs.add(a);
			    return a;
		    }
		    else {
		    	return atemp;
		    }
		} catch (NegativeNumberException e) {
			System.out.println("\n /!\\ Un arc doit avoir un poids sup�rieur ou �gal � 0\n");
		}
		return null;
	  }
 
 public OutgoingArc CreateOutgoingArc(int w,Transition t,Place p) {
	 /**
	  * Une méthode pour crééer un arc sortant et l'ajouter au réseau
	  * @param int le poids de l'arc, Transition la transition liée à l'arc, Place la place reliée à l'arc
	  * @return OutgoingArc l'arc créé ou null
	  */
	  OutgoingArc a;
	  try {
		  a = new OutgoingArc(w,p);
		  this.arcs.add(a);
		  t.addArcOut(a);
		  return a;
	  } catch (NegativeNumberException e) {
		  System.out.println("\n /!\\ Un arc doit avoir un poids sup�rieur ou �gal � 0\n");
	  }
	  return null;
 }
 
 public void DelArc(Arc a) {
	 /**
	  * Une méthode pour supprimer un arc du réseau
	  * @param Arc l'arc à supprimer
	  * @return void
	  */
	 boolean temp = false;
	 for (Arc atemp : this.arcs) {
		 if (atemp.equals(a)) {
			 temp = true;
			 for (Transition t : this.transitions) {
				 if (a.isIncoming()) {
					 t.delArcIn((IncomingArc) a);
				 }
				 else {
					 t.delArcOut((OutgoingArc) a);
				 }
			 }
		 }
	 }
	 if (!temp) {
		 System.out.println("Arc non existant dans le reseau");
	 }
	 else {
		 this.arcs.remove(a);
	 }
 }

 public void DelPlace(Place p) {
	 /**
	  * Une méthode pour supprimer une place du réseau
	  * @param Place la place à supprimer
	  * @return void
	  */
	 boolean temp = false;
	 for (Place ptemp : this.places) {
		 if (ptemp.equals(p)) {
			 temp = true;
			 ArrayList<Arc> adel = new ArrayList<Arc>();
			 for (Arc a : this.arcs) {
				 if (a.getPlace().equals(p)) {
					adel.add(a);
				 }
			 }
			 for (Arc a : adel) {
				 this.DelArc(a);
			 }
		 } 
	 }
	 if (!temp) {
		 System.out.println("Place inconnue");
	 }
	 else {
		 this.places.remove(p);
	 }
 }

 public void DelTransition(Transition t) {
	 /**
	  * Une méthode pour supprimer une transition du réseau
	  * @param Transition la transition à supprimer
	  * @return void
	  */
	 boolean temp = false;
	 for (Transition ttemp : this.transitions) {
		 if (ttemp.equals(t)) {
			 temp = true;
			 ArrayList<Arc> adel = new ArrayList<Arc>();
			 for (Arc a : t.IncomingArcs) {
				 adel.add(a);
			 }
			 for (Arc a : t.OutgoingArcs) {
				 adel.add(a);
			 }
			 for (Arc a : adel) {
				 this.DelArc(a);
			 }
		 }
	 }
	 if (!temp) {
		 System.out.println("Transition inconnue");
	 }
	 else {
		 this.transitions.remove(t);
	 }
 }
 
 public void affichage() {
	 /**
	  * Une méthode pour afficher le réseau de Pétri
	  * @param aucun
	  * @return void
	  */
	 System.out.println("R�seau de Petri");
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
		 System.out.println("  " + i + " : transition avec " + t.getNbArcIn() + " arc entrant et " + t.getNbArcOut() + " arc sortant. Fireable : " + t.isFireable());
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
