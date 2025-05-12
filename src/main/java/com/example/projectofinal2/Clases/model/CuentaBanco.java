package com.example.projectofinal2.Clases.model;

import java.util.ArrayList;

public class CuentaBanco {
    private String idCuenta;
    private String nombreBanco;
    private double saldo;
    private static Usuario usuario;
    private String contrasena;
    static ArrayList<Transaccion> transacciones;
    private static ArrayList<DTOTransaccion> DTOtransacciones;

    public CuentaBanco(String idCuenta, double saldo, Usuario usuario, String contrasena) {
        this.idCuenta = idCuenta;
        this.nombreBanco = "Venequi";
        this.saldo = saldo;
        transacciones = new ArrayList<>();
        DTOtransacciones = new ArrayList<>();
        CuentaBanco.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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
    public Usuario getUsuario() {
        return usuario;
    }
    public static void setUsuario(Usuario usuario) {
        CuentaBanco.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
