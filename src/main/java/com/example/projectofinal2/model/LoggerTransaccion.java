package com.example.projectofinal2.model;

public class LoggerTransaccion implements ObservadorTransaccion {
    public void actualizar(DTOTransaccion transaccion) {
        System.out.println("LOG: Se realizó una transacción: " + transaccion);
    }
}