package com.example.projectofinal2.Clases.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.example.projectofinal2.Clases.model.CuentaBanco.transacciones;

public class GestorTransaccion {

    public void crearTransaccion(double monto, LocalDateTime fecha, String descripcion, CategoriaTransaccion categoriaTransaccion, TipoTransaccion tipoTransaccion) {

        Transaccion transaccion = new Transaccion(fecha, monto, descripcion, categoriaTransaccion, tipoTransaccion);
        CuentaBanco.getTransacciones().add(transaccion);
        DTOTransaccion dtoTransaccion = new DTOTransaccion(monto, fecha.toString(), descripcion, categoriaTransaccion.toString(), tipoTransaccion.toString());
        CuentaBanco.getDTOtransacciones().add(dtoTransaccion);

    }

    public void saveTransaccionesToFile(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(transacciones, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTransaccionesFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<DTOTransaccion>>() {}.getType();
            transacciones = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
