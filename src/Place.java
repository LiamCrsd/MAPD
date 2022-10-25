//package src;

public class Place{
	private int nbTokens;
	
	public Place() {
		this.nbTokens = 0;
	}
	
	public Place(int i) {
		this.nbTokens = i;
	}
	
	public void addToken(int nb) {
		this.nbTokens += nb;
	}
	
	public void subToken(int nb) {
		if (nb <= 0) {
			//should throw an exception or something
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
