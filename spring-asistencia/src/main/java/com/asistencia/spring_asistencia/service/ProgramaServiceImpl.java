/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Programa;
import com.asistencia.spring_asistencia.repository.ProgramaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class ProgramaServiceImpl implements ProgramaService {
    @Autowired
    private ProgramaRepository programaRepository;
    
    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public Optional<Programa> get(Integer id) {
        return programaRepository.findById(id);
    }

    @Override
    public void update(Programa programa) {
        programaRepository.save(programa);
    }

    @Override
    public void delete(Integer id) {
        programaRepository.deleteById(id);
    }

    @Override
    public List<Programa> findAll() {
        return programaRepository.findAll();
    }
    
    @Override
    public Programa validarContrasena(Integer idPrograma, String contraseña){
        return programaRepository.validarContrasena(idPrograma, contraseña);
    }
    
    
}
