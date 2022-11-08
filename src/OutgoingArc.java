//package src;

public class OutgoingArc extends Arc{
	/**
	 * Une classe pour manipuler des arcs sortants
	 */

	public OutgoingArc(int w, Place p) throws NegativeNumberException {
		/**
		 * Constructeur d'arc sortant
		 * @param int le poids de l'arc, Place la place liée à l'arc
		 * @throws NegativeNumberException
		 */
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIncoming() {
		/**
		 * Une méthode pour savoir si l'arc est entrant
		 * @return false
		 */
		return false;
	}
	
	public void Fire() throws NegativeNumberException {
		place.addToken(this.getWeight());
	}
}
