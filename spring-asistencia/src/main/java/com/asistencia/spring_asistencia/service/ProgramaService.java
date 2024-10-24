/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;
import com.asistencia.spring_asistencia.model.Programa;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eulal
 */
public interface ProgramaService {
    
    public Programa save(Programa programa);
    public Optional<Programa> get (Integer id);
    public void update(Programa programa);
    public void delete(Integer id);
    public List<Programa> findAll();
    
}
