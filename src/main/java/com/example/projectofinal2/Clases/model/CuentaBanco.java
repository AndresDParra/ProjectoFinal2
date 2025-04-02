package com.example.projectofinal2.Clases.model;

import java.util.ArrayList;

public class CuentaBanco {
    private String idCuenta, numeroCuenta, nombreBanco;
    private double saldo;
    static ArrayList<Transaccion> transacciones;
    private static ArrayList<DTOTransaccion> DTOtransacciones;

    public CuentaBanco(String idCuenta, String numeroCuenta, String nombreBanco, double saldo) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.nombreBanco = nombreBanco;
        this.saldo = saldo;
        transacciones = new ArrayList<>();
        DTOtransacciones = new ArrayList<>();
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        CuentaBanco.transacciones = transacciones;
    }

    public static ArrayList<DTOTransaccion> getDTOtransacciones() {
        return DTOtransacciones;
    }

    public static void setDTOtransacciones(ArrayList<DTOTransaccion> DTOtransacciones) {
        CuentaBanco.DTOtransacciones = DTOtransacciones;
    }
}
