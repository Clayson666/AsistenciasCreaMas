/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Persona;
import com.asistencia.spring_asistencia.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
     private PersonaRepository personaRepository;
    @Override
    public Persona save(Persona persona) {
     return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> get(Integer id) {
       return personaRepository.findById(id);
    }

    @Override
    public void update(Persona persona) {
        personaRepository.save(persona);
    }


    @Override
    public List<Persona> findAll() {
   return personaRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
    personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> findByLugarIdLugar(Integer id) {
        return personaRepository.findByLugarIdLugar(id);
    }

    

    
  
}
