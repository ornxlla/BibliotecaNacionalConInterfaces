package biblioteca;

public class LibroHistoria extends Libro {

	public LibroHistoria(Integer codigo, String titulo, String autor) {
		super(codigo, titulo, autor);
		this.esFotocopiable = true;
	}

}
