/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 *
 * @author eulal
 */
@Entity
@Table(name = "creando")
public class Creando extends Persona {

    private String rol;
    private String ciclo;
    private String taller;

    public Creando() {
    }

    public Creando(String rol, String ciclo, String taller) {
        super();

        this.rol = rol;
        this.ciclo = ciclo;
        this.taller = taller;

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    @Override
    public String toString() {
        return "Creando{" + "rol=" + rol + ", ciclo=" + ciclo + ", taller=" + taller + '}';
    }

}
