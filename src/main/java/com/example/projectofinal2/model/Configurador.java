package com.example.projectofinal2.model;

import java.util.ArrayList;

public class Configurador {
    // Singleton instance of Configurador
    private static Configurador instance;

    // Private constructor for singleton pattern
    private Configurador() {
        // Private constructor
    }

    // Get singleton instance of Configurador
    public static Configurador getInstance() {
        if (instance == null) {
            instance = new Configurador();
        }
        return instance;
    }

    // Get the BilleteraVirtual singleton
    public BilleteraVirtual getBilleteraVirtual() {
        return BilleteraVirtual.getInstance();
    }

    // Initialize with custom values
    public void inicializarBilletera() {
        BilleteraVirtual.setIdBilletera("12345");
        BilleteraVirtual.setNombreBilletera("Venequi");
        BilleteraVirtual.setDolares(Integer.MAX_VALUE);
        BilleteraVirtual.setUsuarios(new ArrayList<Usuario>());
        BilleteraVirtual.setCuentasBanco(new ArrayList<CuentaBanco>());
        BilleteraVirtual.setTransacciones(new ArrayList<Transaccion>());
    }

    // Reset to default values
    public void resetearBilletera() {
        BilleteraVirtual.InitializeAll();
    }
}
