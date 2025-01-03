/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Asistencia;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

/**
 *
 * @author eulal
 */
public interface AsistenciaService {
    
    public void save (List<Asistencia> asistencias);
    public Optional<Asistencia> get (Integer id);
    public void update (Asistencia asistencia);
    public void delete (Integer id);
    public List<Asistencia> findAll();
    public void saveAllAsistencia(List<Asistencia> asistencias);
    public List<Asistencia> findByPersonaLugarIdLugar(Integer id);
    public void guardarAsistencias(List<Asistencia> asistencias, int semanaActual);
    public int obtenerUltimaSemana(Integer idLugar);
    public int obtenerUltimaSemanaLideres(Integer idLugar);
    List<Object[]> obtenerSemanasUnicasCreandos(Integer idLugar);
    List<Object[]> obtenerSemanasUnicasLideres(Integer idLugar);
    public List<Asistencia> filtroLugarSemanaCreando(Integer idLugar, Integer idSemana);
    public Optional<Asistencia> mostrarPorIdAsistencia(Integer idPersona);
    public Asistencia savePorAsistencia(Asistencia asistencias);
    Optional<Asistencia> encontrarPorIdasistencia(Integer id);
    public List<Asistencia> filtroLugarSemanaLideres(Integer idLugar, Integer idSemana);
    public List<String> obtenerNombreSemanaPorLugar(Integer idLugar);
    public List<Integer> contarAsistenciasPorSemanaYEstado(Integer idLugar, String estadoAsistencia);
    public Integer contarCantidadDeCreandoActivos(Integer idLugar);
    public Integer contarCantidadDeCreandoDeBaja(Integer idLugar);
}
