/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author eulal
 */

@Entity
@Table(name="programa")
public class Programa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idprograma;
    private String nombrePrograma;

    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Semana> semanas;

    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Lugar> lugares;
   
    public Programa() {
    }




  


   
    public Programa(Integer idprograma, String nombrePrograma, List<Semana> semanas, List<Lugar> lugares) {
        this.idprograma = idprograma;
        this.nombrePrograma = nombrePrograma;
        this.semanas = semanas;
        this.lugares = lugares;
    }








    public Integer getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

   

    



    @Override
    public String toString() {
        return "Programa [idprograma=" + idprograma + ", nombrePrograma=" + nombrePrograma + ", semanas=" + semanas
                + ", lugares=" + lugares + "]";
    }


    public List<Semana> getSemanas() {
        return semanas;
    }


    public void setSemanas(List<Semana> semanas) {
        this.semanas = semanas;
    }

    
    
}
