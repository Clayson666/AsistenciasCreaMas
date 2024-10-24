/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Creando;
import com.asistencia.spring_asistencia.repository.CreandoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */

@Service

public class CreandosServiceImpl implements CreandosService{
    
    
    @Autowired CreandoRepository creandoRepository;

    @Override
    public Creando save(Creando creando) {
        return creandoRepository.save(creando);
    }

    @Override
    public Optional<Creando> get(Integer id) {
        
        return creandoRepository.findById(id);
        
    }

    @Override
    public void update(Creando creando) {
        creandoRepository.save(creando);
    }

    @Override
    public void delete(Integer id) {
         creandoRepository.deleteById(id);
    }

    @Override
    public List<Creando> findAll() {
        
        return creandoRepository.findAll();
        
         }

    @Override
    public List<Creando> findByLugaridLugar(Integer id) {
        
        return creandoRepository.findByLugarIdLugar(id);
           }
    
    
    
}
