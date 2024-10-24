/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;
import com.asistencia.spring_asistencia.model.CreandoLideres;
import java.util.List;

/**
 *
 * @author eulal
 */
import java.util.Optional;
public interface LideresService {
    
    
    public CreandoLideres save(CreandoLideres lideres);
    public Optional<CreandoLideres> get(Integer id);
    public void update(CreandoLideres lideres);
    public void delete(Integer id);
    public List<CreandoLideres> findAll();
    
    
}
