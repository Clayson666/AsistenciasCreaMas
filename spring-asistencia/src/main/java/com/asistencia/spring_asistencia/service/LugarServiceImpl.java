/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Lugar;
import com.asistencia.spring_asistencia.repository.LugarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class LugarServiceImpl implements LugarService {

    @Autowired
    private LugarRepository lugarRepository;

    @Override
    public Lugar save(Lugar lugar) {
        return lugarRepository.save(lugar);
    }

    @Override
    public Optional<Lugar> get(Integer id) {
        return lugarRepository.findById(id);
    }

    @Override
    public void update(Lugar lugar) {
        lugarRepository.save(lugar);
    }

    @Override
    public void delete(Integer id) {
        lugarRepository.deleteById(id);
    }

    @Override
    public List<Lugar> findAll() {
        return lugarRepository.findAll();
    }
    @Override
    public List<Lugar> lugarPorPrograma(Integer idPrograma){
        return lugarRepository.lugarPorPrograma(idPrograma);
    }

}
