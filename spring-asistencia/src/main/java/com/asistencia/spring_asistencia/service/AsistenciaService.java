/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.model.Asistencia;
import java.util.List;
import java.util.Optional;

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
    public int obtenerUltimaSemana(Integer idLugar, Integer idPrograma);
    public int obtenerUltimaSemanaLideres(Integer idLugar, Integer idPrograma);
    List<Object[]> obtenerSemanasUnicasCreandos(Integer idLugar, Integer idPrograma);
    List<Object[]> obtenerSemanasUnicasLideres(Integer idLugar, Integer idPrograma);
    public List<Asistencia> filtroLugarSemanaCreando(Integer idLugar, Integer idSemana);
    public Optional<Asistencia> mostrarPorIdAsistencia(Integer idPersona);
    public Asistencia savePorAsistencia(Asistencia asistencias);
    Optional<Asistencia> encontrarPorIdasistencia(Integer id);
    public List<Asistencia> filtroLugarSemanaLideres(Integer idLugar, Integer idSemana);
    public List<String> obtenerNombreSemanaPorLugar(Integer idLugar);
    public List<Integer> contarAsistenciasPorSemanaYEstado(Integer idLugar, String estadoAsistencia);
    public Integer contarCantidadDeCreandoActivos(Integer idLugar);
    public Integer contarCantidadDeCreandoDeBaja(Integer idLugar);
    public Integer actualizarEstado(Integer nuevoEstado,  Integer id);
    //OBTENER SEMA ACTUAL
    public Integer obtenerSemanasActuales( Integer idPrograma, Integer lugarId);

    public Integer obtenerIdSemana( Integer idPrograma,Integer ordenSemana);

    public Integer obtenerSemanasActualesLideres( Integer idPrograma, Integer lugarId);
}
