/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.model;

import java.util.List;

/**
 *
 * @author eulal
 */
public class AsistenciaForm {
    
    private List<Asistencia> asistencias;
    
    public AsistenciaForm(){
        
    }

    public AsistenciaForm(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "AsistenciaForm{" + "asistencias=" + asistencias + '}';
    }

   
    
}
