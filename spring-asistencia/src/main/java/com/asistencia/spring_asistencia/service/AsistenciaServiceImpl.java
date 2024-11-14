/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Asistencia;
import com.asistencia.spring_asistencia.model.Semana;
import com.asistencia.spring_asistencia.repository.AsistenciaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author eulal
 */
@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public Optional<Asistencia> get(Integer id) {

        return asistenciaRepository.findById(id);
    }

    @Override
    public void update(Asistencia asistencia) {
        asistenciaRepository.save(asistencia);
    }

    @Override
    public void delete(Integer id) {
        asistenciaRepository.deleteById(id);
    }

    @Override
    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    @Override
    public void saveAllAsistencia(List<Asistencia> asistencias) {
        asistenciaRepository.saveAll(asistencias);
    }

    @Override
    public List<Asistencia> findByPersonaLugarIdLugar(Integer id) {

        return asistenciaRepository.findByPersonaLugarIdLugar(id);
    }

    @Override
    public void save(List<Asistencia> asistencias) {
        asistenciaRepository.saveAll(asistencias);
    }

    @Transactional
    @Override
    public void guardarAsistencias(List<Asistencia> asistencias, int semanaActual) {
        for (Asistencia asistencia : asistencias) {

            if (asistencia.getSemana() == null) {
                Semana semana = new Semana();
                semana.setIdsemana(semanaActual);
                asistencia.setSemana(semana);
            }

            if (asistencia.getFecha() == null) {
                asistencia.setFecha(new Date());
            }
            asistenciaRepository.save(asistencia);
        }
    }

    @Override
    public int obtenerUltimaSemana(Integer idLugar) {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "semana.idsemana"));
        List<Integer> resultados = asistenciaRepository.listaDeSemanasPorLugar(idLugar,pageable);
        return resultados.isEmpty() ? 0 : resultados.get(0); // Retorna 0 si no hay resultados
    }

    @Override
    public List<Object[]> obtenerSemanasUnicas(Integer idLugar) {
        return asistenciaRepository.obtenerSemanasUnicas(idLugar);
    }

    @Override
    public List<Asistencia> filtroLugarSemana(Integer idLugar, Integer idSemana) {
          
        return asistenciaRepository.filtroLugarSemana(idLugar, idSemana);
    
    }

    @Override
    public Optional<Asistencia> mostrarPorIdAsistencia(Integer idPersona){
        return asistenciaRepository.mostrarPorIdAsistencia(idPersona);
    }



 

    
    
    
}
