package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.AccesoUsuario;
import com.example.projectofinal2.model.BilleteraVirtual;
import com.example.projectofinal2.model.CuentaBanco;
import com.example.projectofinal2.model.Presupuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginaPresupuestoController {
    public ListView<String> presupuestosListView;
    public Button ButtonAgregarPresupuesto;
    public Button ButtonEditarPresupuesto;
    public Presupuesto selectedPresupuesto;
    public TextField EspacioPresupuesto;
    public TextField EspacioNombrePresupuesto;

    public PaginaPresupuestoController() {
    }

    public void agregarPresupuesto(ActionEvent actionEvent) {

        if (EspacioPresupuesto.getText().isEmpty()) {
            // Aquí podrías mostrar un mensaje de error al usuario
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de entrada");
            alert.setHeaderText("Campo vacío");
            alert.setContentText("Por favor, introduce un valor para el presupuesto.");
            alert.showAndWait();
            return;
        } else {

            Presupuesto presupuesto = new Presupuesto(Integer.parseInt(EspacioPresupuesto.getText()), AccesoUsuario.getCuenta_banco(), EspacioNombrePresupuesto.getText());
            BilleteraVirtual.getPresupuestos().add(presupuesto);
            presupuestosListView.getItems().add("Presupuesto: " + presupuesto.getPresupuesto());
            presupuestosListView.refresh();

        }
    }

    public void listenerSelection() {
        presupuestosListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedPresupuesto = BilleteraVirtual.getPresupuestos().stream()
                        .filter(p -> p.getCuentaBanco().equals(AccesoUsuario.getCuenta_banco()))
                        .findFirst()
                        .orElse(null);
            } else {
                selectedPresupuesto = null;
            }
        });
    }

    public void editarPresupuesto(ActionEvent actionEvent) {
        selectedPresupuesto.setPresupuesto(Integer.parseInt(EspacioPresupuesto.getText()));
    }

    public void Initialize() {
        cargarPresupuestos();
        listenerSelection();
    }
    private void cargarPresupuestos() {
        presupuestosListView.getItems().clear();
        ObservableList<Presupuesto> presupuestos = FXCollections.observableArrayList(
                BilleteraVirtual.getInstance().usuarioPresupuestos(AccesoUsuario.getCuenta_banco().getUsuario()));
    }
}
