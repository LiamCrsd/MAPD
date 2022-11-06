import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PetriNetTest {

	@Test
	void testMutex() throws NegativeNumberException {
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
		//Arc aTemp = pn.CreateIncommingArc(1, P1,T1);
		//assert (pn.getNbArcs()==1 && p1t1.getWeight()==2);//CPT1
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
		//Petite autre serie de test pour verifier que tout marche
		pn.Fire(T2);
		assert (T1.isFireable() && T3.isFireable() && !T2.isFireable() && !T4.isFireable());
		pn.Fire(T3);
		assert (!T1.isFireable() && !T3.isFireable() && !T2.isFireable() && T4.isFireable());
		
		
	}
	
}