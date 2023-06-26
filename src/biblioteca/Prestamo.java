package biblioteca;

import java.util.Objects;

public class Prestamo implements Comparable<Prestamo>{

	private Integer identificador;
	private String nombre;
	private String titulo;

	public Prestamo(Integer identificador, String nombre, String titulo) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.titulo = titulo;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}


	public String getTitulo() {
		return titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(identificador, other.identificador);
	}

	@Override
	public int compareTo(Prestamo o) {
		return this.identificador.compareTo(o.identificador);
	}
	
	
}
