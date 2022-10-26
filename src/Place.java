//package src;

public class Place{
	private int nbTokens;
	
	public Place() {
		this.nbTokens = 0;
	}
	
	public Place(int i) {
		this.nbTokens = i;
	}
	
	public void addToken(int nb) throws NegativeNumberException{
		if (nb <= 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		}
		this.nbTokens += nb;
		
	}
	
	public void subToken(int nb) throws NegativeNumberException{
		if (nb <= 0) {
			throw new NegativeNumberException("Le nombre de tokens ne peut pas être négatif");
		} else if (this.nbTokens >= nb) {
			this.nbTokens -= nb;
		} else {
			this.nbTokens = 0;	
		}
		
	}
	public void empty() {
		this.nbTokens = 0;
	}
	public boolean isFireable(int arcWeight) {
		return nbTokens >= arcWeight;
	}
	
	public boolean isEmpty() {
		return this.nbTokens == 0;
	}
	
	public int getNbToken() {
		//Pour tester
		return this.nbTokens;
	}
}
