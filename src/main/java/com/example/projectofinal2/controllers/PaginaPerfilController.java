package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.AccesoUsuario;
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

    /**
     * Método para editar el perfil del usuario.
     * Este método actualiza las etiquetas con la información del usuario actual.
     *
     * @param actionEvent Evento de acción que se dispara al editar el perfil.
     */
    public void editarPerfil(ActionEvent actionEvent) {

        labelNombre.setText(AccesoUsuario.getCuenta_banco().getUsuario().getNombre());
        labelCorreo.setText(AccesoUsuario.getCuenta_banco().getUsuario().getCorreo());
        labelTelefono.setText(AccesoUsuario.getCuenta_banco().getUsuario().getTelefono());

    }
}
