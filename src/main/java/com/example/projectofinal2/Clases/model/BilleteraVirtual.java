package com.example.projectofinal2.Clases.model;

import java.util.ArrayList;


public class BilleteraVirtual {

    private static BilleteraVirtual instance;
    private static String idBilletera;
    private static String nombreBilletera;
    private static double Dolares;
    private static ArrayList<CuentaBanco> cuentasBanco;
    static ArrayList<DTOTransaccion> DTOtransacciones;

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double Dolares) {
        BilleteraVirtual.idBilletera = idBilletera;
        BilleteraVirtual.nombreBilletera = nombreBilletera;
        BilleteraVirtual.Dolares = Dolares;
        cuentasBanco = new ArrayList<>();
        instance = getInstance();
        DTOtransacciones = new ArrayList<>();
        BilleteraVirtual.instance = getInstance();
    }

    public String getIdBilletera() {
        return idBilletera;
    }

    public static void setIdBilletera(String idBilletera) {
        BilleteraVirtual.idBilletera = idBilletera;
    }

    public String getNombreBilletera() {
        return nombreBilletera;
    }

    public static void setNombreBilletera(String nombreBilletera) {
        BilleteraVirtual.nombreBilletera = nombreBilletera;
    }

    public double getDolares() {
        return Dolares;
    }

    public static void setDolares(double dolares) {
        BilleteraVirtual.Dolares = dolares;
    }

    public static ArrayList<CuentaBanco> getCuentasBanco() {
        return cuentasBanco;
    }

    public void setCuentaBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }
    public static BilleteraVirtual getInstance(){
        if (instance == null) {
            instance = new BilleteraVirtual("1", "Billetera", 0);
        }
        return instance;
    }

    public static void setCuentasBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }

    public static ArrayList<DTOTransaccion> getDTOtransacciones() {
        return DTOtransacciones;
    }

    public static void setDTOtransacciones(ArrayList<DTOTransaccion> DTOtransacciones) {
        BilleteraVirtual.DTOtransacciones = DTOtransacciones;
    }




    public static void InitializeAll(){
        Configurador configurador = Configurador.getInstance();
        configurador.inicializarBilletera();
        DTOtransacciones = new ArrayList<>();
        cuentasBanco = new ArrayList<>();

    }

}

