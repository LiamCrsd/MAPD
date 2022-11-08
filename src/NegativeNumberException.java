
public class NegativeNumberException extends Exception{
	/**
	 * Une classe pour lever l'exception en cas de nombre négatif en 
	 * argument d'une méthode qui n'en accepte pas
	 */
	private String string;

	public NegativeNumberException(String string) {
		this.string = string;
	}
}
