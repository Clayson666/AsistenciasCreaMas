/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Creando;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eulal
 */
public interface CreandosService {
    
    public Creando save(Creando creando);
    public Optional<Creando> get (Integer id);
    public void update (Creando creando);
    public void delete (Integer id);
    public List<Creando> findAll();
    public List<Creando> findByLugaridLugar(Integer id);
    
    
    
}
