package com.example.projectofinal2.Clases.model;

import java.time.LocalDateTime;

public class Transaccion {
    private double monto;
    private LocalDateTime fecha;
    private String descripcion;
    private CategoriaTransaccion categoria;
    private TipoTransaccion tipo;

    public Transaccion(Builder builder) {
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
    public static class Builder {
        private double monto;
        private LocalDateTime fecha;
        private String descripcion;
        private CategoriaTransaccion categoria;
        private TipoTransaccion tipo;

        public Transaccion build() {
            return new Transaccion(this);
        }

        public Builder monto(double monto) {
            this.monto = monto;
            return this;
        }

        public Builder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
    }


    public Builder categoria(CategoriaTransaccion categoria) {
            this.categoria = categoria;
            return this;
    }

    public Builder tipo(TipoTransaccion tipo) {
            this.tipo = tipo;
            return this;
    }


    }
}
