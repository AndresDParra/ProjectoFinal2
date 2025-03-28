package com.example.projectofinal2.Clases.model;

import java.util.ArrayList;

import static java.util.Currency.getInstance;

public class BilleteraVirtual {

    private BilleteraVirtual instance;
    private String idBilletera, nombreBilletera;
    private double saldo;
    private static ArrayList<CuentaBanco> cuentasBanco;

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double saldo) {
        this.idBilletera = idBilletera;
        this.nombreBilletera = nombreBilletera;
        this.saldo = saldo;
        cuentasBanco = new ArrayList<>();
        instance = getInstance();
    }

    public String getIdBilletera() {
        return idBilletera;
    }

    public void setIdBilletera(String idBilletera) {
        this.idBilletera = idBilletera;
    }

    public String getNombreBilletera() {
        return nombreBilletera;
    }

    public void setNombreBilletera(String nombreBilletera) {
        this.nombreBilletera = nombreBilletera;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static ArrayList<CuentaBanco> getCuentasBanco() {
        return cuentasBanco;
    }

    public void setCuentaBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }
    public BilleteraVirtual getInstance(){
        if (instance == null) {
            instance = new BilleteraVirtual("1", "Billetera", 0);
        }
        return instance;
    }
}
