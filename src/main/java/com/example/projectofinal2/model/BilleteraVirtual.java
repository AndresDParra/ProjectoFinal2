package com.example.projectofinal2.model;

import java.util.ArrayList;
import java.util.LinkedList;


public class BilleteraVirtual {

    private static BilleteraVirtual instance;
    private static String idBilletera;
    private static String nombreBilletera;
    private static double Dolares;
    private static ArrayList<CuentaBanco> cuentasBanco = new ArrayList<>();
    static ArrayList<Transaccion> transacciones;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Presupuesto> presupuestos = new ArrayList<>();

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double Dolares, ArrayList<Usuario> usuarios) {
        BilleteraVirtual.idBilletera = idBilletera;
        BilleteraVirtual.nombreBilletera = nombreBilletera;
        BilleteraVirtual.Dolares = Dolares;
        cuentasBanco = new ArrayList<>();
        transacciones = new ArrayList<>();
        BilleteraVirtual.usuarios = new ArrayList<Usuario>();
        BilleteraVirtual.presupuestos = new ArrayList<Presupuesto>();
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

    public static ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public static void setTransacciones(ArrayList<Transaccion> transacciones) {
        BilleteraVirtual.transacciones = transacciones;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        BilleteraVirtual.usuarios = usuarios;
    }

    public static ArrayList<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public static void setPresupuestos(ArrayList<Presupuesto> presupuestos) {
        BilleteraVirtual.presupuestos = presupuestos;
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
        transacciones = new ArrayList<>();
        cuentasBanco = new ArrayList<>();

    }
    public LinkedList<Presupuesto> usuarioPresupuestos(Usuario usuario) {
        LinkedList<Presupuesto> presupuestos = new LinkedList<>();
        for (Presupuesto presupuesto : presupuestos) {
            presupuestos.add(presupuesto);
        }
        return presupuestos;
    }

}

