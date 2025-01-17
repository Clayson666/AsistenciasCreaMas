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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer ordenSemana;

    @ManyToOne
    @JoinColumn(name = "idprograma", nullable = false)
    private Programa programa;
    
    @Column(name="fechaInicio", nullable=false)
    private LocalDate fechaInicio;

    @Column(name="fechaVencimiento", nullable=false)
    private LocalDate fechaVencimiento;
    
    
    @OneToMany (mappedBy = "asistencia")
    private List<Asistencia> asistencia;
    
    
    public Semana() {
    }
 


    public Semana(Integer idsemana, String nombreSemana, Integer ordenSemana, Programa programa, LocalDate fechaInicio,
            LocalDate fechaVencimiento, List<Asistencia> asistencia) {
        this.idsemana = idsemana;
        this.nombreSemana = nombreSemana;
        this.ordenSemana = ordenSemana;
        this.programa = programa;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
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

   


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }



    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }



    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }



    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }



    public Programa getPrograma() {
        return programa;
    }


    public void setPrograma(Programa programa) {
        this.programa = programa;
    }






    public Integer getOrdenSemana() {
        return ordenSemana;
    }






    public void setOrdenSemana(Integer ordenSemana) {
        this.ordenSemana = ordenSemana;
    }
    
    
    
    
}
