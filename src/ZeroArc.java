//package src;

public class ZeroArc extends IncomingArc{
	/**
	 * Une classe pour manipuler des arcs zéros d'un réseau de Pétri
	 */

	public ZeroArc(Place p) throws NegativeNumberException {
		/**
		 * Constructeur d'arc zéro
		 * @throws NegativeNumberException
		 * @param Place la place liée à l'arc zéro
		 */
		super(0, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isZero() {
		/**
		 * Une méthode pour savoir si l'arc est zéro
		 * @return true
		 */
		return true;
	}
	
	public boolean isFireable() {
		return this.place.isEmpty();
	}
	
	public void fire() {
		if (this.isFireable()) {
			//y a pas de pass en java
			int i =1;
			i += i;
		}
	}
	
}
