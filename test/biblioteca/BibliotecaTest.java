package biblioteca;

import static org.junit.Assert.*;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void queSePuedanAgregarLibrosALaBiblioteca() {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		
		assertTrue(biblio.agregarLibro(historia));
		
	}
	
	@Test
	public void queSePuedaImprimirUnLibro() {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		
		String resultado = biblio.imprimirLibro(historia);
		
		assertEquals("Historia Argentina", resultado);
		
	}
	
	@Test
	public void queNoSePuedaImprimirUnLibro() {
		Biblioteca biblio = new Biblioteca();
		Libro matematica = new LibroMatematica (2543, "Algebra", "Romina Diaz");
		
		String resultado = biblio.imprimirLibro(matematica);
		assertEquals("El libro no es fotocopiable", resultado);
	}
	
	@Test
	public void ordenarLibrosPorCodigo() {
		Biblioteca biblio = new Biblioteca();
		Libro geografia = new LibroGeografia (5432, "Meridianos y Paralelos", "Andrea Bonelli");
		Libro matematica = new LibroMatematica (2543, "Algebra", "Romina Diaz");
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		
		biblio.agregarLibro(historia);
		biblio.agregarLibro(matematica);
		biblio.agregarLibro(geografia);
		
		assertEquals(biblio.ordenarLibrosPorCodigo().first(), historia);
		assertEquals(biblio.ordenarLibrosPorCodigo().last(), geografia);
	
	}
	
	@Test
	public void queSePuedanPrestarLibrosAUnAlumno() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro matematica = new LibroMatematica (2543, "Algebra", "Romina Diaz");
		Libro geografia = new LibroGeografia (5432, "Meridianos y Paralelos", "Andrea Bonelli");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		
		assertTrue(biblio.agregarLibro(geografia));
		assertTrue(biblio.agregarLibro(matematica));
		biblio.prestarLibro(alumno, geografia);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = biblio.obtenerCantidadDeLibros();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = NoSePuedePrestarElLibro.class)
	public void queNoSePuedaPrestarLibrosAUnAlumnoPorqueSuperoSuMaximoDePrestamos() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		Libro matematica = new LibroMatematica (2543, "Algebra", "Romina Diaz");
		Libro geografia = new LibroGeografia (5432, "Meridianos y Paralelos", "Andrea Bonelli");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		
		biblio.agregarLibro(historia);
		biblio.agregarLibro(matematica);
		biblio.agregarLibro(geografia);
		
		biblio.prestarLibro(alumno, geografia);
		biblio.prestarLibro(alumno, historia);
		biblio.prestarLibro(alumno, matematica);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = alumno.getLibrosPrestados().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = NoSePuedePrestarElLibro.class)
	public void queNoSePuedaPrestarUnLibroPorqueNoEstaDisponible() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		Alumno alumnoDos = new Alumno(43254354, "Navarro", "Eliana");
		
		biblio.agregarLibro(historia);
		
		biblio.prestarLibro(alumno, historia);
		biblio.prestarLibro(alumnoDos, historia);
	}
	
	@Test
	public void queUnAlumnoDevuelvaUnLibroYSePuedaPrestarAOtro() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		Alumno alumnoDos = new Alumno(43254354, "Navarro", "Eliana");
		
		biblio.agregarLibro(historia);
		biblio.prestarLibro(alumno, historia);
		alumno.devolverLibro(biblio, historia);
		
		Integer valorEsperado = 0;
		Integer valorObtenido = alumno.getLibrosPrestados().size();
		assertEquals(valorEsperado, valorObtenido);
		
		Integer valorEsperadoDos = 1;
		Integer valorObtenidoDos = biblio.obtenerCantidadDeLibros();
		assertEquals(valorEsperadoDos, valorObtenidoDos);
		
		biblio.prestarLibro(alumnoDos, historia);
	}
	
	@Test
	public void queSeRegistrenPrestamosYSeOrdenenPorIdentificador() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		Libro geografia = new LibroGeografia (5432, "Meridianos y Paralelos", "Andrea Bonelli");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		
		biblio.agregarLibro(historia);
		biblio.agregarLibro(geografia);
		
		Prestamo prestamo = biblio.prestarLibro(alumno, historia);
		Prestamo prestamoDos = biblio.prestarLibro(alumno, geografia);
		
		Integer valorEsperado = 1;
		Integer valorEsperadoDos = 2;
		
		assertEquals(prestamo.getIdentificador(), valorEsperado);
		assertEquals(prestamoDos.getIdentificador(), valorEsperadoDos);
	}
	
	@Test
	public void queSeOrdenenLosPrestamosPorApellidoDelAlumno() throws NoSePuedePrestarElLibro {
		Biblioteca biblio = new Biblioteca();
		Libro historia = new LibroHistoria(1234,"Historia Argentina", "Rodrigo Peretti");
		Libro geografia = new LibroGeografia (5432, "Meridianos y Paralelos", "Andrea Bonelli");
		Alumno alumno = new Alumno(44353984, "Alonso Reyes", "Ornella");
		Alumno alumnoDos = new Alumno(43254354, "Navarro", "Eliana");
		biblio.agregarLibro(historia);
		biblio.agregarLibro(geografia);
		
		Prestamo prestamo = biblio.prestarLibro(alumno, historia);
		Prestamo prestamoDos = biblio.prestarLibro(alumnoDos, geografia);
		
		assertEquals(biblio.ordenarPrestamosPorNombreDelAlumno().first(), prestamoDos);
		assertEquals(biblio.ordenarPrestamosPorNombreDelAlumno().last(), prestamo);
		
	}
}
