package com.example.projectofinal2.controllers;

import com.example.projectofinal2.Applications;
import com.example.projectofinal2.model.BilleteraVirtual;
import com.example.projectofinal2.model.CuentaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class IniciarSesionController {
    public TextField EspacioInicioSesion;
    public Text TextoParaRegistro;
    public Button ButtonAdministrador;

    public IniciarSesionController(TextField espacioInicioSesion, Text textoParaRegistro) {
        EspacioInicioSesion = espacioInicioSesion;
        TextoParaRegistro = textoParaRegistro;
    }


    public IniciarSesionController() {
    }

    public TextField getEspacioInicioSesion() {
        return EspacioInicioSesion;
    }

    public void setEspacioInicioSesion(TextField espacioInicioSesion) {
        EspacioInicioSesion = espacioInicioSesion;
    }

    public Text getTextoParaRegistro() {
        return TextoParaRegistro;
    }

    public void setTextoParaRegistro(Text textoParaRegistro) {
        TextoParaRegistro = textoParaRegistro;
    }

    public void IniciarRegistro(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("PaginaRegistro.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);
        stage.setTitle("Welcome to Venequi");
        stage.setScene(scene);
        stage.show();

    }

    public void IniciarSesion(MouseEvent mouseEvent) throws IOException {
        String NumeroDeTelefono = EspacioInicioSesion.getText();
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            var existeEnCuentaRegistrada = cuentaBanco.getUsuario().getTelefono().equals(NumeroDeTelefono);
            if (existeEnCuentaRegistrada) {
                FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("PaginaSeleccionProductoODispositivo.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 480, 480);
                stage.setTitle("Welcome to Venequi");
                stage.setScene(scene);
                stage.show();
            } else if (cuentaBanco.getUsuario().getTelefono().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error de inicio de sesión");
                alert.setContentText("Por favor introduce un número de telefono valido");
                alert.showAndWait();

            } else if (!NumeroDeTelefono.matches("[0-9]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error de inicio de sesión");
                alert.setContentText("Por favor introduce un número de telefono valido");
                alert.showAndWait();

            }
        }

    }

    public void IniciarSesionAdmin(ActionEvent actionEvent) throws IOException {
        if (EspacioInicioSesion.getText().equals("0987654321")) {
            FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("Crud.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 480, 480);
            stage.setTitle("Welcome to Venequi");
            stage.setScene(scene);
            stage.show();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de inicio de sesión");
            alert.setContentText("Introduce el numero de telefono correcto");
            alert.showAndWait();
        }
    }
}
