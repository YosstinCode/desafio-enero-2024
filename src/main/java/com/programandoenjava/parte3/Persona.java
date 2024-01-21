package com.programandoenjava.parte3;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Persona{

    private static long countId = 0;

    @Builder.Default
    private long id = obtainId();

    private String nombre;
    private String edad;
    private Biblioteca biblioteca;

    public Persona(Biblioteca biblioteca) {
        super();
        this.biblioteca = biblioteca;
    }

    public static long obtainId(){
        return countId++;
    }

    /**
     * El método se encarga de tomar prestado un libro de la biblioteca.
     * @param libro libro a tomar prestado
     * @Author: YosstinCode
     * @Version: 1.0
     */

    public void tomarPrestadoLibros(Libro libro){
        biblioteca.prestarLibro(libro.getId());
    }

    /**
     * El método se encarga de devolver un libro a la biblioteca.
     * @param libro libro a devolver
     * @Author: YosstinCode
     * @Version: 1.0
     */

    public void devolverLibros(Libro libro){
        biblioteca.devolverLibro(libro.getId());
    }
}
