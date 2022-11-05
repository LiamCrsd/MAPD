//package src;

public class Place{
	private int nbTokens;

	public Place() {
		this.nbTokens = 0;
	}

	public Place(int i) throws NegativeNumberException{
		if (i < 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}
		this.nbTokens = i;
	}

	public void addToken(int nb) throws NegativeNumberException{
		if (nb < 0) {
			throw new NegativeNumberException("Le nombre de tokens ajouté ne peut pas être négatif");
		}
		if (nb + this.nbTokens < 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}
		this.nbTokens += nb;

	}

	public void subToken(int nb) throws NegativeNumberException{
		if (nb < 0) {
			throw new NegativeNumberException("Le nombre de tokens retiré ne peut pas être négatif");
		} else if (this.nbTokens >= nb) {
			this.nbTokens -= nb;
		} else {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}

	}
	public void empty() {
		this.nbTokens = 0;
	}

	public boolean isFireable(int arcWeight) {
		return this.nbTokens >= arcWeight;
	}

	public boolean isEmpty() {
		return this.nbTokens == 0;
	}

	public int getNbToken() {
		//Pour tester
		return this.nbTokens;
	}
}
