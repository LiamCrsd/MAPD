//package src;

public class ZeroArc extends IncomingArc{

	public ZeroArc(Place p) throws NegativeNumberException {
		super(0, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isZero() {
		return true;
	}
	
	public boolean isFireable() {
		return this.place.isEmpty();
	}
	
	public void fire() {
		if (this.isFireable()) {
			//y a pas de pass en java
			int i =1;
			i += i;
		}
	}
	
}
