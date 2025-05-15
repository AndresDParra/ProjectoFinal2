package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.BilleteraVirtual;
import com.example.projectofinal2.model.CuentaBanco;
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

        IniciarSesionController iniciarSesionController = new IniciarSesionController();
        String telefono = iniciarSesionController.EspacioInicioSesion.getText();
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getUsuario().getTelefono().equals(telefono)) {
                labelNombre.setText(cuentaBanco.getUsuario().getNombre());
                labelCorreo.setText(cuentaBanco.getUsuario().getCorreo());
                labelTelefono.setText(cuentaBanco.getUsuario().getTelefono());
            }
        }

    }
}
