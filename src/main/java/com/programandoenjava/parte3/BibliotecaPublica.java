package com.programandoenjava.parte3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaPublica implements Biblioteca{

    private String nombre;
    private List<Libro> libros;

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }


    /**
     * El metodo se encarga de buscar un libro por su id.
     * @param idLibro id del libro a buscar
     * @return {@link Libro}
     * @Author: YosstinCode
     * @Version: 1.0
     */
    public Libro buscarLibroPorId(long idLibro) {
        return libros.stream()
                .filter(libro -> libro.getId() == idLibro)
                .findFirst()
                .orElse(null);
    }

    /**
     * El metodo se encarga de buscar un libro por su id y además que este disponible.
     * @param idLibro id del libro a buscar
     * @return {@link Libro}
     * @Author: YosstinCode
     * @Version: 1.0
     */
    public Libro buscarLibroDisponiblePorId(long idLibro) {
        return buscarLibroPorId(idLibro).isDisponible()? buscarLibroPorId(idLibro) : null;
    }


    public void prestarLibro(long idLibro) {
        Libro libro = buscarLibroPorId(idLibro);
        libro.setDisponible(false);
    }

    public void devolverLibro(long idLibro) {
        Libro libro = buscarLibroPorId(idLibro);
        libro.setDisponible(true);
    }


}
