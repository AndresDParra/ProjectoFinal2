package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
public class CrudController {


    public TextField nombreUsuario;
    public TextField idUsuario;
    public PasswordField contraseniaUsuario;
    public TextField correoUsuario;
    public TextField telefonoUsuario;
    public TableView<Usuario> tablaUsuarios;
    public TableColumn<Usuario, String> colNombreUsuario;
    public TableColumn<Usuario, String> colIdUsuario;
    public TableColumn<Usuario, String> colCorreoUsuario;
    public TableColumn<Usuario, String> colTelefonoUsuario;
    public TextField nombreAdmin;
    public TextField idAdmin;
    public PasswordField contraseniaAdmin;
    public TableView<Administrador> tablaAdmins;
    public TableColumn<Administrador, String> colNombreAdmin;
    public TableColumn<Administrador, String> colIdAdmin;
    public TextField idCuenta;
    public TextField numeroCuenta;
    public TextField nombreBanco;
    public TextField saldoCuenta;
    public ComboBox<String> tipoCuenta;
    public TableView<CuentaBanco> tablaCuentas;
    public TableColumn<CuentaBanco, String> colIdCuenta;
    public TableColumn<CuentaBanco, String> colBancoCuenta;
    public TableColumn<CuentaBanco, String> colSaldoCuenta;
    public TableColumn<CuentaBanco, String> colTipoCuenta;
    public TableColumn<CuentaBanco, String> colNumeroCuenta;
    public TextField montoTransaccion;
    public TextField descripcionTransaccion;
    public DatePicker fechaTransaccion;
    public ComboBox<String> categoriaTransaccion;
    public ComboBox<String> tipoTransaccion;
    public TableView<Transaccion> tablaTransacciones;
    public TableColumn<Transaccion, String> colMontoTransaccion;
    public TableColumn<Transaccion, String> colFechaTransaccion;
    public TableColumn<Transaccion, String> colDescripcionTransaccion;
    public TableColumn<Transaccion, String> colCategoriaTransaccion;
    public TableColumn<Transaccion, String> colTipoTransaccion;
    public TextField nombreUsuarioCuenta;
    public TextField TeléfonoCuenta;


