package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.GSON;
import com.example.projectofinal2.model.GestorCuentaBanco;
import com.example.projectofinal2.model.MongoDBFacade;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaginaRegistroController {

    public TextField EspacioIDCuenta;
    public TextField EspacioPIN;
    public TextField EspacioNombreUsuario;
    public TextField EspacioID;
    public Button ButtonGuardarRegistro;
    public TextField EspacioCorreo;


    public PaginaRegistroController(TextField espacioIDCuenta, TextField espacioPIN, TextField espacioNombreUsuario, TextField espacioNumeroTel, Button buttonGuardarRegistro, TextField espacioID, TextField espacioCorreo) {
        EspacioIDCuenta = espacioIDCuenta;
        EspacioPIN = espacioPIN;
        EspacioNombreUsuario = espacioNombreUsuario;
        ButtonGuardarRegistro = buttonGuardarRegistro;
        EspacioID = espacioID;
        EspacioCorreo = espacioCorreo;
    }

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

    public Button getButtonGuardarRegistro() {
        return ButtonGuardarRegistro;
    }

    public void setButtonGuardarRegistro(Button buttonGuardarRegistro) {
        ButtonGuardarRegistro = buttonGuardarRegistro;
    }

    public TextField getEspacioID() {
        return EspacioID;
    }

    public void setEspacioID(TextField espacioID) {
        EspacioID = espacioID;
    }

    public TextField getEspacioCorreo() {
        return EspacioCorreo;
    }

    public void setEspacioCorreo(TextField espacioCorreo) {
        EspacioCorreo = espacioCorreo;
    }

    public PaginaRegistroController() {
    }

    public void Guardar(ActionEvent actionEvent) {
        var cuentaBanco = GestorCuentaBanco.crearCuentaBanco(EspacioID.getText(), 1000, EspacioPIN.getText(), EspacioNombreUsuario.getText(), EspacioIDCuenta.getText(), EspacioCorreo.getText(), EspacioIDCuenta.getText());
        EspacioIDCuenta.clear();
        EspacioID.clear();
        EspacioPIN.clear();
        EspacioNombreUsuario.clear();
        EspacioCorreo.clear();
        GSON.saveCuentaDeBancoToFile("/Users/andresdavidparra/Documents/Folder para cosas importantes/TrabajoMiercolesYulbrainer/carpetaJson/RegistroCuentaBanco.json");


    }

}
