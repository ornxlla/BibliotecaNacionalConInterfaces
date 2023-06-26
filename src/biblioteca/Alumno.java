package biblioteca;

import java.util.Objects;
import java.util.TreeSet;

public class Alumno implements Comparable<Alumno> {

	private TreeSet<Libro> librosPrestados = new TreeSet<Libro>();
	private Integer dni;
	private String apellido;
	private String nombre;

	public Alumno(Integer dni, String apellido, String nombre) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	public TreeSet<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int compareTo(Alumno otro) {
		return this.dni.compareTo(otro.dni);
	}

	public void devolverLibro(Biblioteca biblioteca, Libro libro) {
		this.librosPrestados.remove(libro);
		biblioteca.agregarLibro(libro);
	}
	
	
}
