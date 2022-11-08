
public class app {
	/**
	 * A class to display a Petri Network
	 */
	public static void test1() {
		/**
		 * creates a Petri Networks and tests the display
		 * @param no parameters
		 * @return void
		 */
		PetriNet test = new PetriNet();
		Place p1 = test.CreatePlace(4);
		Place p2 = test.CreatePlace(0);
		Transition t = test.CreateTransition();
		Arc a1 = test.CreateIncommingArc(1, p1, t);
		Arc a2 = test.CreateOutgoingArc(1,t,p2);
		System.out.println("-----Affichage RdP simple-----");
		test.affichage();
		System.out.println("-----Affichage apr�s 1 tir-----");
		test.Fire(t);
		test.affichage();
		System.out.println("-----4 tirs et affichage-----");
		test.Fire(t);
		test.Fire(t);
		test.Fire(t);
		test.Fire(t);
		test.affichage();
		System.out.println("-----Creation d'une place avec -1 jetons-----");
		Place p3 = test.CreatePlace(-1);
		test.affichage();
		System.out.println("-----Creation d'une place avec 1 arc entrant et 1 arc sortant-----");
		p3 = test.CreatePlace(0);
		Transition t2 = test.CreateTransition();
		Arc a3 = test.CreateIncommingArc(1, p2, t2);
		Arc a4 = test.CreateOutgoingArc(1, t2, p3);
		test.affichage();
		System.out.println("-----Creation d'un arc de poids -1 -----");
		Arc a5 = test.CreateIncommingArc(-1, p3);
		test.affichage();
		test.DelPlace(p2);
		test.affichage();
	}
	
	public static void main(String[] args) throws NegativeNumberException{
		test1();
			
	}
}
