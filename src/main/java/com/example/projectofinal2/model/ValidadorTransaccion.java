package com.example.projectofinal2.model;

public abstract class ValidadorTransaccion {
    protected ValidadorTransaccion siguiente;

    public void setSiguiente(ValidadorTransaccion siguiente) {
        this.siguiente = siguiente;
    }

    public boolean validar(DTOTransaccion transaccion) {
        if (manejar(transaccion)) {
            if (siguiente != null) {
                return siguiente.validar(transaccion);
            } else {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean manejar(DTOTransaccion transaccion);
}

