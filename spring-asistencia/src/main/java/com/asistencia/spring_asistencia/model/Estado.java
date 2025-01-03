package com.asistencia.spring_asistencia.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreEstado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Persona> personas;

    public Estado (){

    }
    

    public Estado(Integer id, String nombreEstado, List<Persona> personas) {
        this.id = id;
        this.nombreEstado = nombreEstado;
        this.personas = personas;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    


    
    
}
