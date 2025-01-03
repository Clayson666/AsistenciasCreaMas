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
@Table(name="lugar")
public class Lugar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idLugar;
    private String nombreLugar;
    
    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL)
    private List<Persona> personas;
    

    public Lugar() {
    }

    public Lugar(Integer idLugar, String nombreLugar, List<Persona> personas) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.personas = personas;
    }

   
    
   
    public Integer getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public List<Persona> getPersona() {
        return personas;
    }

    public void setPersona(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Lugar{" + "idLugar=" + idLugar + ", nombreLugar=" + nombreLugar + ", personas=" + personas + '}';
    }


 
    
    
    
}
