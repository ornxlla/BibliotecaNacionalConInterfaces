package biblioteca;

public class NoSePuedePrestarElLibro extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoSePuedePrestarElLibro(String mensaje) {
		super(mensaje);
	}
}
