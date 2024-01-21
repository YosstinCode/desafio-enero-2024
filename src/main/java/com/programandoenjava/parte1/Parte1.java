package com.programandoenjava.parte1;

/**
 *
 */

public class Parte1 {

    /**
     * Este método se encarga de invertir las palabras de una cadena sin considerar ningún otro símbolo. Por ejemplo:
     *
     *<ul>
     *     <li>Si la cadena de entrada es "hola mundo", la cadena de salida será "aloh odnum".</li>
     *     <li>Si la cadena de entrada es "¡hola mundo!", la cadena de salida será "¡aloh odnum!".</li>
     *</ul>
     *
     * @param cadena cadena de entrada
     * @return cadena invertida sin considerar ningún otro símbolo o cadena vacía si la cadena de entrada es nula o vacía
     *
     * @Author: YosstinCode
     * @Version: 1.0
     *
     */
    public String invertirPalabras(final String cadena) {

        if(cadena == null || cadena.isBlank()) return "";

        StringBuilder stringInverse = new StringBuilder();

        int positionForInsertedLetter = 0;

        for (char letter : cadena.toCharArray()) {;

            if(!Character.isLetter(letter)) {
                stringInverse.append(letter);
                positionForInsertedLetter = stringInverse.lastIndexOf(Character.toString(letter)) + 1;
                continue;
            }

            stringInverse.insert(positionForInsertedLetter, letter);

        }

        return stringInverse.toString();
    }
}
