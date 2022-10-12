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
		this.nbTokens = this.nbTokens - nb;
	}
	public void empty() {
		this.nbTokens = 0;
	}
	public boolean isFireable(int arcWeight) {
		return nbTokens >= arcWeight;
	}
}
