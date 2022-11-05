//package src;

public class Arc{

	private int weight;
	protected Place place;

	public Arc(int w, Place p) throws NegativeNumberException{
		if (w < 0) {
			throw new NegativeNumberException("Le poids d'un arc ne peut pas être négatif");
		}
		this.weight = w;
		this.place = p;
	}

	public void modifyWeight(int newValue) throws NegativeNumberException{
		if (newValue < 0) {
			throw new NegativeNumberException("Le poids d'un arc ne peut pas être négatif");
		}
		this.weight= newValue;
	}

	public Place getPlace() {
		return this.place;
	}
	
	public int getWeight() {
		return this.weight;
	}

	public boolean isIncoming() {
		return false;
	}
}
