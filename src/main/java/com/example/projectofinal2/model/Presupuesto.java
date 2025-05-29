package com.example.projectofinal2.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presupuesto {
    private String nombre;
    private double presupuesto;
    private CuentaBanco cuentaBanco;

    public Presupuesto(double presupuesto, CuentaBanco cuentaBanco, String nombre) {
        this.presupuesto = presupuesto;
        this.cuentaBanco = cuentaBanco;
        this.nombre = nombre;
    }

}

