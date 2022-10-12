
public class app {

	public static void main(String[] args){
		Place p1 = new Place(2);
		Place p2 = new Place(3);
		Place p3 = new Place(0);
		Place p4 = new Place();
		Place p5 = new Place();
		Transition t = new Transition();
		IncomingArc a1 = new IncomingArc(3,p1);
		IncomingArc a2 = new ZeroArc(p2);
		IncomingArc a3 = new EmptyArc(p3);
		OutgoingArc a4 = new OutgoingArc(2,p4);
		OutgoingArc a5 = new OutgoingArc(1,p5);
		t.addArcIn(a1);
		t.addArcIn(a2);
		t.addArcIn(a3);
		t.addArcOut(a4);
		t.addArcOut(a5);
		System.out.println("Etape 1 : " + t.isFireable());
		p3.addToken(2);
		p2.subToken(3);
		p1.addToken(2);
		System.out.println("Etape 2 : " + t.isFireable());
		t.fire();
		System.out.println("Etape 3 : " + p1.getNbToken() + p2.getNbToken() + p3.getNbToken() + p4.getNbToken() + p5.getNbToken());
	}
}
