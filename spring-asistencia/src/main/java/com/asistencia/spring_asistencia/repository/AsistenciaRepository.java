/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Asistencia;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eulal
 */
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findByPersonaLugarIdLugar(Integer id);

    @Query("SELECT a FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND a.semana.idsemana = :semanaId AND TYPE(a.persona) = Creando")
    List<Asistencia> filtroLugarSemanaCreando(@Param("lugarId") Integer idLugar, @Param("semanaId") Integer idSemana);

    @Query("SELECT a FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND a.semana.idsemana = :semanaId AND TYPE(a.persona) = CreandoLideres")
    List<Asistencia> filtroLugarSemanaLideres(@Param("lugarId") Integer idLugar, @Param("semanaId") Integer idSemana);

    @Query("SELECT a.semana.idsemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND TYPE (a.persona) = Creando ORDER BY a.semana.idsemana DESC ")
    List<Integer> listaDeSemanasPorLugar(@Param("lugarId") Integer idLugar, Pageable pageable);

    @Query("SELECT a.semana.idsemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND TYPE (a.persona) = CreandoLideres ORDER BY a.semana.idsemana DESC ")
    List<Integer> listaDeSemanasPorLugarLideres(@Param("lugarId") Integer idLugar, Pageable pageable);

    @Query("SELECT DISTINCT a.semana.idsemana, a.semana.nombreSemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND TYPE (a.persona) = Creando ORDER BY a.semana.idsemana DESC")
    List<Object[]> obtenerSemanasUnicasCreandos(@Param("lugarId") Integer idLugar);

    @Query("SELECT DISTINCT a.semana.idsemana, a.semana.nombreSemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND TYPE (a.persona) = CreandoLideres ORDER BY a.semana.idsemana DESC")
    List<Object[]> obtenerSemanasUnicasLideres(@Param("lugarId") Integer idLugar);

    @Query("SELECT a FROM Asistencia a JOIN a.persona p WHERE TYPE(p) = Creando AND a.idasistencia = :idAsistencia")
    Optional<Asistencia> mostrarPorIdAsistencia(@Param("idAsistencia") Integer idPersona);

    @Query("SELECT DISTINCT a.semana.nombreSemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId")
    List<String> obtenerNombreSemanaPorLugar(@Param("lugarId") Integer idLugar);

    @Query("SELECT COUNT(a.idasistencia) FROM Semana s LEFT JOIN Asistencia a ON a.semana = s.idsemana AND a.asistencia =:estadoAsistencia LEFT JOIN Persona p ON a.persona = p.idpersona LEFT JOIN lugar l ON p.lugar = l.idLugar AND l.idLugar = :lugarId GROUP BY s.idsemana")
    List<Integer> contarAsistenciasPorSemanaYEstado(@Param("lugarId") Integer idLugar, @Param("estadoAsistencia") String estadoAsistencia);

    @Query("SELECT COUNT(DISTINCT a.persona.idpersona) FROM Asistencia a WHERE a.persona.lugar.idLugar = :idLugar AND a.asistencia <> 'Baja'")
    Integer contarCantidadDeCreandoActivos(@Param("idLugar") Integer idLugar);
    
    
    @Query("SELECT COUNT(DISTINCT a.persona.idpersona) FROM Asistencia a WHERE a.persona.lugar.idLugar = :idLugar AND a.asistencia = 'Baja'")
    Integer contarCantidadDeCreandoDeBaja(@Param("idLugar") Integer idLugar);


}
