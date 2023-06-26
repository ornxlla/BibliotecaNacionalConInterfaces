package biblioteca;

public class LibroMatematica extends Libro {

	public LibroMatematica(Integer codigo, String titulo, String autor) {
		super(codigo, titulo, autor);
		this.esFotocopiable = false;
	}

}
