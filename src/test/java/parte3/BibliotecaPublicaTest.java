package parte3;

import com.programandoenjava.parte3.BibliotecaPublica;
import com.programandoenjava.parte3.Libro;
import com.programandoenjava.parte3.LibroDigital;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaPublicaTest {

    private BibliotecaPublica bilioteca;

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

        bilioteca = BibliotecaPublica.builder()
                .libros(List.of(libro, libroDigital))
                .build();

    }

    @Test
    public void testBuscarLibroPorId() {

        Libro libro = bilioteca.buscarLibroPorId(1);

        assertNotNull(libro, "El libro no se encontro");
        assertEquals("El Quijote", libro.getTitulo(), "El titulo no es el esperado");
        assertEquals("Miguel de Cervantes", libro.getAutor(), "El autor no es el esperado");
        assertEquals("1605", libro.getAnoPublicacion(), "El año de publicacion no es el esperado");
        assertTrue(libro.isDisponible(), "El libro no esta disponible");

    }

    @Test
    public void buscarLibroDisponiblePorId(){

        Libro libroDisponible = bilioteca.buscarLibroDisponiblePorId(1);

        assertNotNull(libroDisponible, "El libro no se encontro");

    }

    @Test
    public void testPrestarLibro() {

        bilioteca.prestarLibro(1);

        Libro libro = bilioteca.buscarLibroPorId(1);

        assertFalse(libro.isDisponible(), "El libro esta disponible");

    }

    @Test
    public void testDevolverLibro() {

        bilioteca.prestarLibro(1);
        bilioteca.devolverLibro(1);

        Libro libro = bilioteca.buscarLibroPorId(1);

        assertTrue(libro.isDisponible(), "El libro no esta disponible");

    }
}
