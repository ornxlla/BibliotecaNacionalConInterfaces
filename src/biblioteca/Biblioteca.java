package biblioteca;

import java.util.TreeSet;

public class Biblioteca  {
	private TreeSet <Libro> libros = new TreeSet <Libro>();
	private TreeSet <Prestamo> prestamos = new TreeSet<Prestamo>();
	private Integer contadorPrestamo = 1;
	
	public TreeSet<Libro> ordenarLibrosPorCodigo() {
		return libros;
	}

	public Integer obtenerCantidadDeLibros() {
		return this.libros.size();
	}
	
	
	public Boolean agregarLibro(Libro libro) {
		if(!this.libros.contains(libro)) {
			this.libros.add(libro);
			return true;
		}
		return false;
	}

	public Prestamo prestarLibro(Alumno alumno, Libro libro) throws NoSePuedePrestarElLibro {
		if(alumno.getLibrosPrestados().size() < 2 && !alumno.getLibrosPrestados().contains(libro) && this.libros.contains(libro)) {
			Prestamo prestamo = new Prestamo(this.contadorPrestamo, alumno.getNombre(), libro.getTitulo());
			this.contadorPrestamo++;
			this.prestamos.add(prestamo);
			alumno.getLibrosPrestados().add(libro);
			this.libros.remove(libro);
			return prestamo;
		}
		throw new NoSePuedePrestarElLibro("Por algun requisito, el libro no puede ser prestado");
	}

	public String imprimirLibro(Libro libro) {
		return libro.esFotocopiable(libro);
	}

	public TreeSet<Prestamo> ordenarPrestamosPorNombreDelAlumno(){
		TreeSet<Prestamo> prestamoPorNombre = new TreeSet<Prestamo>(new PorNombreComparator());
		prestamoPorNombre.addAll(prestamos);
		return prestamoPorNombre;
	}
}
