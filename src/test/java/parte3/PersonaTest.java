package parte3;

import com.programandoenjava.parte3.BibliotecaPublica;
import com.programandoenjava.parte3.Libro;
import com.programandoenjava.parte3.LibroDigital;
import com.programandoenjava.parte3.Persona;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PersonaTest {

    private Persona persona;
    private BibliotecaPublica biblioteca;
    private List<Libro> libros;


    @BeforeEach
    public void setup() {

        Libro libro = Libro.builder()
                .titulo("El Quijote")
                .autor("Miguel de Cervantes")
                .anoPublicacion("1605")
                .build();

        LibroDigital libroDigital = LibroDigital.builder()
                .titulo("El Quijote digital")
                .autor("Miguel de Cervantes")
                .anoPublicacion("1605")
                .url("https://www.gutenberg.org/files/2000/2000-h/2000-h.htm")
                .build();

        libros = List.of(libro, libroDigital);

        biblioteca = BibliotecaPublica.builder()
                .nombre("Biblioteca Nacional")
                .libros(libros)
                .build();

        persona = new Persona(biblioteca);
    }

    @Test
    public void testPersona() {
        assertNotNull(persona, "La persona no se creo correctamente");
    }

    @Test
    public void testSettersPersona() {
        persona.setNombre("Juan");
        persona.setEdad("30");

        assertEquals("Juan", persona.getNombre(), "El nombre no es el esperado");
        assertEquals("30", persona.getEdad(), "La edad no es la esperada");
    }

    @Test
    public void testTomarPrestadoLibros() {
        persona.tomarPrestadoLibros(libros.get(0));

        assertNull(biblioteca.buscarLibroDisponiblePorId(libros.get(0).getId()), "El libro no se presto correctamente");

    }

    @Test
    public void testDevolverLibros() {
        persona.tomarPrestadoLibros(libros.get(0));
        persona.devolverLibros(libros.get(0));

        assertNotNull(biblioteca.buscarLibroDisponiblePorId(libros.get(0).getId()), "El libro no se devolvio correctamente");

    }


}
