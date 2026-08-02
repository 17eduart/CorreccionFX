package com.epn.conexion.correccionprueba.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "inventores")

public class Inventores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String pais;

    @Column(length = 11)
    private Integer nacimiento;

    @Column(length = 11)
    private Integer fallecimiento;

    @Column(length = 200)
    private String invento_principal;

    public Inventores() {}

    public Inventores(String nombre, String pais, Integer nacimiento, Integer fallecimiento, String invento_principal) {
        this.nombre = nombre;
        this.pais = pais;
        this.nacimiento = nacimiento;
        this.fallecimiento = fallecimiento;
        this.invento_principal = invento_principal;
    }

    public Inventores(Integer id, String nombre, String pais, Integer nacimiento, Integer fallecimiento, String invento_principal) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.nacimiento = nacimiento;
        this.fallecimiento = fallecimiento;
        this.invento_principal = invento_principal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public String getInvento_principal() {
        return invento_principal;
    }

    public void setInvento_principal(String invento_principal) {
        this.invento_principal = invento_principal;
    }

    @Override
    public String toString() {
        return "Inventores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", nacimiento=" + nacimiento +
                ", fallecimiento=" + fallecimiento +
                ", invento_principal='" + invento_principal + '\'' +
                '}';
    }
}
