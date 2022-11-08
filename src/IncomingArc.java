//package src;

public class IncomingArc extends Arc{
	/**
	 *Une classe pour manipuler des arcs entrants
	 */

	public IncomingArc(int w, Place p) throws NegativeNumberException {
		/**
		 * Constructeur d'arc entrant
		 * @param int le poids de l'arc, Place la place liée à l'arc
		 * @throws NegativeNumberException
		 */
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIncoming() {
		/**
		 * Une méthode pour savoir si l'arc est entrant ou non
		 * @return true
		 */
		return true;
	}
	
	public boolean isFireable() {
		return this.place.isFireable(this.getWeight());
	}
	
	public boolean isZero() {
		/**
		 * Une méthode pour savoir si l'arc est zéro 
		 * @return false
		 */
		return false;		
	}
	public boolean isEmpty() {
		/**
		 * Une méthode pour savoir si l'arc est videur
		 * @return false
		 */
		return false;
	}
	public void Fire() throws NegativeNumberException {
		place.subToken(this.getWeight());
	}
}
