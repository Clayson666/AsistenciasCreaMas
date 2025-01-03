/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Persona;
import jakarta.annotation.Resource;
import org.apache.catalina.connector.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author eulal
 */
public interface PersonaService {
    public Persona save(Persona persona);
    public Optional<Persona> get(Integer id);
    public void update(Persona persona);
    public void delete(Integer id);
    public List<Persona> findAll();
    public List<Persona> findByLugarIdLugar(Integer id);
   // public ResponseEntity<Resource> export(Integer idPersona);
    public Integer contarCreandosActivosBaja(Integer idLugar, Integer idEstado);

}
