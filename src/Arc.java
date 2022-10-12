//package src;

public class Arc{
	
	private int weight;
	protected Place place;
	
	public Arc(int w, Place p) {
		this.weight = w;
		this.place = p;
	}
	
	public void modifyWeight(int newValue) {
		this.weight= newValue;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public boolean isIncoming() {
		return false;
	}
}
