/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author eulal
 */

@Entity
@Table(name = "semana")
public class Semana {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Integer idsemana;
    private String nombreSemana;
    
    @Column(name="fecha", nullable=false)
    private LocalDate fecha;
    
    
    @OneToMany (mappedBy = "asistencia")
    private List<Asistencia> asistencia;
    
    
    public Semana() {
    }

    public Semana(Integer idsemana, String nombreSemana, LocalDate fecha, List<Asistencia> asistencia) {
        this.idsemana = idsemana;
        this.nombreSemana = nombreSemana;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    
   
    

 

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getIdsemana() {
        return idsemana;
    }

    public void setIdsemana(Integer idsemana) {
        this.idsemana = idsemana;
    }

    public String getNombreSemana() {
        return nombreSemana;
    }

    public void setNombreSemana(String nombreSemana) {
        this.nombreSemana = nombreSemana;
    }

    @Override
    public String toString() {
        return "Semana{" + "idsemana=" + idsemana + ", nombreSemana=" + nombreSemana + ", asistencia=" + asistencia + '}';
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
