package com.example.projectofinal2.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestorTransaccion {

    private static final ArrayList<ObservadorTransaccion> observadores = new ArrayList<>();

    private EstrategiaComision estrategia;


    public static void agregarObservador(ObservadorTransaccion obs) {
        observadores.add(obs);
    }

    private static void notificarObservadores(DTOTransaccion dto) {
        for (ObservadorTransaccion obs : observadores) {
            obs.actualizar(dto);
        }
    }

    public static void crearTransaccion(double monto, LocalDateTime fecha, String descripcion, CategoriaTransaccion categoriaTransaccion, TipoTransaccion tipoTransaccion, TipoCuenta tipoCuenta, CuentaBanco cuentaOrigen, CuentaBanco cuentaDestino) {
        Transaccion transaccion = new Transaccion(fecha, monto, descripcion, tipoTransaccion, tipoCuenta, cuentaOrigen, cuentaDestino);
        CuentaBanco.getTransacciones().add(transaccion);

    }





    public void setEstrategia(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double monto) {
        return estrategia.calcularComision(monto);
    }



}
