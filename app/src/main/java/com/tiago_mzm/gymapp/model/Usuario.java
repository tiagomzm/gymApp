package com.tiago_mzm.gymapp.model;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    public Usuario(String nombreUsuario, String contraseña,String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}

