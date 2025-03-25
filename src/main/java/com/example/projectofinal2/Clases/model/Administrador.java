package com.example.projectofinal2.Clases.model;

public class Administrador {
    private String nombre;
    private String id;

    public Administrador(String nombre, String id, String contrasenia) {
        this.nombre = nombre;
        this.id = id;
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String contrasenia ;

}
