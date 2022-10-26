//package src;

public class IncomingArc extends Arc{

	public IncomingArc(int w, Place p) {
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIncoming() {
		return true;
	}
	
	public boolean isFireable() {
		return this.place.isFireable(this.getWeight());
	}
	
	public boolean isZero() {
		return false;		
	}
	public boolean isEmpty() {
		return false;
	}
	public void Fire() throws NegativeNumberException {
		place.subToken(this.getWeight());
	}
}
