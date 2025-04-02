package com.example.projectofinal2.Clases.model;

public class DTOTransaccion {
    private final double monto;
    private final String fecha;
    private final String descripcion;
    private final String categoria;
    private final String tipo;

    public DTOTransaccion(double monto, String fecha, String descripcion, String categoria, String tipo) {
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }
}
