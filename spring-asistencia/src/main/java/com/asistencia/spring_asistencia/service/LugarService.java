/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Lugar;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eulal
 */
public interface LugarService {
    
    public Lugar save(Lugar lugar);
    public Optional<Lugar> get(Integer id);
    public void update (Lugar lugar);
    public void delete(Integer id);
    public List<Lugar> findAll();
    
    
}
