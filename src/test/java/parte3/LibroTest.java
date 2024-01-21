package parte3;

import com.programandoenjava.parte3.Libro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    private static Libro libro;

    @BeforeAll
    public static void setUp() {
        libro = new Libro();
        libro.setTitulo("El señor de los anillos");
        libro.setAutor("J.R.R. Tolkien");
        libro.setAnoPublicacion("1954");

    }

    @Test
    public void createLibroConBuilderTest(){

        Libro libroBuilder = Libro.builder()
                .titulo("El señor de los anillos")
                .autor("J.R.R. Tolkien")
                .anoPublicacion("1954")
                .build();

        assertEquals(1, libroBuilder.getId(), "El id no es el esperado");
        assertEquals("El señor de los anillos", libroBuilder.getTitulo(), "El titulo no es el esperado");
        assertEquals("J.R.R. Tolkien", libroBuilder.getAutor(), "El autor no es el esperado");
        assertEquals("1954", libroBuilder.getAnoPublicacion(), "El año de publicacion no es el esperado");
        assertTrue(libroBuilder.isDisponible(), "El libro no esta disponible");
    }

    @Test
    public void metodosSettersTest(){

        libro.setTitulo("El señor de los anillos");
        libro.setAutor("J.R.R. Tolkien");
        libro.setAnoPublicacion("1954");
        libro.setDisponible(false);

        assertEquals(0, libro.getId(), "El id no es el esperado");
        assertEquals("El señor de los anillos", libro.getTitulo(), "El titulo no es el esperado");
        assertEquals("J.R.R. Tolkien", libro.getAutor(), "El autor no es el esperado");
        assertEquals("1954", libro.getAnoPublicacion(), "El año de publicacion no es el esperado");
        assertFalse(libro.isDisponible(), "El libro esta disponible");
    }

    @Test
    public void metodoToStringTest(){

        String libroToString = libro.toString();

        assertTrue(libroToString.contains("El señor de los anillos"), "El titulo no es el esperado");
        assertTrue(libroToString.contains("J.R.R. Tolkien"), "El autor no es el esperado");
        assertTrue(libroToString.contains("1954"), "El año de publicacion no es el esperado");
    }

}
