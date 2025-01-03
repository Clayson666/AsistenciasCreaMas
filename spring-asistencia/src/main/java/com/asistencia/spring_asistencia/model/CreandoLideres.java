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
@Table(name = "creandoLideres")
public class CreandoLideres extends Persona {

    private String rol;

    public CreandoLideres() {
    }

    public CreandoLideres(String rol) {
        super();
        this.rol = rol;
    }

 
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "CreandoLideres{" + "rol=" + rol + '}';
    }

    
    
}
