package com.example.projectofinal2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class BilleteraVirtual {

    private static BilleteraVirtual instance;
    private static String idBilletera;
    private static String nombreBilletera;
    private static double Dolares;
    private static ArrayList<CuentaBanco> cuentasBanco = new ArrayList<>();
    static ArrayList<DTOTransaccion> DTOtransacciones;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double Dolares, ArrayList<Usuario> usuarios) {
        BilleteraVirtual.idBilletera = idBilletera;
        BilleteraVirtual.nombreBilletera = nombreBilletera;
        BilleteraVirtual.Dolares = Dolares;
        cuentasBanco = new ArrayList<>();
        DTOtransacciones = new ArrayList<>();
        BilleteraVirtual.instance = getInstance();
        BilleteraVirtual.usuarios = new ArrayList<Usuario>();
    }

    public static void setInstance(BilleteraVirtual instance) {
        BilleteraVirtual.instance = instance;
    }

    public static String getIdBilletera() {
        return idBilletera;
    }

    public static void setIdBilletera(String idBilletera) {
        BilleteraVirtual.idBilletera = idBilletera;
    }

    public static String getNombreBilletera() {
        return nombreBilletera;
    }

    public static void setNombreBilletera(String nombreBilletera) {
        BilleteraVirtual.nombreBilletera = nombreBilletera;
    }

    public static double getDolares() {
        return Dolares;
    }

    public static void setDolares(double dolares) {
        Dolares = dolares;
    }

    public static ArrayList<CuentaBanco> getCuentasBanco() {
        return cuentasBanco;
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

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        BilleteraVirtual.usuarios = usuarios;
    }

    public static BilleteraVirtual getInstance(){
        if (instance == null) {
            instance = new BilleteraVirtual("1", "Billetera", 0, new ArrayList<Usuario>());
        }
        return instance;
    }

    public CuentaBanco buscarCuenta(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de cuenta no puede ser nulo o vacío");
        }

        if (cuentasBanco != null) {
            for (CuentaBanco cuenta : cuentasBanco) {
                if (cuenta != null && id.equals(cuenta.getIdCuenta())) {
                    return cuenta;
                }
            }
        }
        return null;
    }
    public static void InitializeAll(){
        Configurador configurador = Configurador.getInstance();
        configurador.inicializarBilletera();
        DTOtransacciones = new ArrayList<>();
        cuentasBanco = new ArrayList<>();

    }

}

