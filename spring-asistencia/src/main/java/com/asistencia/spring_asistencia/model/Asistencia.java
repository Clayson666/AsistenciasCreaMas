/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author eulal
 */
@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idasistencia;
    
    @ManyToOne
    private Persona persona;
    @ManyToOne
    private Semana semana;
    private Date fecha;
    private String asistencia;

    public Asistencia() {
    }

    public Asistencia(Integer idasistencia, Persona persona, Semana semana, Date fecha, String asistencia) {
        this.idasistencia = idasistencia;
        this.persona = persona;
        this.semana = semana;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

  

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idasistencia=" + idasistencia + ", persona=" + persona + ", semana=" + semana + ", fecha=" + fecha + ", asistencia=" + asistencia + '}';
    }
         
    
    
    
}
