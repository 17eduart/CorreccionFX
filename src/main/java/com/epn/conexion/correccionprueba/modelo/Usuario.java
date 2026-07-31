package com.epn.conexion.correccionprueba.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable = false)
    private String correo_electronico;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String rol;

    public Usuario(){}

    public Usuario(String username, String password, String correo_electronico, String direccion, String rol) {
        this.username = username;
        this.password = password;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.rol = rol;
    }

    public Usuario(Integer id, String username, String password, String correo_electronico, String direccion, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", direccion='" + direccion + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
