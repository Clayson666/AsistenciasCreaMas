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
    
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Persona> personas;
   
    public Programa() {
    }

    public Programa(Integer idprograma, String nombrePrograma, List<Persona> personas) {
        this.idprograma = idprograma;
        this.nombrePrograma = nombrePrograma;
        this.personas = personas;
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Programa{" + "idprograma=" + idprograma + ", nombrePrograma=" + nombrePrograma + ", personas=" + personas + '}';
    }
    
    
    
    
}
