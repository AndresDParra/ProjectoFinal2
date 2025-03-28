package com.example.projectofinal2.Clases.model;

import java.time.LocalDateTime;

public class GestorTransaccion {

    public void crearTransaccion(double monto, LocalDateTime fecha, String descripcion, CategoriaTransaccion categoriaTransaccion, TipoTransaccion tipoTransaccion) {

       Transaccion transaccion = new Transaccion(fecha, monto, descripcion, categoriaTransaccion, tipoTransaccion);
        CuentaBanco.getTransacciones().add(transaccion);

    }
}
