package com.example.projectofinal2.Clases.model;

import java.time.LocalDateTime;

public class Transaccion {
    private final double monto;
    private final LocalDateTime fecha;
    private final String descripcion;
    private final CategoriaTransaccion categoria;
    private final TipoTransaccion tipo;

    public Transaccion(LocalDateTime fecha, double monto, String descripcion, CategoriaTransaccion categoria,TipoTransaccion tipo) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaTransaccion getCategoria() {
        return categoria;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }
}
