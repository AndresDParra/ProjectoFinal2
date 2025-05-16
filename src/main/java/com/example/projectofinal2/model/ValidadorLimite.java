package com.example.projectofinal2.model;

public class ValidadorLimite extends ValidadorTransaccion {
    protected boolean manejar(DTOTransaccion transaccion) {
        return transaccion.monto() <= 1000;
    }
}