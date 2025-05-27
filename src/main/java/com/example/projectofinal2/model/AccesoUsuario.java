package com.example.projectofinal2.model;

import lombok.Getter;
import lombok.Setter;

public class AccesoUsuario {

    private static CuentaBanco cuenta_banco;
    private static AccesoUsuario instance;

    private AccesoUsuario(CuentaBanco cuenta_banco) {
        AccesoUsuario.cuenta_banco = cuenta_banco;

    }

    public static AccesoUsuario getInstance() {
        if (instance == null) {
            instance = new  AccesoUsuario(new CuentaBanco("1244", 1234, new Usuario("Julian", "123345656", "@2301", "3125439088"), "0987"));
        }
        return instance;
    }

    public static CuentaBanco getCuenta_banco() {
        return cuenta_banco;
    }

    public static void setCuenta_banco(CuentaBanco cuenta_banco) {
        AccesoUsuario.cuenta_banco = cuenta_banco;
    }

    public static void setInstance(AccesoUsuario instance) {
        AccesoUsuario.instance = instance;
    }
}
