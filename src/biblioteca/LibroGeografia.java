package biblioteca;

public class LibroGeografia extends Libro {

	public LibroGeografia(Integer codigo, String titulo, String autor) {
		super(codigo, titulo, autor);
		this.esFotocopiable = true;
	}

}
