package com.example.projectofinal2.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PaginaPerfilController {
    public Label labelNombre;
    public Label labelCorreo;
    public Label labelTelefono;

    public PaginaPerfilController(Label labelNombre, Label labelCorreo, Label labelTelefono) {
        this.labelNombre = labelNombre;
        this.labelCorreo = labelCorreo;
        this.labelTelefono = labelTelefono;
    }


    public void editarPerfil(ActionEvent actionEvent) {



    }
}
