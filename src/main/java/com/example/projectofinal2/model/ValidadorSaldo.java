package com.example.projectofinal2.model;

public class ValidadorSaldo extends ValidadorTransaccion {
   protected boolean manejar(DTOTransaccion transaccion) {
        /*double monto = transaccion.monto();
        return cuenta.getSaldo() >= monto;
        */
        return false;
    }

}
