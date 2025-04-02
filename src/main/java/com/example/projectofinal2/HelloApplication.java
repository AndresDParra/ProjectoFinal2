package com.example.projectofinal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.projectofinal2.Clases.model.BilleteraVirtual.saveDTOTransaccionesToFile;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        saveDTOTransaccionesToFile("/Users/andresdavidparra/Documents/Folder para cosas importantes/TrabajoMiercolesYulbrainer/carpetaJson/transacciones.json");
    }

    public static void main(String[] args) {
        launch();
    }
}