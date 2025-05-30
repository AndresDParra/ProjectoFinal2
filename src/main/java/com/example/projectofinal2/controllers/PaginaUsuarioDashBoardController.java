package com.example.projectofinal2.controllers;

import com.example.projectofinal2.Applications;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.Optional;

@Getter
public class PaginaUsuarioDashBoardController {

    public Button ButtonBienvenida;
    public Button ButtonPerfil;
    public Button ButtomTransacciones;
    public Button ButtonPresupuesto;
    public Button ButtonCerrarSesion;
    public StackPane contenidoPrincipal;

    public PaginaUsuarioDashBoardController(Button buttonBienvenida, Button buttonPerfil, Button buttomTransacciones, Button buttonPresupuesto, Button buttonCerrarSesion, StackPane contenidoPrincipal) {
        ButtonBienvenida = buttonBienvenida;
        ButtonPerfil = buttonPerfil;
        ButtomTransacciones = buttomTransacciones;
        ButtonPresupuesto = buttonPresupuesto;
        ButtonCerrarSesion = buttonCerrarSesion;
        this.contenidoPrincipal = contenidoPrincipal;
    }

    public PaginaUsuarioDashBoardController() {
    }

    public void setButtonBienvenida(Button buttonBienvenida) {
        ButtonBienvenida = buttonBienvenida;
    }

    public void setButtonPerfil(Button buttonPerfil) {
        ButtonPerfil = buttonPerfil;
    }

    public void setButtomTransacciones(Button buttomTransacciones) {
        ButtomTransacciones = buttomTransacciones;
    }

    public void setButtonPresupuesto(Button buttonPresupuesto) {
        ButtonPresupuesto = buttonPresupuesto;
    }

    public void setButtonCerrarSesion(Button buttonCerrarSesion) {
        ButtonCerrarSesion = buttonCerrarSesion;
    }

    public void setContenidoPrincipal(StackPane contenidoPrincipal) {
        this.contenidoPrincipal = contenidoPrincipal;
    }

    public void mostrarBienvenida(ActionEvent actionEvent) {
    }

    /**
     * Muestra el perfil del usuario en una nueva ventana.
     *
     * @param actionEvent Evento de acción del botón.
     * @throws IOException Si ocurre un error al cargar el FXML.
     */
    public void mostrarPerfil(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioPerfil.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Welcome to Venequi");
        stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        stage.show();
    }

    /**
     * Muestra las transacciones del usuario en una nueva ventana.
     *
     * @param actionEvent Evento de acción del botón.
     * @throws IOException Si ocurre un error al cargar el FXML.
     */
    public void mostrarTransacciones(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioTransacciones.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Transacciones");
        stage.setScene(new Scene(fxmlLoader.load(), 800, 750));
        stage.show();

        UsuarioTransaccionesController usuarioTransaccionesController = fxmlLoader.getController();
        usuarioTransaccionesController.initialize();
    }

    /**
     * Muestra la página de presupuestos del usuario en una nueva ventana.
     *
     * @param actionEvent Evento de acción del botón.
     * @throws IOException Si ocurre un error al cargar el FXML.
     */
    public void mostrarPresupuestos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("UsuarioPresupuesto.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Transacciones");
        stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        stage.show();

        PaginaPresupuestoController usuarioPresupuestoController = fxmlLoader.getController();
        usuarioPresupuestoController.Initialize();
    }

    /**
     * Cierra la sesión del usuario y regresa a la página de inicio de sesión.
     *
     * @param actionEvent Evento de acción del botón.
     */
    public void cerrarSesion(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Estás seguro de que quieres cerrar sesión?");
        alert.setContentText("Se cerrará tu sesión actual.");

        ButtonType buttonTypeYes = new ButtonType("Sí");
        ButtonType buttonTypeNo = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            Stage stage = (Stage) ButtonCerrarSesion.getScene().getWindow();
            stage.close();
            // Regresar a la página de inicio de sesión
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("IniciarSesion.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 630, 400);
                Stage newStage = new Stage();
                newStage.setTitle("Welcome to Venequi");
                newStage.setScene(scene);
                newStage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}