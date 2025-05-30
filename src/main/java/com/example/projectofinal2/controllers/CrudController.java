package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    public TableColumn<CuentaBanco, String> ColumnUsuario;
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
    public  Usuario selectedUsuario;
    public Administrador selectedAdmin;
    public Transaccion selectedTransaccion;
    public CuentaBanco selectedCuentaBanco;
    public TextField NombreCuenta;
    public TextField IdUsuario;
    public TextField CorreoCuenta;
    public TextField TeléfonoCuenta;
    public TextField SaldoCuenta;
    public TextField ConstrasenaCuenta;
    public TextField IdCuentaOrigen;
    public TextField IdCuentaDestino;


    public CrudController() {
    }

    public void initialize() {
        inicializarTablas();
        listenerSeleccion();
    }


    public void agregarUsuario(ActionEvent actionEvent) {

        String nombre = nombreUsuario.getText();
        String id = idUsuario.getText();
        String correo = correoUsuario.getText();
        String telefono = telefonoUsuario.getText();
        Usuario usuario = new Usuario(nombre, id, correo, telefono);
        tablaUsuarios.getItems().add(usuario);

    }

    public void agregarAdmin(ActionEvent actionEvent) {
        String nombre = nombreAdmin.getText();
        String id = idAdmin.getText();
        String contrasenia = contraseniaAdmin.getText();
        Administrador admin = Administrador.builder().nombre(nombre).id(id).contrasenia(contrasenia).build();
        tablaAdmins.getItems().add(admin);
    }

    public void agregarCuenta(ActionEvent actionEvent) {

    String nombre = nombreUsuario.getText();
    String id = idCuenta.getText();
    String numero = numeroCuenta.getText();
    String telefono = TeléfonoCuenta.getText();
    String correo = CorreoCuenta.getText();
    String contrasenia = contraseniaUsuario.getText();
    double saldo = Double.parseDouble(saldoCuenta.getText());
    var cuentabanco = GestorCuentaBanco.crearCuentaBanco(id, saldo,nombre, contrasenia, correo , id, telefono);
    BilleteraVirtual.getCuentasBanco().add( cuentabanco);
    tablaCuentas.getItems().add(cuentabanco);


    }

    public void agregarTransaccion(ActionEvent actionEvent) {

    String Fecha = String.valueOf(fechaTransaccion.getValue());
    String monto = montoTransaccion.getText();
    String descripcion = descripcionTransaccion.getText();
    String categoria = categoriaTransaccion.getValue();
    String tipo = tipoTransaccion.getValue();
    String id = idCuenta.getText();
    String idDestino = IdCuentaDestino.getText();
    String idOrigen = IdCuentaOrigen.getText();
    LocalDateTime dateTime = LocalDate.parse(Fecha).atStartOfDay();
    CuentaBanco cuentaOrigen = GestorCuentaBanco.getCuentaBancoById(idOrigen);
    CuentaBanco cuentaDestino = GestorCuentaBanco.getCuentaBancoById(idDestino);
    Transaccion transaccion = new Transaccion(
            dateTime,
            Double.parseDouble(monto),
            descripcion,
            TipoTransaccion.valueOf(tipo),
            TipoCuenta.valueOf(categoria),
            cuentaOrigen,
            cuentaDestino
    );
    BilleteraVirtual.getTransacciones().add(transaccion);
    MongoDBFacade.insertTransaccion(transaccion);
    tablaTransacciones.getItems().add(transaccion);


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
        colCategoriaTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipoCuenta().toString()));
        colTipoTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipo().toString()));

        categoriaTransaccion.getItems().addAll(TipoCuenta.AHORROS.name(), TipoCuenta.CORRIENTE.name());TipoTransaccion.DEPOSITO.name();
        tipoTransaccion.getItems().addAll( TipoTransaccion.RETIRO.name(), TipoTransaccion.TRANSFERENCIA.name(), TipoTransaccion.DEPOSITO.name());
    }

    private void listenerSeleccion(){
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedUsuario = newValue;
            if (selectedUsuario != null) {
                nombreUsuario.setText(selectedUsuario.getNombre());
                idUsuario.setText(selectedUsuario.getId());
                correoUsuario.setText(selectedUsuario.getCorreo());
                telefonoUsuario.setText(selectedUsuario.getTelefono());
            }
        });

        tablaAdmins.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedAdmin = newValue;
            if (selectedAdmin != null) {
                nombreAdmin.setText(selectedAdmin.getNombre());
                idAdmin.setText(selectedAdmin.getId());
                contraseniaAdmin.setText(selectedAdmin.getContrasenia());
            }
        });

        tablaTransacciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedTransaccion = newValue;
            if (selectedTransaccion != null) {
                montoTransaccion.setText(String.valueOf(selectedTransaccion.monto()));
                descripcionTransaccion.setText(selectedTransaccion.descripcion());
                fechaTransaccion.setValue(selectedTransaccion.fecha().toLocalDate());
                categoriaTransaccion.setValue(selectedTransaccion.tipoCuenta().toString());
                tipoTransaccion.setValue(selectedTransaccion.tipo().toString());
            }
        });

        tablaCuentas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedCuentaBanco = newValue;
            if (selectedCuentaBanco != null) {
                idCuenta.setText(selectedCuentaBanco.getIdCuenta());
                nombreBanco.setText(selectedCuentaBanco.getNombreBanco());
                saldoCuenta.setText(String.valueOf(selectedCuentaBanco.getSaldo()));
            }
        });
    }

}
