//package src;

public class EmptyArc extends IncomingArc{

	public EmptyArc(Place p) throws NegativeNumberException {
		super(0, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return true;
	}
	public boolean isZero() {
		return false;
	}
	
	public boolean isFireable() {
		return this.place.isFireable(1);
	}
	
	public void Fire() {
		if (this.isFireable()) {
		place.empty();
		}
	}
}
