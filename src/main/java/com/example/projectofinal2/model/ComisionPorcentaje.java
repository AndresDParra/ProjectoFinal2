package com.example.projectofinal2.model;

public class ComisionPorcentaje implements EstrategiaComision {
    public double calcularComision(double monto) {
        return monto * 0.05;
    }
}
