package com.example.projectofinal2.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.example.projectofinal2.model.BilleteraVirtual.DTOtransacciones;
import static com.example.projectofinal2.model.CuentaBanco.transacciones;

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

    public static void crearTransaccion(double monto, LocalDateTime fecha, String descripcion, CategoriaTransaccion categoriaTransaccion, TipoTransaccion tipoTransaccion) {
        Transaccion transaccion = new Transaccion(fecha, monto, descripcion, categoriaTransaccion, tipoTransaccion);
        CuentaBanco.getTransacciones().add(transaccion);

        DTOTransaccion dto = new DTOTransaccion(monto, fecha.toString(), descripcion, categoriaTransaccion.toString(), tipoTransaccion.toString());
        CuentaBanco.getDTOtransacciones().add(dto);

        notificarObservadores(dto);
    }



    public static void saveTransaccionesToFile(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(transacciones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEstrategia(EstrategiaComision estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double monto) {
        return estrategia.calcularComision(monto);
    }

    public static void loadTransaccionesFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<DTOTransaccion>>() {}.getType();
            transacciones = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveDTOTransaccionesToFile(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(DTOtransacciones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
