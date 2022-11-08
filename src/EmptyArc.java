//package src;

public class EmptyArc extends IncomingArc{
	/**
	 * Une classe pour manipuler les arcs videurs d'un réseau de Pétri
	 */

	public EmptyArc(Place p) throws NegativeNumberException {
		/**
		 * Un constructeur pour arcs videurs
		 * @param Place la place liée à l'arc videur
		 * @throws NegativeNumberException
		 */
		super(0, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		/**
		 * Une méthode pour savoir si l'arc est videur ou non
		 * @return true
		 */
		return true;
	}
	public boolean isZero() {
		/**
		 * Une méthode pour savoir si l'arc est zéro ou non
		 * @return false
		 */
		return false;
	}
	
	public boolean isFireable() {
		return this.place.isFireable(1);
	}
	
	public void Fire() {
		if (this.isFireable()) {
		place.empty();
		}
	}
}
