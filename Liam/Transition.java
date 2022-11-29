//package src;
package org.pneditor.petrinet.adapters.Liam;
import java.util.ArrayList;

public class Transition{
	/**
	 * Une classe pour manipuler des transitions dans un réseau de Pétri
	 */

  public ArrayList<IncomingArc> IncomingArcs;
  public ArrayList<OutgoingArc> OutgoingArcs;

  public Transition(){
	  /**
	   * Constructeur de transition
	   * @param aucun
	   */
    this.IncomingArcs = new ArrayList<IncomingArc>();
    this.OutgoingArcs = new ArrayList<OutgoingArc>();
  }

  public Transition(ArrayList<IncomingArc> incomings, ArrayList<OutgoingArc> outgoings){
	  /**
	   * Constructeur de transition
	   * @param ArrayList<IncomingArc>, ArrayList<OutgoingArc> les listes des arcs entrants et sortants de la transition
	   */
    this.IncomingArcs = incomings;
    this.OutgoingArcs = outgoings;
  }

  public int getNbArcIn() {
	  /**
	   * Une méthode pour obtenir le nombre d'arcs entrants dans la transition
	   * @return int le nombre d'arcs entrants
	   */
	  return this.IncomingArcs.size();
  }
  
  public int getNbArcOut() {
	  /**
	   * Une méthode pour obtenir le nombre d'arcs sortants dans la transition
	   * @return int le nombre d'arcs sortants
	   */
	  return this.OutgoingArcs.size();
  }
  
  public IncomingArc addArcIn(IncomingArc a){
	  /**
	   * Une méthode pour relier un arc entrant existant à la transition
	   * @param IncomingArc l'arc entrant à relier
	   * @return un arc s'il existe déjà un arc entrant dans la transition, null sinon
	   */
	for (IncomingArc atemp : this.IncomingArcs) {
		if (a.getPlace().equals(atemp.getPlace())) { //on vérifie que l'arc n'existe pas déjà pour ne pas avoir d'arc doublés
			return atemp;
		}
	}
    this.IncomingArcs.add(a);
    return null;
  }

  public OutgoingArc addArcOut(OutgoingArc a){
	  /**
	   * Une méthode pour relier un arc sortant existant à la transition
	   * @param OutgoingArc L'arc sortant à relier
	   */
	for (OutgoingArc atemp : this.OutgoingArcs) {
		if (a.getPlace().equals(atemp.getPlace())) {
			return atemp;
		}
	}
    this.OutgoingArcs.add(a);
    return null;
  }

  public void addArc(Arc a) {
	  /**
	   * Une méthode pour relier un arc à la transition
	   * @param Arc l'arc à relier
	   */
	if (a instanceof IncomingArc) { // on regarde si l'arc est entrant ou sortant
		this.addArcIn((IncomingArc) a);
	} else {
		this.addArcOut((OutgoingArc) a);
	}
  }
  
  public boolean delArcIn(IncomingArc a){
	  /**
	   * Une méthode pour délier un arc entrant de la transition
	   */
    if (this.IncomingArcs.contains(a)){ //on vérifie que l'arc en argument est bien lié à la Transition
      this.IncomingArcs.remove(a);
      return true;
    }
    return false;
  }
  public boolean delArcOut(OutgoingArc a){
	  /**
	   * Une méthode pour délier un arc sortant de la transition
	   */
    if (this.OutgoingArcs.contains(a)){
      this.OutgoingArcs.remove(a);
      return true;
    }
    return false;
  }

  public boolean isFireable(){
	  /**
	   * Une méthode qui vérifie si la transition est tirable
	   * @return boolean true si la transition est tirable, false sinon
	   */
    int size = this.IncomingArcs.size();
    boolean var = true;
    for(int i = 0; i < size;i++){
      var = var && (this.IncomingArcs.get(i)).isFireable();
    }
    return var;
  }

  public void fire() throws NegativeNumberException{
	  /**
	   * Une méthode pour tirer la transition
	   * @param aucun
	   * @return void
	   * @throws NegativeNumberException
	   */
    if (this.isFireable()){
      int sizeIncoming = this.IncomingArcs.size();
      int sizeOutgoing = this.OutgoingArcs.size();
      for (int i = 0;i < sizeIncoming; i++){ 
        (this.IncomingArcs.get(i)).Fire(); //on appelle la méthode Fire de la classe IncomingArc sur les arcs reliés à la transition
      }
    for (int i = 0;i < sizeOutgoing; i++){
      (this.OutgoingArcs.get(i)).Fire(); //de même pour les arcs sortants
    }
    }
    else {
    	System.out.println("The transition is not fireable");
    }
  }

}
