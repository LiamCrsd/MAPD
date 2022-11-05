
public class app {

	public static void main(String[] args) throws NegativeNumberException{
		PetriNet test = new PetriNet();
		Place p1 = test.CreatePlace(4);
		Place p2 = test.CreatePlace(0);
		Transition t = test.CreateTransition();
		Arc a1 = test.CreateIncommingArc(1, p1, t);
		Arc a2 = test.CreateOutgoingArc(1,p2,t);
		test.affichage();
		test.Fire(t);
		test.affichage();
		test.Fire(t);
		test.Fire(t);
		test.Fire(t);
		test.Fire(t);
		test.affichage();
	}
}
