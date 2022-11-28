package org.pneditor.petrinet.adapters.Liam;


import org.pneditor.petrinet.AbstractPlace;

public class PlaceAdapter extends AbstractPlace{

	public Place adaptee;
	
	public PlaceAdapter(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	public PlaceAdapter(String label, Place place) {
		super(label); 
		this.adaptee = place;
	}
	
	@Override
	public void addToken(){
		try {
			adaptee.addToken(1);
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeToken() {
		try {
			adaptee.subToken(1);
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getTokens() {
		// TODO Auto-generated method stub
		return adaptee.getNbToken();
		}

	@Override
	public void setTokens(int tokens) {
		// TODO Auto-generated method stub
		adaptee.empty();
		try {
			adaptee.addToken(tokens);
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isPlace() {
		return true;
	}
	
	public Place getPlace() {
		return this.adaptee;
	}
	

}
