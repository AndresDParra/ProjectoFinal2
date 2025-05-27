package com.example.projectofinal2.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Presupuesto {

    private double presupuesto;
    private CuentaBanco cuentaBanco;

    public Presupuesto(double presupuesto, CuentaBanco cuentaBanco) {
        this.presupuesto = presupuesto;
        this.cuentaBanco = cuentaBanco;
    }

}

