/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Creando;
import com.asistencia.spring_asistencia.model.CreandoLideres;
import com.asistencia.spring_asistencia.repository.LideresRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class LideresServiceImpl implements LideresService {

    @Autowired
    private LideresRepository lideresRepository;

    @Override
    public CreandoLideres save(CreandoLideres lideres) {

        return lideresRepository.save(lideres);
    }

    @Override
    public Optional<CreandoLideres> get(Integer id) {
        return lideresRepository.findById(id);
    }

    @Override
    public void update(CreandoLideres lideres) {

        lideresRepository.save(lideres);
    }

    @Override
    public void delete(Integer id) {
        lideresRepository.deleteById(id);
    }

    @Override
    public List<CreandoLideres> findAll() {
        return lideresRepository.findAll();
    }

    @Override
    public List<CreandoLideres> findByLugaridLugar(Integer id) {
        return lideresRepository.findByLugarIdLugar(id);
    }

}
