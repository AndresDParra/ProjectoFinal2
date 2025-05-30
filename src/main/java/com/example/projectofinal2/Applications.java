package com.example.projectofinal2;

import com.example.projectofinal2.model.AccesoUsuario;
import com.example.projectofinal2.model.Administrador;
import com.example.projectofinal2.model.BilleteraVirtual;
import com.example.projectofinal2.model.MongoDBFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Applications extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BilleteraVirtual.InitializeAll();
        MongoDBFacade.AccessMongoDBTransacciones();
        MongoDBFacade.AccessMongoDBUsuario();
        MongoDBFacade.AccessMongoDBCuentasBanco();
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("IniciarSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Welcome to the UQ Library!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}