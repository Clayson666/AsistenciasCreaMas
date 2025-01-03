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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import java.util.List;

import jakarta.persistence.ManyToOne;

/**
 *
 * @author eulal
 */
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersona;
    private String dni;
    private String nombre;
    private String apellido; 
    private String celular;
    private String sexo;
    @ManyToOne
    @JoinColumn(name = "idPrograma")
    private Programa programa;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "idLugar")
    private Lugar lugar;
    @OneToMany(mappedBy = "asistencia")
    private List<Asistencia> asistencia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Estado estado;

    

    public Persona() {
    }

    public Persona(Integer idpersona, String dni, String nombre, String apellido, String celular, String sexo, Programa programa, Lugar lugar, List<Asistencia> asistencia) {
        this.idpersona = idpersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.sexo = sexo;
        this.programa = programa;
        this.lugar = lugar;
        this.asistencia = asistencia;
    }

   

 
   
  
  
    

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    
    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", sexo=" + sexo + ", programa=" + programa + ", lugar=" + lugar + ", asistencia=" + asistencia + '}';
    }

   
    

}
