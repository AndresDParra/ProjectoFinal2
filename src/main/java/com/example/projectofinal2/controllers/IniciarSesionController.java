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
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class IniciarSesionController {
    public TextField EspacioInicioSesion;
    public Text TextoParaRegistro;
    public Button ButtonAdministrador;
    public Text IniciarSesionButton;
    public Button ButtonIniciarSesion;

    public IniciarSesionController(TextField espacioInicioSesion, Text textoParaRegistro, Button buttonAdministrador, Text iniciarSesionButton, Button buttonIniciarSesion) {
        EspacioInicioSesion = espacioInicioSesion;
        TextoParaRegistro = textoParaRegistro;
        ButtonAdministrador = buttonAdministrador;
        IniciarSesionButton = iniciarSesionButton;
        ButtonIniciarSesion = buttonIniciarSesion;
    }

    public IniciarSesionController() {
    }

    public void IniciarRegistro(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("PaginaRegistro.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 480, 400);
        stage.setTitle("Welcome to Venequi");
        stage.setScene(scene);
        stage.show();

    }

    public void IniciarSesion(ActionEvent mouseEvent) throws IOException {
        System.out.println("CuentasBanco: " + BilleteraVirtual.getCuentasBanco());
        String numeroDeTelefono = EspacioInicioSesion.getText();
        if (!numeroDeTelefono.matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("numero de telefono incorrecto");
            alert.setHeaderText("Error de inicio de sesión");
            alert.setContentText("Introduce un numero de telefono correcto");
            alert.showAndWait();
            return;
        }
        boolean found = false;
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getUsuario().getTelefono().equals(numeroDeTelefono)) {
                FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("PaginaVerificacionPIN.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 480, 430);
                stage.setTitle("Welcome to Venequi");
                stage.setScene(scene);
                stage.show();
                found = true;
                break;
            }
        }
        if (!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de inicio de sesión");
            alert.setContentText("No se encontró una cuenta con ese número de teléfono");
            alert.showAndWait();
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
