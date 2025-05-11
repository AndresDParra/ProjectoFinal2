package com.example.projectofinal2.Clases.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;

public class xGSON {
    public static void loadDTOTransaccionesFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<DTOTransaccion>>() {}.getType();
            BilleteraVirtual.DTOtransacciones = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCuentaDeBancoFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<CuentaBanco>>() {}.getType();
            BilleteraVirtual.setCuentasBanco(gson.fromJson(reader, listType));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveCuentaDeBancoToFile(String filePath) {
        try {
            // Create parent directories if they don't exist
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            // Then write the file
            Gson gson = new Gson();
            try (FileWriter writer = new FileWriter(file)) {
                ArrayList<CuentaBanco> cuentas = BilleteraVirtual.getCuentasBanco();
                gson.toJson(cuentas, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
