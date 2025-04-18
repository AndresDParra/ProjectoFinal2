package com.example.projectofinal2;

import com.example.projectofinal2.Clases.model.BilleteraVirtual;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Applications extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BilleteraVirtual.InitializeAll();
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("IniciarSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);
        stage.setTitle("Welcome to the UQ Library!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}