package com.example.projectofinal2.Controllers;

import com.example.projectofinal2.Applications;
import com.example.projectofinal2.Clases.model.GSON;
import com.example.projectofinal2.Clases.model.GestorCuentaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PaginaRegistroController {

    public TextField EspacioIDCuenta;
    public TextField EspacioPIN;
    public TextField EspacioNombreUsuario;
    public TextField EspacioID;
    public Button ButtonGuardarRegistro;
    public TextField EspacioCorreo;
    public Button ButtonVolver;


    public PaginaRegistroController(TextField espacioIDCuenta, TextField espacioPIN, TextField espacioNombreUsuario, TextField espacioID, Button buttonGuardarRegistro, TextField espacioCorreo, Button buttonVolver) {
        EspacioIDCuenta = espacioIDCuenta;
        EspacioPIN = espacioPIN;
        EspacioNombreUsuario = espacioNombreUsuario;
        EspacioID = espacioID;
        ButtonGuardarRegistro = buttonGuardarRegistro;
        EspacioCorreo = espacioCorreo;
        ButtonVolver = buttonVolver;
    }

    public PaginaRegistroController() {}

    public TextField getEspacioIDCuenta() {
        return EspacioIDCuenta;
    }

    public void setEspacioIDCuenta(TextField espacioIDCuenta) {
        EspacioIDCuenta = espacioIDCuenta;
    }

    public TextField getEspacioPIN() {
        return EspacioPIN;
    }

    public void setEspacioPIN(TextField espacioPIN) {
        EspacioPIN = espacioPIN;
    }

    public TextField getEspacioNombreUsuario() {
        return EspacioNombreUsuario;
    }

    public void setEspacioNombreUsuario(TextField espacioNombreUsuario) {
        EspacioNombreUsuario = espacioNombreUsuario;
    }

    public TextField getEspacioID() {
        return EspacioID;
    }

    public void setEspacioID(TextField espacioID) {
        EspacioID = espacioID;
    }

    public Button getButtonGuardarRegistro() {
        return ButtonGuardarRegistro;
    }

    public void setButtonGuardarRegistro(Button buttonGuardarRegistro) {
        ButtonGuardarRegistro = buttonGuardarRegistro;
    }

    public TextField getEspacioCorreo() {
        return EspacioCorreo;
    }

    public void setEspacioCorreo(TextField espacioCorreo) {
        EspacioCorreo = espacioCorreo;
    }

    public Button getButtonVolver() {
        return ButtonVolver;
    }

    public void setButtonVolver(Button buttonVolver) {
        ButtonVolver = buttonVolver;
    }

    public void Guardar(ActionEvent actionEvent) {
        GestorCuentaBanco.crearCuentaBanco(EspacioID.getText(), 1000, EspacioPIN.getText(), EspacioNombreUsuario.getText(), EspacioIDCuenta.getText(), EspacioCorreo.getText(), EspacioIDCuenta.getText());
        EspacioIDCuenta.clear();
        EspacioID.clear();
        EspacioPIN.clear();
        EspacioNombreUsuario.clear();
        EspacioCorreo.clear();
        GSON.saveCuentaDeBancoToFile("C:\\Users\\kodai\\OneDrive\\DocumentoscarpetaJson\\RegistroCuentaBanco.json");
    }

    public void regresar(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("IniciarSesion.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600, 540);
        stage.setTitle("Welcome to Venequi");
        stage.setScene(scene);
        stage.show();

    }
}
