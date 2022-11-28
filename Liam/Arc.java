//package src;
package org.pneditor.petrinet.adapters.Liam;
public class Arc{
	/**
	 * Une classe pour manipuler les arcs d'un réseau de Pétri
	 */

	private int weight;
	protected Place place;

	public Arc(int w, Place p) throws NegativeNumberException{
		/**
		 * Un constructeur d'arc
		 * @param int le poids de l'arc, Place la palce liée à l'arc
		 * @throws NegativeNumberException
		 */
		if (w < 0) {
			throw new NegativeNumberException("Le poids d'un arc ne peut pas être négatif");
		}
		this.weight = w;
		this.place = p;
	}

	public void modifyWeight(int newValue) throws NegativeNumberException{
		/**
		 * Une méthode pour modifier le poids d'un arc
		 * @param int la nouvelle valeur à donner au poids
		 * @throws NegativeNumberException
		 * @return void
		 */
		if (newValue < 0) {
			throw new NegativeNumberException("Le poids d'un arc ne peut pas être négatif");
		}
		this.weight= newValue;
	}

	public Place getPlace() {
		/**
		 * Une méthode pour obtenir la place reliée à l'arc
		 * @param aucun
		 * @return Place la place
		 */
		return this.place;
	}
	
	public int getWeight() {
		/**
		 * Une méthode pour obtenir le poids de l'arc
		 * @param aucun
		 * @return int le poids
		 */
		return this.weight;
	}

	public boolean isIncoming() {
		/**
		 * Une méthode pour savoir si l'arc manipulé est entrant ou non
		 * @param aucun
		 * @return boolean
		 */
		return false;
	}
}
