package com.example.projectofinal2.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@Builder
public class Administrador {
    @NotNull
    private String nombre;
    @NotNull
    private String id;
    @NotNull
    private String contrasenia;


}
