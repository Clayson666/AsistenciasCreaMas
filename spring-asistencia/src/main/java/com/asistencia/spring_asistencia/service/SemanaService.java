/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Semana;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eulal
 */
public interface SemanaService {
    
    public Semana save(Semana semana);
    public Optional<Semana> get (Integer id);
    public void update(Semana semana);
    public void delete(Integer id);
    public List<Semana> findAll();
    public int conteoDeSemanas();
    
}
