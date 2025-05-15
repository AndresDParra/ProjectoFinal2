package com.example.projectofinal2.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CrudController {

    public TextField nombreUsuario;
    public TextField idUsuario;
    public PasswordField contraseniaUsuario;
    public TextField correoUsuario;
    public TextField telefonoUsuario;
    public TableView<String> tablaUsuarios;
    public TableColumn<String, String> colNombreUsuario;
    public TableColumn<String, String> colIdUsuario;
    public TableColumn<String, String> colCorreoUsuario;
    public TableColumn<String,String> colTelefonoUsuario;
    public TextField nombreAdmin;
    public TextField idAdmin;
    public PasswordField contraseniaAdmin;
    public TableView<String> tablaAdmins;
    public TableColumn<String, String> colNombreAdmin;
    public TableColumn<String, String> colIdAdmin;
    public TextField idCuenta;
    public TextField numeroCuenta;
    public TextField nombreBanco;
    public TextField saldoCuenta;
    public ComboBox<String> tipoCuenta;
    public TableView<String> tablaCuentas;
    public TableColumn<String, String> colIdCuenta;
    public TableColumn<String, String> colNumeroCuenta;
    public TableColumn<String, String> colBancoCuenta;
    public TableColumn<String, String> colSaldoCuenta;
    public TableColumn<String, String> colTipoCuenta;
    public TextField montoTransaccion;
    public TextField descripcionTransaccion;
    public DatePicker fechaTransaccion;
    public ComboBox<String> categoriaTransaccion;
    public ComboBox<String> tipoTransaccion;
    public TableView<String> tablaTransacciones;
    public TableColumn<String, String> colMontoTransaccion;
    public TableColumn<String, String> colFechaTransaccion;
    public TableColumn<String, String> colDescripcionTransaccion;
    public TableColumn<String, String> colCategoriaTransaccion;
    public TableColumn<String, String> colTipoTransaccion;

    public void agregarUsuario(ActionEvent actionEvent) {
    }

    public void agregarAdmin(ActionEvent actionEvent) {
    }

    public void agregarCuenta(ActionEvent actionEvent) {
    }

    public void agregarTransaccion(ActionEvent actionEvent) {
    }

}
