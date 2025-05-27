package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter @Setter
public class UsuarioTransaccionesController {
    @FXML private ListView<Transaccion> transaccionesListView;
    @FXML private Button ButtonAgregarTransaccion;
    private Transaccion transaccionSeleccionada;


    public UsuarioTransaccionesController() {
    }

    public void initialize() {
        configurarListView();
        cargarTransacciones();
        listenerSeleccionTransaccion();
        configurarListenerTransacciones();
    }

    private void configurarListView() {
        transaccionesListView.setCellFactory(lv -> new ListCell<Transaccion>() {
            @Override
            protected void updateItem(Transaccion t, boolean empty) {
                super.updateItem(t, empty);
                if (empty || t == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(String.format("%s - %s: $%,.2f - %s",
                            t.fecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            t.tipo(),
                            t.monto(),
                            t.descripcion()));
                }
            }
        });
    }

    private void cargarTransacciones() {
        if (AccesoUsuario.getCuenta_banco() != null) {
            Transaccion transaccion = new Transaccion(
                    LocalDateTime.now(),
                    0.0,
                    "Transacción de prueba",
                    CategoriaTransaccion.ALIMENTOS,
                    TipoTransaccion.DEPOSITO,
                    AccesoUsuario.getCuenta_banco(),
                    new CuentaBanco("2344", 1234, new Usuario("Julian", "123345656", "@2301", "3125439088"), "0987")
            );
            AccesoUsuario.getCuenta_banco().getTransacciones().add(transaccion);
            ObservableList<Transaccion> lista = AccesoUsuario.getCuenta_banco().getTransacciones().stream()
                    .collect(FXCollections::observableArrayList, ObservableList::add, ObservableList::addAll);
            transaccionesListView.setItems(
                    lista);
        }
    }

    private void configurarListenerTransacciones() {
        transaccionesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            transaccionSeleccionada = newValue;
        });
    }

    private void listenerSeleccionTransaccion() {
        transaccionesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    transaccionSeleccionada = newValue;

                }
        );
    }

    public Optional<Transaccion> crearTransaccionDialogo() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Nueva Transacción");
        alert.setHeaderText("Complete los datos de la transacción");

        // Campos del formulario
        TextField montoField = new TextField();
        montoField.setPromptText("Monto (ej: 150.50)");

        TextField descripcionField = new TextField();
        descripcionField.setPromptText("Descripción");

        ComboBox<CategoriaTransaccion> categoriaCombo = new ComboBox<>();
        categoriaCombo.getItems().addAll(CategoriaTransaccion.values());
        categoriaCombo.setPromptText("Seleccione categoría");

        ComboBox<TipoTransaccion> tipoCombo = new ComboBox<>();
        tipoCombo.getItems().addAll(TipoTransaccion.values());
        tipoCombo.setPromptText("Seleccione tipo");

        TextField cuentaDestinoField = new TextField();
        cuentaDestinoField.setPromptText("ID Cuenta Destino (opcional)");

        // Validación en tiempo real
        montoField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*(\\.\\d*)?")) {
                montoField.setText(oldVal);
            }
        });

        // Layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0, new Label("Monto:"), montoField);
        grid.addRow(1, new Label("Descripción:"), descripcionField);
        grid.addRow(2, new Label("Categoría:"), categoriaCombo);
        grid.addRow(3, new Label("Tipo:"), tipoCombo);
        grid.addRow(4, new Label("Cuenta Destino:"), cuentaDestinoField);

        alert.getDialogPane().setContent(grid);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Validaciones
                if (montoField.getText().isEmpty() || descripcionField.getText().isEmpty() ||
                        categoriaCombo.getValue() == null || tipoCombo.getValue() == null) {
                    mostrarError("Complete todos los campos obligatorios");
                    return Optional.empty();
                }

                double monto = Double.parseDouble(montoField.getText());
                CuentaBanco destino = cuentaDestinoField.getText().isEmpty() ?
                        null : BilleteraVirtual.getInstance().buscarCuenta(cuentaDestinoField.getText());

                Transaccion nueva = new Transaccion(
                        LocalDateTime.now(),
                        monto,
                        descripcionField.getText(),
                        categoriaCombo.getValue(),
                        tipoCombo.getValue(),
                        AccesoUsuario.getCuenta_banco(),
                        destino
                );

                return Optional.of(nueva);

            } catch (NumberFormatException e) {
                mostrarError("Formato de monto inválido");
            } catch (Exception e) {
                mostrarError("Error: " + e.getMessage());
            }
        }
        return Optional.empty();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void agregarTransaccion(ActionEvent actionEvent) {
        crearTransaccionDialogo().ifPresent(nuevaTransaccion -> {
            if (!AccesoUsuario.getCuenta_banco().getTransacciones().contains(nuevaTransaccion)) {
                AccesoUsuario.getCuenta_banco().getTransacciones().add(nuevaTransaccion);
            } else {
                mostrarError("Esta transacción ya existe");
            }
        });
    }

}