//package src;

public class Place{
	/**
	 * Une classe pour manipuler les places dans un réseau de Pétri
	 */
	private int nbTokens;

	public Place() {
		/**
		 * Constructeur de place, nombre de jetons 0 par défaut
		 * @param aucun
		 */
		this.nbTokens = 0;
	}

	public Place(int i) throws NegativeNumberException{
		/**
		 * Constructeur de place
		 * @param int le nombre de jetons
		 */
		if (i < 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}
		this.nbTokens = i;
	}

	public void addToken(int nb) throws NegativeNumberException{
		/**
		 * Une méthode pour ajouter des jetons à une place existante
		 * @param int le nombre de jetons à ajouter
		 * @throws NegativeNumberException
		 */
		if (nb < 0) {
			throw new NegativeNumberException("Le nombre de tokens ajouté ne peut pas être négatif");
		}
		if (nb + this.nbTokens < 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}
		this.nbTokens += nb;

	}

	public void subToken(int nb) throws NegativeNumberException{
		/**
		 * Une méthode pour retirer des jetons à une place existante
		 * @param int le nombre de jetons à retirer
		 * @throws NegativeNumberException
		 */
		
		if (nb < 0) {
			throw new NegativeNumberException("Le nombre de tokens retiré ne peut pas être négatif");
		} else if (this.nbTokens >= nb) {
			this.nbTokens -= nb;
		} else {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}

	}
	public void empty() {
		/**
		 * Une méthode pour vider une place existante de jetons
		 */
		this.nbTokens = 0;
	}

	public boolean isFireable(int arcWeight) {
		return this.nbTokens >= arcWeight;
	}

	public boolean isEmpty() {
		/** 
		 * Une méthode pour savoir si la place est vide
		 * @return boolean
		 */
		return this.nbTokens == 0;
	}

	public int getNbToken() {
		//Pour tester
		return this.nbTokens;
	}
}
