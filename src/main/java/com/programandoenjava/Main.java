package com.programandoenjava;

import com.programandoenjava.parte3.BibliotecaPublica;
import com.programandoenjava.parte3.Libro;
import com.programandoenjava.parte3.LibroDigital;
import com.programandoenjava.parte3.Persona;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // creando un libro y un libro digital

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

        // creando una biblioteca

        BibliotecaPublica biblioteca = BibliotecaPublica.builder()
                .nombre("Biblioteca Nacional")
                .libros(List.of(libro, libroDigital))
                .build();

        // creando personas

        Persona persona = Persona.builder()
                .nombre("Juan")
                .edad("30")
                .biblioteca(biblioteca)
                .build();

        Persona persona2 = Persona.builder()
                .nombre("Pedro")
                .edad("30")
                .biblioteca(biblioteca)
                .build();

        // tomando prestado un libro

        System.out.println("-- Tomando prestado un libro... --");
        persona.tomarPrestadoLibros(libro);

        System.out.println("-- Libros disponibles en la biblioteca: --");
        biblioteca.getLibros().forEach(System.out::println);

        // devolviendo el libro

        System.out.println("-- Devolviendo el libro... --");
        persona.devolverLibros(libro);

        System.out.println("-- Libros disponibles en la biblioteca: --");
        biblioteca.getLibros().forEach(System.out::println);

        // tomando prestado un libro digital

        System.out.println("-- Tomando prestado un libro digital... --");
        persona.tomarPrestadoLibros(libroDigital);

        System.out.println("-- Libros disponibles en la biblioteca: --");
        biblioteca.getLibros().forEach(System.out::println);

        // devolviendo el libro digital

        System.out.println("-- Devolviendo el libro digital... --");
        persona.devolverLibros(libroDigital);

        System.out.println("-- Libros disponibles en la biblioteca: --");
        biblioteca.getLibros().forEach(System.out::println);

    }


}