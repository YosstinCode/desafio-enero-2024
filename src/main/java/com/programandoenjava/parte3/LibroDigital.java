package com.programandoenjava.parte3;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class LibroDigital extends Libro{
    private static long countId = 0;

    @Builder.Default
    private long id = obtainId();
    private String url;

    public static long obtainId(){
        return countId++;
    }

}
