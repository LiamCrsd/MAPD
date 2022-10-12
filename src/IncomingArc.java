package src;

public class IncomingArc extends Arc{

	public IncomingArc(int w, Place p) {
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIncoming() {
		return true;
	}
	
	public boolean isFirable() {
		return this.place.isFireable();
	}
	
	public boolean isZero() {
		
	}
	public boolean isEmpty() {
		
	}
	public void Fire() {
		place.subToken(this.getWeight());
	}
}
