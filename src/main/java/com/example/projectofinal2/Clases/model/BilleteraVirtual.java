package com.example.projectofinal2.Clases.model;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class BilleteraVirtual {

    private BilleteraVirtual instance;
    private String idBilletera, nombreBilletera;
    private double saldo;
    private static ArrayList<CuentaBanco> cuentasBanco;
    private static ArrayList<DTOTransaccion> DTOtransacciones;

    public BilleteraVirtual(String idBilletera, String nombreBilletera, double saldo) {
        this.idBilletera = idBilletera;
        this.nombreBilletera = nombreBilletera;
        this.saldo = saldo;
        cuentasBanco = new ArrayList<>();
        instance = getInstance();
        DTOtransacciones = new ArrayList<>();
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

    public static void setCuentasBanco(ArrayList<CuentaBanco> cuentasBanco) {
        BilleteraVirtual.cuentasBanco = cuentasBanco;
    }

    public static ArrayList<DTOTransaccion> getDTOtransacciones() {
        return DTOtransacciones;
    }

    public static void setDTOtransacciones(ArrayList<DTOTransaccion> DTOtransacciones) {
        BilleteraVirtual.DTOtransacciones = DTOtransacciones;
    }

    public static void saveDTOTransaccionesToFile(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(DTOtransacciones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDTOTransaccionesFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<DTOTransaccion>>() {}.getType();
            DTOtransacciones = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

