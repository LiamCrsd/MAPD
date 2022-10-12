//package src;

public class OutgoingArc extends Arc{

	public OutgoingArc(int w, Place p) {
		super(w, p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIncoming() {
		return false;
	}
	
	public void Fire() {
		place.addToken(this.getWeight());
	}
}
