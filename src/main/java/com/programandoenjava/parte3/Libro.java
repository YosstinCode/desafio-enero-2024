package com.programandoenjava.parte3;


import lombok.*;

import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Libro {

    private static long countId = 0;

    @Builder.Default
    private long id = obtainId();

    private String titulo;
    private String autor;
    private String anoPublicacion;

    @Builder.Default
    private boolean disponible = true;

    public static long obtainId(){
        return countId++;
    }

}
