/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Semana;
import com.asistencia.spring_asistencia.repository.SemanaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class SemanaServiceImpl implements SemanaService {

    @Autowired
    SemanaRepository semanaRepository;

    @Override
    public Semana save(Semana semana) {
        return semanaRepository.save(semana);
    }

    @Override
    public Optional<Semana> get(Integer id) {
        return semanaRepository.findById(id);
    }

    @Override
    public void update(Semana semana) {
        semanaRepository.save(semana);
    }

    @Override
    public void delete(Integer id) {
        semanaRepository.deleteById(id);
    }

    @Override
    public List<Semana> findAll() {
        return semanaRepository.findAll();
           
    }

    @Override
    public int conteoDeSemanas(Integer idPrograma) {
       return semanaRepository.conteo(idPrograma);
    }

}
