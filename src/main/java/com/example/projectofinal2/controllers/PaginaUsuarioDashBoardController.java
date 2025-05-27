package com.example.projectofinal2.controllers;

import com.example.projectofinal2.Applications;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

@Getter
public class PaginaUsuarioDashBoardController {

    public Button ButtonBienvenida;
    public Button ButtonPerfil;
    public Button ButtomTransacciones;
    public Button ButtonPresupuesto;
    public Button ButtonCerrarSesion;
    public StackPane contenidoPrincipal;

    public PaginaUsuarioDashBoardController(Button buttonBienvenida, Button buttonPerfil, Button buttomTransacciones, Button buttonPresupuesto, Button buttonCerrarSesion, StackPane contenidoPrincipal) {
        ButtonBienvenida = buttonBienvenida;
        ButtonPerfil = buttonPerfil;
        ButtomTransacciones = buttomTransacciones;
        ButtonPresupuesto = buttonPresupuesto;
        ButtonCerrarSesion = buttonCerrarSesion;
        this.contenidoPrincipal = contenidoPrincipal;
    }

    public PaginaUsuarioDashBoardController() {
    }

    public void setButtonBienvenida(Button buttonBienvenida) {
        ButtonBienvenida = buttonBienvenida;
    }

    public void setButtonPerfil(Button buttonPerfil) {
        ButtonPerfil = buttonPerfil;
    }

    public void setButtomTransacciones(Button buttomTransacciones) {
        ButtomTransacciones = buttomTransacciones;
    }

    public void setButtonPresupuesto(Button buttonPresupuesto) {
        ButtonPresupuesto = buttonPresupuesto;
    }

    public void setButtonCerrarSesion(Button buttonCerrarSesion) {
        ButtonCerrarSesion = buttonCerrarSesion;
    }

    public void setContenidoPrincipal(StackPane contenidoPrincipal) {
        this.contenidoPrincipal = contenidoPrincipal;
    }

    public void mostrarBienvenida(ActionEvent actionEvent) {
    }

    public void mostrarPerfil(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioPerfil.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Welcome to Venequi");
        stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        stage.show();
    }

    public void mostrarTransacciones(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioTransacciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Transacciones");
        stage.setScene(new Scene(fxmlLoader.load(), 800, 750));
        stage.show();

        UsuarioTransaccionesController usuarioTransaccionesController = fxmlLoader.getController();
        usuarioTransaccionesController.initialize();
    }

    public void mostrarPresupuestos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioPresupuesto.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Transacciones");
        stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        stage.show();
    }

    public void cerrarSesion(ActionEvent actionEvent) {
    }
}