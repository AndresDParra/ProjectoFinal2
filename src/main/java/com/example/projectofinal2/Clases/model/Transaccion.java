package com.example.projectofinal2.Clases.model;

import java.time.LocalDateTime;

public class Transaccion {
    private double monto;
    private LocalDateTime fecha;
    private String descripcion;
    private CategoriaTransaccion categoria;
    private TipoTransaccion tipo;

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

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaTransaccion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTransaccion categoria) {
        this.categoria = categoria;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }
}
