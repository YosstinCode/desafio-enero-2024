package com.programandoenjava.parte3;

public interface Biblioteca {

    /**
     * Este metodo se encarga de prestar un libro de la biblioteca.
     * @param idLibro id del libro a prestar
     * @Author: YosstinCode
     * @Version: 1.0
     */

    void prestarLibro(long idLibro);

    /**
     * Este metodo se encarga de devolver un libro a la biblioteca.
     * @param idLibro id del libro a devolver
     * @Author: YosstinCode
     * @Version: 1.0
     */
    void devolverLibro(long idLibro);
}
