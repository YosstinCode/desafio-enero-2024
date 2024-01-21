package parte3;

import com.programandoenjava.parte3.LibroDigital;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroDigitalTest {

    private LibroDigital libroDigital;

    @BeforeEach
    public void setUp() {
        libroDigital = LibroDigital.builder()
                .titulo("El Quijote digital")
                .autor("Miguel de Cervantes")
                .anoPublicacion("1605")
                .url("https://www.gutenberg.org/files/2000/2000-h/2000-h.htm")
                .build();
    }

    @Test
    public void testLibroDigital() {
        assertNotNull(libroDigital, "El libro digital no se creo correctamente");
    }

    @Test
    public void testSettersLibroDigital() {
        libroDigital.setTitulo("Edit El Quijote digital");
        libroDigital.setAutor("Edit Miguel de Cervantes");
        libroDigital.setAnoPublicacion("Edit 1605");
        libroDigital.setUrl("Edit https://www.gutenberg.org/files/2000/2000-h/2000-h.htm");

        assertEquals("Edit El Quijote digital", libroDigital.getTitulo(), "El titulo no es el esperado");
        assertEquals("Edit Miguel de Cervantes", libroDigital.getAutor(), "El autor no es el esperado");
        assertEquals("Edit 1605", libroDigital.getAnoPublicacion(), "El año de publicacion no es el esperado");
        assertEquals("Edit https://www.gutenberg.org/files/2000/2000-h/2000-h.htm", libroDigital.getUrl(), "La url no es la esperada");
    }

    @Test
    public void testMetodoToString() {
        String libroDigitalToString = libroDigital.toString();

        assertTrue(libroDigitalToString.contains("El Quijote digital"), "El titulo no es el esperado");
        assertTrue(libroDigitalToString.contains("Miguel de Cervantes"), "El autor no es el esperado");
        assertTrue(libroDigitalToString.contains("1605"), "El año de publicacion no es el esperado");
        assertTrue(libroDigitalToString.contains("https://www.gutenberg.org/files/2000/2000-h/2000-h.htm"), "La url no es la esperada");
    }

}