    public CrudController(TextField nombreUsuario, TextField idUsuario, PasswordField contraseniaUsuario, TextField correoUsuario, TextField telefonoUsuario, TableView<Usuario> tablaUsuarios, TableColumn<Usuario, String> colNombreUsuario, TableColumn<Usuario, String> colIdUsuario, TableColumn<Usuario, String> colCorreoUsuario, TableColumn<Usuario, String> colTelefonoUsuario, TextField nombreAdmin, TextField idAdmin, PasswordField contraseniaAdmin, TableView<Administrador> tablaAdmins, TableColumn<Administrador, String> colNombreAdmin, TableColumn<Administrador, String> colIdAdmin, TextField idCuenta, TextField numeroCuenta, TextField nombreBanco, TextField saldoCuenta, ComboBox<String> tipoCuenta, TableView<CuentaBanco> tablaCuentas, TableColumn<CuentaBanco, String> colIdCuenta, TableColumn<CuentaBanco, String> colBancoCuenta, TableColumn<CuentaBanco, String> colSaldoCuenta, TableColumn<CuentaBanco, String> colTipoCuenta, TableColumn<CuentaBanco, String> colNumeroCuenta, TextField montoTransaccion, TextField descripcionTransaccion, DatePicker fechaTransaccion, ComboBox<String> categoriaTransaccion, ComboBox<String> tipoTransaccion, TableView<Transaccion> tablaTransacciones, TableColumn<Transaccion, String> colMontoTransaccion, TableColumn<Transaccion, String> colFechaTransaccion, TableColumn<Transaccion, String> colDescripcionTransaccion, TableColumn<Transaccion, String> colCategoriaTransaccion, TableColumn<Transaccion, String> colTipoTransaccion, TextField nombreUsuarioCuenta, TextField teléfonoCuenta) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.correoUsuario = correoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.tablaUsuarios = tablaUsuarios;
        this.colNombreUsuario = colNombreUsuario;
        this.colIdUsuario = colIdUsuario;
        this.colCorreoUsuario = colCorreoUsuario;
        this.colTelefonoUsuario = colTelefonoUsuario;
        this.nombreAdmin = nombreAdmin;
        this.idAdmin = idAdmin;
        this.contraseniaAdmin = contraseniaAdmin;
        this.tablaAdmins = tablaAdmins;
        this.colNombreAdmin = colNombreAdmin;
        this.colIdAdmin = colIdAdmin;
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.nombreBanco = nombreBanco;
        this.saldoCuenta = saldoCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tablaCuentas = tablaCuentas;
        this.colIdCuenta = colIdCuenta;
        this.colBancoCuenta = colBancoCuenta;
        this.colSaldoCuenta = colSaldoCuenta;
        this.colTipoCuenta = colTipoCuenta;
        this.colNumeroCuenta = colNumeroCuenta;
        this.montoTransaccion = montoTransaccion;
        this.descripcionTransaccion = descripcionTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.categoriaTransaccion = categoriaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.tablaTransacciones = tablaTransacciones;
        this.colMontoTransaccion = colMontoTransaccion;
        this.colFechaTransaccion = colFechaTransaccion;
        this.colDescripcionTransaccion = colDescripcionTransaccion;
        this.colCategoriaTransaccion = colCategoriaTransaccion;
        this.colTipoTransaccion = colTipoTransaccion;
        this.nombreUsuarioCuenta = nombreUsuarioCuenta;
        TeléfonoCuenta = teléfonoCuenta;

    }
    public CrudController() {
    }

    public void initialize() {
        inicializarTablas();
    }


    public void agregarUsuario(ActionEvent actionEvent) {

        String nombre = nombreUsuario.getText();
        String id = idUsuario.getText();
        String contrasenia = contraseniaUsuario.getText();
        String correo = correoUsuario.getText();
        String telefono = telefonoUsuario.getText();
         var cuentabanco = GestorCuentaBanco.crearCuentaBanco(id, 1000,nombre, contrasenia, correo , id, telefono);
        tablaUsuarios.getItems().add(cuentabanco.getUsuario());

    }

    public void agregarAdmin(ActionEvent actionEvent) {
        String nombre = nombreAdmin.getText();
        String id = idAdmin.getText();
        String contrasenia = contraseniaAdmin.getText();
        Administrador admin = Administrador.builder().nombre(nombre).id(id).contrasenia(contrasenia).build();
        tablaAdmins.getItems().add(admin);
    }

    public void agregarCuenta(ActionEvent actionEvent) {

    String nombre = nombreUsuarioCuenta.getText();
    String id = idCuenta.getText();
    String numero = numeroCuenta.getText();
    String telefono = TeléfonoCuenta.getText();


    }

    public void agregarTransaccion(ActionEvent actionEvent) {

    String Fecha = String.valueOf(fechaTransaccion.getValue());
    String monto = montoTransaccion.getText();
    String descripcion = descripcionTransaccion.getText();
    String categoria = categoriaTransaccion.getValue();
    String tipo = tipoTransaccion.getValue();
    String id = idCuenta.getText();
    String idDestino = idCuenta.getText();
    String idOrigen = idCuenta.getText();

    }

    public void inicializarTablas(){
        colNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colIdUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colCorreoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        colTelefonoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));

        colNombreAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colIdAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));

        colIdCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCuenta()));
        colBancoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreBanco()));
        colSaldoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSaldo())));

        colMontoTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().monto())));
        colFechaTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf((cellData.getValue().fecha()))));
        colDescripcionTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        colCategoriaTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria().toString()));
        colTipoTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipo().toString()));
    }

}
