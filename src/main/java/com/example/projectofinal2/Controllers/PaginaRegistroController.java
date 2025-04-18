package com.example.projectofinal2.Controllers;

import com.example.projectofinal2.Clases.model.GSON;
import com.example.projectofinal2.Clases.model.GestorCuentaBanco;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaginaRegistroController {

    public TextField EspacioIDCuenta;
    public TextField EspacioPIN;
    public TextField EspacioNombreUsuario;
    public TextField EspacioNumeroTel;
    public Button ButtonGuardarRegistro;

    public PaginaRegistroController(TextField espacioIDCuenta, TextField espacioPIN, TextField espacioNombreUsuario, TextField espacioNumeroTel, Button buttonGuardarRegistro) {
        EspacioIDCuenta = espacioIDCuenta;
        EspacioPIN = espacioPIN;
        EspacioNombreUsuario = espacioNombreUsuario;
        EspacioNumeroTel = espacioNumeroTel;
        ButtonGuardarRegistro = buttonGuardarRegistro;
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

    public TextField getEspacioNumeroTel() {
        return EspacioNumeroTel;
    }

    public void setEspacioNumeroTel(TextField espacioNumeroTel) {
        EspacioNumeroTel = espacioNumeroTel;
    }

    public Button getButtonGuardarRegistro() {
        return ButtonGuardarRegistro;
    }

    public void setButtonGuardarRegistro(Button buttonGuardarRegistro) {
        ButtonGuardarRegistro = buttonGuardarRegistro;
    }

    public PaginaRegistroController() {
    }

    public void Guardar(ActionEvent actionEvent) {
        GestorCuentaBanco.crearCuentaBanco(EspacioNombreUsuario.getText(), EspacioIDCuenta.getText(), EspacioPIN.getText(), 1000);
        EspacioIDCuenta.clear();
        EspacioPIN.clear();
        EspacioNombreUsuario.clear();
        EspacioNumeroTel.clear();
        GSON.saveCuentaDeBancoToFile("/Users/andresdavidparra/Documents/Folder para cosas importantes/TrabajoMiercolesYulbrainer/carpetaJson/RegistroCuentaBanco.json");
    }
}
