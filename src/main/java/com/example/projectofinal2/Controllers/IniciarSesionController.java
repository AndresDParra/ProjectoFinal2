package com.example.projectofinal2.Controllers;

import com.example.projectofinal2.Applications;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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


    public IniciarSesionController(){
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
        stage.setTitle("Welcome to the UQ Library!");
        stage.setScene(scene);
        stage.show();
        
    }

    public void IniciarSesion(MouseEvent mouseEvent) {
    }

    public void IniciarSesionAdmin(ActionEvent actionEvent) {
    }
}
