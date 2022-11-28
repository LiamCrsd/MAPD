package org.pneditor.petrinet.adapters.Liam;
public class NegativeNumberException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Une classe pour lever l'exception en cas de nombre négatif en 
	 * argument d'une méthode qui n'en accepte pas
	 */
	private String string;

	public NegativeNumberException(String string) {
		this.string = string;
	}
}
