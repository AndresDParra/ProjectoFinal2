package com.example.projectofinal2.model;

import lombok.Getter;

import java.util.ArrayList;


public class BilleteraVirtual {

    private static BilleteraVirtual instance;
    private static String idBilletera;
    private static String nombreBilletera;
    private static double Dolares;
    @Getter
    private static ArrayList<CuentaBanco> cuentasBanco;
    @Getter
    static ArrayList<DTOTransaccion> DTOtransacciones;
    @Getter
    private static ArrayList<Usuario> usuarios;

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double Dolares, ArrayList<Usuario> usuarios) {
        BilleteraVirtual.idBilletera = idBilletera;
        BilleteraVirtual.nombreBilletera = nombreBilletera;
        BilleteraVirtual.Dolares = Dolares;
        cuentasBanco = new ArrayList<>();
        DTOtransacciones = new ArrayList<>();
        BilleteraVirtual.instance = getInstance();
        BilleteraVirtual.usuarios = new ArrayList<Usuario>();
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

    public void setCuentaBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }
    public static BilleteraVirtual getInstance(){
        if (instance == null) {
            instance = new BilleteraVirtual("1", "Billetera", 0, new ArrayList<Usuario>());
        }
        return instance;
    }

    public static void setCuentasBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }

    public static void setDTOtransacciones(ArrayList<DTOTransaccion> DTOtransacciones) {
        BilleteraVirtual.DTOtransacciones = DTOtransacciones;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        BilleteraVirtual.usuarios = usuarios;
    }




    public static void InitializeAll(){
        Configurador configurador = Configurador.getInstance();
        configurador.inicializarBilletera();
        DTOtransacciones = new ArrayList<>();
        cuentasBanco = new ArrayList<>();

    }

}

