package biblioteca;

import java.util.Objects;

public class Libro implements Fotocopiable, Comparable<Libro>{
	
	protected Integer codigo;
	protected String titulo;
	protected String autor;
	protected Boolean esFotocopiable;


	public Libro(Integer codigo, String titulo, String autor) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Boolean getEsFotocopiable() {
		return esFotocopiable;
	}

	public void setEsFotocopiable(Boolean esFotocopiable) {
		this.esFotocopiable = esFotocopiable;
	}

	@Override
	public String esFotocopiable(Libro libro) {
		if(libro.esFotocopiable == true) {
			return libro.titulo;
		}
		return "El libro no es fotocopiable";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public int compareTo(Libro otro) {
		return this.codigo.compareTo(otro.codigo);
		
	}
	
	
	
}
