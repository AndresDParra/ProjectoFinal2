package com.example.projectofinal2.model;

public class ValidadorSaldo extends ValidadorTransaccion {
   protected boolean manejar(DTOTransaccion transaccion) {
        double monto = transaccion.monto();
        return transaccion.cuentaOrigen().getSaldo() >= monto;

   }

}
