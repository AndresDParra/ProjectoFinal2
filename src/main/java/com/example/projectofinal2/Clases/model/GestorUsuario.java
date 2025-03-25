package com.example.projectofinal2.Clases.model;

import java.util.LinkedList;

public class GestorUsuario {
    private static GestorUsuario instance;
    private final LinkedList<Usuario> usuarios;
    private GestorUsuario(){usuarios = new LinkedList<>();}
    public static GestorUsuario getInstancia(){
        if (instance == null) {
            instance = new GestorUsuario();
        }
        return instance;
    }
}
