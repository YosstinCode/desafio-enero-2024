package com.programandoenjava.parte2;

import java.util.ArrayList;

/**
 * Implementa en Java que tenga un método
 * para agregar números enteros y otro método para calcular
 * la suma de todos los elementos en la lista.
 */
public class Parte2<T extends Number> {

    /**
     * Lista de números.
     */
    private final ArrayList<T> numeros = new ArrayList<>();

    /**
     * Este metodo se encarga de sumar los números de la lista {@link Parte2#numeros}.
     * Los cuales son agregados por el método {@link Parte2#agregarNumero(Number) agregarNumero}
     * Por ejemplo.
     *
     * <ul>
     *     <li>Si la lista es [1, 2, 3, 4, 5], la suma será 15.</li>
     *     <li>Si la lista es [1.5, 2.5, 3.5, 4.5, 5.5], la suma será 17.5.</li>
     * </ul>
     *
     *
     * @return La suma de los números como un {@link Double}
     * @Author: YosstinCode
     * @Version: 1.0
     */
    public double sumarNumeros() {

        return numeros.stream().mapToDouble(Number::doubleValue).sum();
    }

    /**
     * Este metodo Agrega un número a la lista {@link Parte2#numeros}.
     *
     * @param numero El número entero que se va a agregar.
     * @Author: YosstinCode
     * @Version: 1.0
     */
    public void agregarNumero(T numero) {

        numeros.add(numero);
    }
}
