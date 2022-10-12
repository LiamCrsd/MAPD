//package src;

public class EmptyArc extends IncomingArc{

	public EmptyArc(int w, Place p) {
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return true;
	}
	public boolean isZero() {
		return false;
	}
	
	public boolean isFirable() {
		return true;
	}
	
	public void Fire() {
		place.empty();
	}
}
