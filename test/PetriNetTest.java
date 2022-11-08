import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PetriNetTest {

	@Test
	void testMutex() throws NegativeNumberException {
		// Test r�f�r� a la grille de test section 7-2
		System.out.println("\nTest r�f�r� a la grille de test section 7-2\n");

		// Test de cr�ation d'�l�ment, d'un r�seau de petri et de la navigabilit�

		System.out.println("\nTest de cr�ation d'�l�ment, d'un r�seau de petri et de la navigabilit� \n");
		PetriNet pn = new PetriNet();
		assert (pn != null); //CR1
		Place P1 = pn.CreatePlace(0);
		assert (pn.getNbPlaces() == 1);//CP1
		Place P2 = pn.CreatePlace(1);
		assert (pn.getNbPlaces() == 2);//CP2
		Transition T1 = pn.CreateTransition();
		assert (pn.getNbTransitions()==1);//CT1
		Arc p1t1 = pn.CreateIncommingArc(1, P1, T1);
		assert (pn.getNbArcs()==1 && p1t1.getWeight()==1);//CPT1
		Arc aTemp = pn.CreateIncommingArc(1, P1,T1);
		aTemp.modifyWeight(2);
		assert (pn.getNbArcs()==1 && p1t1.getWeight()==2);//CPT1
		p1t1.modifyWeight(1);//reset a 1
		Arc t1p1 = pn.CreateOutgoingArc(1, T1, P2);
		assert (pn.getNbArcs()==2 && t1p1.getWeight()==1);//CTP1
		Transition T2 = pn.CreateTransition();
		assert (pn.getNbTransitions()==2);//CT2
		Arc p2t2 = pn.CreateIncommingArc(1,P2,T2);
		assert (pn.getNbArcs()==3 && p2t2.getWeight()==1);//CPT2
		Arc t2p1 = pn.CreateOutgoingArc(1,T2, P1);
		assert (pn.getNbArcs()==4 && t2p1.getWeight()==1);//CTP2
		Place P4 = pn.CreatePlace();
		assert (pn.getNbPlaces() == 3);//CP4
		Place P5 = pn.CreatePlace(1);
		assert (pn.getNbPlaces() == 4);//CP5
		Transition T3 = pn.CreateTransition();
		assert (pn.getNbTransitions() == 3);//CT3
		Arc p5t3 = pn.CreateIncommingArc(1, P5,T3);
		assert (pn.getNbArcs()==5 && p5t3.getWeight()==1);//CPT3
		Arc t3p4 = pn.CreateOutgoingArc(1, T3, P4);
		assert (pn.getNbArcs()==6 && t3p4.getWeight()==1);//CTP3
		Transition T4 = pn.CreateTransition();
		assert (pn.getNbTransitions()==4);//CT4
		Arc p4t4 = pn.CreateIncommingArc(1, P4, T4);
		assert (pn.getNbArcs()==7 && p4t4.getWeight()==1);//CPT4
		Arc t4p5 = pn.CreateOutgoingArc(1, T4, P5);
		assert (pn.getNbArcs()==8 && t4p5.getWeight()==1);//CTP3
		Place P3 = pn.CreatePlace(-2);
		assert (P3 == null && pn.getNbPlaces()==4);//CP5
		P3 = pn.CreatePlace();
		assert (pn.getNbPlaces()==5);//CP5
		Arc p3t1 = pn.CreateIncommingArc(-1, P3, T1);
		assert (p3t1 == null && pn.getNbArcs()==8);//CPT5
		p3t1 = pn.CreateIncommingArc(1, P3, T1);
		assert (pn.getNbArcs()==9 && p3t1.getWeight()==1);//CPT5
		Arc p3t3 = pn.CreateIncommingArc(1, P3, T3);
		assert (pn.getNbArcs()==10 && p3t3.getWeight()==1);//CPT6
		Arc t2p3 = pn.CreateOutgoingArc(1, T2, P3);
		assert (pn.getNbArcs()==11 && t2p3.getWeight()==1);//CTP5
		Arc t4p3 = pn.CreateOutgoingArc(1, T4, P3);
		assert (pn.getNbArcs()==12 && t4p3.getWeight()==1);//CTP6
		assert (pn.getNbArcs()==12 && pn.getNbPlaces()==5 && pn.getNbTransitions()==4);
		pn.affichage();

		//Test de l'activation du r�seau de Petri avec transitions a entr� simple et multiples

		System.out.println("\nTest de l'activation du r�seau de Petri avec transitions a entr� simple et multiples\n");
		pn.Fire(T2);
		assert (T1.isFireable() && T3.isFireable() && !T2.isFireable() && !T4.isFireable());
		pn.Fire(T3);
		assert (!T1.isFireable() && !T3.isFireable() && !T2.isFireable() && T4.isFireable());

		//Test de d�struction d'�l�ment du r�seau de Petri

		System.out.println("\nTest de d�struction d'�l�ment du r�seau de Petri\n");
		pn.DelPlace(P3);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==8 && pn.getNbTransitions() == 4);
		pn.DelPlace(P3);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==8 && pn.getNbTransitions() == 4);
		pn.DelTransition(T1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==6 && pn.getNbTransitions() == 3);
		pn.DelTransition(T1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==6 && pn.getNbTransitions() == 3);
		pn.DelArc(t2p1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==5 && pn.getNbTransitions() == 3);
		pn.DelArc(t2p1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==5 && pn.getNbTransitions() == 3);
	}

	@Test
	void testArcComplexe() throws NegativeNumberException {
		// Test identique a ceux r�f�r� a la grille de test section 7-2 mais avec des arc complexe
		System.out.println("\nTest r�f�r� a la grille de test section 7-2  mais avec des arc complexe\n");

		// Test de cr�ation d'�l�ment, d'un r�seau de petri et de la navigabilit�

		System.out.println("\nTest de cr�ation d'�l�ment, d'un r�seau de petri et de la navigabilit� \n");
		PetriNet pn = new PetriNet();
		assert (pn != null); //CR1
		Place P1 = pn.CreatePlace(0);
		assert (pn.getNbPlaces() == 1);//CP1
		Place P2 = pn.CreatePlace(1);
		assert (pn.getNbPlaces() == 2);//CP2
		Transition T1 = pn.CreateTransition();
		assert (pn.getNbTransitions()==1);//CT1
		Arc p1t1 = pn.CreateEmptyArc(P1, T1);
		assert (pn.getNbArcs()==1);//CPT1
		Arc aTemp = pn.CreateEmptyArc(P1,T1);
		assert (pn.getNbArcs()==1);//CPT1
		Arc t1p1 = pn.CreateOutgoingArc(1, T1, P2);
		assert (pn.getNbArcs()==2);//CTP1
		Transition T2 = pn.CreateTransition();
		assert (pn.getNbTransitions()==2);//CT2
		Arc p2t2 = pn.CreateEmptyArc(P2,T2);
		assert (pn.getNbArcs()==3);//CPT2
		Arc t2p1 = pn.CreateOutgoingArc(1,T2, P1);
		assert (pn.getNbArcs()==4);//CTP2
		Place P4 = pn.CreatePlace();
		assert (pn.getNbPlaces() == 3);//CP4
		Place P5 = pn.CreatePlace(1);
		assert (pn.getNbPlaces() == 4);//CP5
		Transition T3 = pn.CreateTransition();
		assert (pn.getNbTransitions() == 3);//CT3
		Arc p5t3 = pn.CreateEmptyArc(P5,T3);
		assert (pn.getNbArcs()==5);//CPT3
		Arc t3p4 = pn.CreateOutgoingArc(1, T3, P4);
		assert (pn.getNbArcs()==6);//CTP3
		Transition T4 = pn.CreateTransition();
		assert (pn.getNbTransitions()==4);//CT4
		Arc p4t4 = pn.CreateZeroArc(P4, T4);
		assert (pn.getNbArcs()==7);//CPT4
		Arc t4p5 = pn.CreateOutgoingArc(1, T4, P5);
		assert (pn.getNbArcs()==8);//CTP3
		Place P3 = pn.CreatePlace(-2);
		assert (P3 == null && pn.getNbPlaces()==4);//CP5
		P3 = pn.CreatePlace();
		assert (pn.getNbPlaces()==5);//CP5
		Arc p3t1 = pn.CreateEmptyArc(P3, T1);
		assert (pn.getNbArcs()==9);//CPT5
		Arc p3t3 = pn.CreateEmptyArc(P3, T3);
		assert (pn.getNbArcs()==10);//CPT6
		Arc t2p3 = pn.CreateOutgoingArc(1, T2, P3);
		assert (pn.getNbArcs()==11);//CTP5
		Arc t4p3 = pn.CreateOutgoingArc(1, T4, P3);
		assert (pn.getNbArcs()==12);//CTP6
		assert (pn.getNbArcs()==12 && pn.getNbPlaces()==5 && pn.getNbTransitions()==4);
		pn.affichage();

		//Test de l'activation du r�seau de Petri avec transitions a entr� simple et multiples

		System.out.println("\nTest de l'activation du r�seau de Petri avec transitions a entr� simple et multiples\n");
		pn.Fire(T2);
		assert (T1.isFireable() && T3.isFireable() && !T2.isFireable() && T4.isFireable());
		pn.Fire(T3);
		assert (!T1.isFireable() && !T3.isFireable() && !T2.isFireable() && !T4.isFireable());

		//Test de d�struction d'�l�ment du r�seau de Petri

		System.out.println("\nTest de d�struction d'�l�ment du r�seau de Petri\n");
		pn.DelPlace(P3);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==8 && pn.getNbTransitions() == 4);
		pn.DelPlace(P3);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==8 && pn.getNbTransitions() == 4);
		pn.DelTransition(T1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==6 && pn.getNbTransitions() == 3);
		pn.DelTransition(T1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==6 && pn.getNbTransitions() == 3);
		pn.DelArc(t2p1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==5 && pn.getNbTransitions() == 3);
		pn.DelArc(t2p1);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==5 && pn.getNbTransitions() == 3);
		pn.DelArc(p4t4);
		assert(pn.getNbPlaces()==4 && pn.getNbArcs()==4 && pn.getNbTransitions() == 3);
	}

	@Test
	void test73() throws NegativeNumberException {
		// Test référé a la grille de test section 7-3
		System.out.println("Test référé a la grille de test section 7-3\n");

		// Tests avec une seule place
		System.out.println("Tests avec une seule place\n");

		PetriNet pn = new PetriNet();
		Transition T = pn.CreateTransition();
		pn.Fire(T);
		assert (pn.getNbTransitions() == 1);//RI
		Place P = pn.CreatePlace();
		Arc A = pn.CreateIncommingArc(1,P,T);
		pn.Fire(T);
		assert (P.getNbToken() == 0);//RD0
		P.addToken(2);
		pn.Fire(T);
		assert (P.getNbToken() == 1);//RD1
		P.addToken(4);
		A.modifyWeight(3);
		pn.Fire(T);
		assert (P.getNbToken() == 2);//RD2
		P.subToken(2);
		pn.Fire(T);
		assert (!T.isFireable() && P.getNbToken() == 0);//RD3
		pn.DelArc(A);
		A = pn.CreateOutgoingArc(1,T,P);
		pn.Fire(T);
		assert (P.getNbToken()==1);//RG0
		P.subToken(1);
		A.modifyWeight(4);
		pn.Fire(T);
		assert (P.getNbToken()==4);//RG1
		P.subToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==7);//RG2

		// Tests avec un arc entrant et sortant
		System.out.println("Tests avec un arc entrant et sortant 7-3\n");

		P.subToken(7);
		Place P2 = pn.CreatePlace(2);
		pn.DelArc(A);
		A = pn.CreateIncommingArc(1,P,T);
		Arc A2 = pn.CreateOutgoingArc(1,T,P2);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==2);//RM0
		P.addToken(2);
		P2.subToken(2);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==1);//RM1
		pn.Fire(T);
		A.modifyWeight(3);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==2);//RM2
		A.modifyWeight(1);
		A2.modifyWeight(3);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==2);//RM3
		A.modifyWeight(3);
		A2.modifyWeight(5);
		P.addToken(2);
		P2.subToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==2 && P2.getNbToken()==1);//RM4
		A2.modifyWeight(1);
		P.addToken(2);
		P2.subToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==1);//RM7
		A.modifyWeight(1);
		A2.modifyWeight(5);
		P.addToken(1);
		P2.subToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==5);//RM8

		// Tests à entrées et sorties multiples
		System.out.println("Tests à entrées et sorties multiples\n");
		pn.DelArc(A2);
		pn.DelArc(A);
		pn.DelPlace(P2);
		pn.DelPlace(P);
		P = pn.CreatePlace();
		P2 = pn.CreatePlace();
		A = pn.CreateIncommingArc(1, P, T);
		A2 = pn.CreateIncommingArc(1, P2, T);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==0);//RDM1
		P.addToken(2);
		pn.Fire(T);
		assert (P.getNbToken()==2 && P2.getNbToken()==0);//RDM2
		P2.addToken(2);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==1);//RDM3
		pn.DelArc(A2);
		pn.DelArc(A);
		P.subToken(1);
		P2.subToken(1);
		A = pn.CreateOutgoingArc(1,T, P);
		A2 = pn.CreateOutgoingArc(1,T, P2);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==1);//RGM0
		P.addToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==3 && P2.getNbToken()==2);//RGM1
		Place P3 = pn.CreatePlace();
		Place P4 = pn.CreatePlace();
		P.subToken(3);
		P2.subToken(2);
		Arc A3 = pn.CreateIncommingArc(1, P3, T);
		Arc A4 = pn.CreateIncommingArc(1, P4, T);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==0 && P3.getNbToken()==0 && P4.getNbToken()==0);//RMM0
		P3.addToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==0 && P3.getNbToken()==1 && P4.getNbToken()==0);//RMM1
		P4.addToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==1 && P3.getNbToken()==0 && P4.getNbToken()==0);//RMM2
		P3.addToken(1);
		P4.addToken(1);
		P.subToken(1);
		pn.Fire(T);
		assert (P.getNbToken()==1 && P2.getNbToken()==2 && P3.getNbToken()==0 && P4.getNbToken()==0);//RMM3
		P.subToken(1);
		P2.subToken(2);
		P3.addToken(1);
		P4.addToken(1);
		A3.modifyWeight(4);
		A4.modifyWeight(2);
		pn.Fire(T);
		assert (P.getNbToken()==0 && P2.getNbToken()==0 && P3.getNbToken()==1 && P4.getNbToken()==1);//RMM4
	
	
	
	}


}
