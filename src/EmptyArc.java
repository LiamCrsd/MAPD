//package src;

public class EmptyArc extends IncomingArc{

	public EmptyArc(Place p) {
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
		return true;
	}
	
	public void Fire() {
		place.empty();
	}
}
